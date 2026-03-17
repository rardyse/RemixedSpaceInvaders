package Project;

import oop.lib.Animation;
import java.awt.*;

public class Tester extends Animation {

    private Player player;
    private SpriteList enemies;
    private PlayerShot playerShot;
    private String enemyDirection = "RIGHT";

    public Tester() {
        Image playerImg = Toolkit.getDefaultToolkit().getImage("src/Serie 4/Project/sprites/player.png");
        Image enemyImg  = Toolkit.getDefaultToolkit().getImage("src/Serie 4/Project/sprites/enemy.png");
        Image shotImg   = Toolkit.getDefaultToolkit().getImage("src/Serie 4/Project/sprites/shot.png");

        player = new Player(350, 500, playerImg, 3, 5);

        enemies = new SpriteList();
        enemies.add(new EnemyShot(100, 80, enemyImg, 3));
        enemies.add(new EnemyShot(250, 80, enemyImg, 3));
        enemies.add(new EnemyShot(400, 80, enemyImg, 3));

        playerShot = new PlayerShot(350, 480, shotImg, -1, 7);

        add(player);
        for (int i = 0; i < enemies.getSize(); i++) {
            add(enemies.get(i));
        }
        add(playerShot);

        init();
        launch(true);
    }

    @Override
    public void step() {
        player.move("RIGHT");
        if (player.getX() > 650) player.setX(0);

        for (int i = 0; i < enemies.getSize(); i++) {
            enemies.get(i).move(enemyDirection);
        }
        if (enemies.get(0).getX() > 650) enemyDirection = "LEFT";
        if (enemies.get(0).getX() < 0)   enemyDirection = "RIGHT";

        playerShot.move("UP");
        if (playerShot.getY() < 0) playerShot.setY(500);
    }

    public static void main(String[] args) {
        new Tester();
    }
}