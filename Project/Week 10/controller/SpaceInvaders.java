package controller;

import view.Animation;
import model.Direction;
import model.enemy.AlienShip;
import model.enemy.Enemy;
import model.player.Player;
import model.shot.Shot;
import util.MyLinkedList;
import util.MyOrderedLinkedList;
import util.Point;
import view.Board;

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

    private SpaceInvaders() {}

    public static void main(String[] args) {
        new SpaceInvaders().launch(true);
    }


    @Override
    public void init() {
        super.init();

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

        KeyAdapter keyAdapter = new KeyAdapter() {
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
                }
            }
        };

        board.addKeyListener(keyAdapter);
        getFrame().addKeyListener(keyAdapter);
    }

    @Override
    public void step() {
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
                        shotsToRemove.add(shot);
                        break;
                    }
                }
            }

            // tir de l'ennemi vers le bas
            if (shot.getDirection() == Direction.DOWN) {
                if (!player.isDead() && player.checkCollision(shot)) {
                    player.gotHit(shot);
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
            System.out.println("You won!");
        }

        //game overrrrr
        if (player.isDead()) {
            board.setGameOver(true);
            System.out.println("Game over!!!!!");
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