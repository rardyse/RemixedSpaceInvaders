package Serie_8.project.controller;

import oop.lib.Animation;
import Serie_8.project.model.Direction;
import Serie_8.project.model.enemy.AlienShip;
import Serie_8.project.model.enemy.Enemy;
import Serie_8.project.model.player.Player;
import Serie_8.project.model.shot.Shot;
import Serie_8.project.util.MyLinkedList;
import Serie_8.project.util.Point;
import Serie_8.project.view.Board;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class SpaceInvaders extends Animation {

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 600;
    private MyLinkedList<Shot> shots;
    private MyLinkedList<Enemy> enemies;
    private Player player;
    private Board board;

    private SpaceInvaders() {
    }

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

        //KeyAdapter anonyme
        board.addKeyListener(new KeyAdapter() {

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

        board.setFocusable(true);
        board.requestFocusInWindow();

        setDisplay(board);
    }

    private Direction enemyDirection = Direction.RIGHT;

    @Override
    protected void step() {
        for (Enemy enemy : enemies) {
            enemy.move(enemyDirection);
            shots.addAll(enemy.attack());
        }

        //solution de l'enemy car ils disparaissaient sans revenir, donc là ça les refait avancer en lignée puis revenir
        for (Enemy enemy : enemies) {
            if (enemy.getPos().x() > BOARD_WIDTH - 100) {
                enemyDirection = Direction.LEFT;
            } else if (enemy.getPos().x() < 50) {
                enemyDirection = Direction.RIGHT;
            }
        }

        for (Shot shot : shots) {
            shot.move();
        }
    }
}