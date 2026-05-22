package project.controller;

import project.util.Sound;
import project.view.Animation;
import project.model.Direction;
import project.model.enemy.AlienShip;
import project.model.enemy.Enemy;
import project.model.player.Player;
import project.model.shot.Shot;
import project.util.MyLinkedList;
import project.util.MyOrderedLinkedList;
import project.util.Point;
import project.view.Board;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.SwingUtilities;

public class SpaceInvaders extends Animation {

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 600;
    private MyLinkedList<Shot> shots;
    private MyLinkedList<Enemy> enemies;
    private Player player;
    private Board board;
    private Direction enemyDirection = Direction.RIGHT;
    private Sound backgroundSound;
    private Sound gameOverSound;
    private Sound victorySound;



    private SpaceInvaders() {}

    public static void main(String[] args) {
        new SpaceInvaders().launch(true);
    }

    private KeyAdapter keyAdapter ;

    @Override
    public void init() {
        super.init();

        enemyDirection = Direction.RIGHT;
        shots = new MyLinkedList<>();
        enemies = new MyLinkedList<>();

        try {
            player = new Player(new Point(400, 500));

            for (int row = 0; row < 2; row++) {
                for (int col = 0; col < 5; col++) {
                    Point pos = new Point(100 + col * 100, 50 + row * 80);
                    enemies.add(new AlienShip(pos));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        board = new Board(BOARD_WIDTH, BOARD_HEIGHT, player, enemies, shots);
        board.setFocusable(true);
        setDisplay(board);

        try {
            backgroundSound = new Sound("background.wav");
            backgroundSound.playInLoop();
            gameOverSound = new Sound("gameover.wav");
            victorySound = new Sound("victory.wav");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(keyAdapter == null) {
            keyAdapter = new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            player.move(Direction.LEFT);
                            break;
                        case KeyEvent.VK_RIGHT:
                            player.move(Direction.RIGHT);
                            break;
                        case KeyEvent.VK_SPACE:
                            MyLinkedList<Shot> newShots = player.attack();
                            if (newShots.size() > 0) {
                                shots.add(newShots.get(0));
                            }
                            break;
                        case KeyEvent.VK_R:
                            if (backgroundSound != null) backgroundSound.stop();
                            init();
                            //rejouer au jeu
                            getFrame().getContentPane().removeAll();
                            getFrame().add(board);
                            getFrame().repaint();
                            getFrame().revalidate();
                            board.requestFocusInWindow();
                            board.addKeyListener(keyAdapter);
                            break;
                        case KeyEvent.VK_E:
                            System.exit(0);
                            break;
                    }
                }
            };
            getFrame().addKeyListener(keyAdapter);

        };

        board.addKeyListener(keyAdapter);
    }

    @Override
    public void step() {
        if (board.isGameOver() || board.isVictory()) return;
        resolveShotsCollisions();
        moveEnemies();
        moveShots();
        enemiesAttack();
    }

    private void moveEnemies() {
        if (enemies.isEmpty()) return; //rajout en cas de bug à la fin

        MyOrderedLinkedList<Integer> xCoordinates = new MyOrderedLinkedList<>();
        for (Enemy enemy : enemies) {
            xCoordinates.add((int) enemy.getPos().x());
        }

        for (Enemy enemy : enemies) {
            enemy.move(enemyDirection);
        }

        if (xCoordinates.getMax() >= BOARD_WIDTH - enemies.get(0).getWidth()) {
            enemyDirection = Direction.LEFT;
            for (Enemy enemy : enemies) {
                enemy.move(Direction.DOWN);
            }
        } else if (xCoordinates.getMin() <= 0) {
            enemyDirection = Direction.RIGHT;
            for (Enemy enemy : enemies) {
                enemy.move(Direction.DOWN);
            }
        }
    }

    private void resolveShotsCollisions() {
        MyLinkedList<Shot> shotsToRemove = new MyLinkedList<>();
        MyLinkedList<Enemy> enemiesToRemove = new MyLinkedList<>();

        for (Shot shot : shots) {
            if (shot == null) continue;

            //tir du joueur vers le haut
            if (shot.getDirection() == Direction.UP) {
                for (Enemy enemy : enemies) {
                    if (!enemy.isDead() && enemy.checkCollision(shot)) {
                        enemy.gotHit(shot);
                        board.setScore(board.getScore() + 100);
                        shotsToRemove.add(shot);
                        break;
                    }
                }
            }

            // tir de l'ennemi vers le bas
            if (shot.getDirection() == Direction.DOWN) {
                if (!player.isDead() && player.checkCollision(shot)) {
                    player.gotHit(shot);
                    board.setLives(board.getLives() - 1);
                    shotsToRemove.add(shot);
                }
            }

            // shots hors écran
            if (shot.getPos().y() < 0 || shot.getPos().y() > BOARD_HEIGHT) {
                shotsToRemove.add(shot);
            }
        }

        //enlever les shots
        if (shotsToRemove.size() > 0) {
            for (int i = 0; i < shotsToRemove.size(); i++) {
                shots.remove(shotsToRemove.get(i));
            }
        }

        //checker sur les ennemis morts
        for (Enemy enemy : enemies) {
            if (enemy.isDead()) {
                enemiesToRemove.add(enemy);
            }
        }

        //enlever ennemies morts
        for (int i = 0; i < enemiesToRemove.size(); i++) {
            enemies.remove(enemiesToRemove.get(i));
        }

        //victoryyyyy
        if (enemies.isEmpty()) {
            board.setVictory(true);
            if (backgroundSound != null) backgroundSound.stop();
            if (victorySound != null) victorySound.play();
            System.out.println("You won!");
            return ;
        }

        //game overrrrr
        if (player.isDead()) {
            board.setGameOver(true);
            if (backgroundSound != null) backgroundSound.stop();
            if (gameOverSound != null) gameOverSound.play();
            System.out.println("Game over!!!!!");
            return ;
        }
    }

    private void moveShots() {
        for (Shot shot : shots) {
            shot.move();
        }
    }

    private void enemiesAttack() {
        for (Enemy enemy : enemies) {
            MyLinkedList<Shot> enemyShots = enemy.attack();
            if (enemyShots.size() > 0) {
                shots.add(enemyShots.get(0));
            }
        }
    }
}