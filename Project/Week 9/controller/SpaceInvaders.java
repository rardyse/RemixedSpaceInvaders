package Serie_9.project.controller;

import oop.lib.Animation;
import Serie_9.project.model.Direction;
import Serie_9.project.model.enemy.AlienShip;
import Serie_9.project.model.enemy.Enemy;
import Serie_9.project.model.player.Player;
import Serie_9.project.model.shot.Shot;
import Serie_9.project.util.MyLinkedList;
import Serie_9.project.util.MyOrderedLinkedList;
import Serie_9.project.util.Point;
import Serie_9.project.view.Board;

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

        SwingUtilities.invokeLater(() -> {
            getFrame().addKeyListener(new KeyAdapter() {
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
                            shots.addAll(player.attack());
                            break;
                    }
                }
            });
            getFrame().requestFocusInWindow();
        });
    }

    @Override
    public void step() {
        moveEnemies();
        moveShots();
        enemiesAttack();
    }

    private void moveEnemies() {
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

    private void moveShots() {
        for (Shot shot : shots) {
            shot.move();
        }
    }

    private void enemiesAttack() {
        for (Enemy enemy : enemies) {
            for (Shot attack : enemy.attack()) {
                if (attack != null) {
                    shots.add(attack);
                }
            }
        }
    }
}