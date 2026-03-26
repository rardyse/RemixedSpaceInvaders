package serie5.Project;

import serie5.Project.Model.Player.Player;
import serie5.Project.Model.Player.PlayerShot;
import serie5.Project.Model.Enemy.Enemy;
import serie5.Project.Model.Enemy.EnemyShot;
import serie5.Project.Model.List.SpriteList;
import serie5.Project.Model.Shots.Shot;
import serie5.Project.Model.List.ShotList;
import serie5.Project.Model.Point;
import serie5.Project.Model.Vector;
import oop.lib.Animation;
import java.awt.*;

public class Tester extends Animation {

    private Player player;
    private SpriteList enemies;
    private PlayerShot playerShot;
    private String enemyDirection = "RIGHT";

    public Tester() {
        Image playerImg = Toolkit.getDefaultToolkit().getImage("src/Serie 5/Project/sprites/player.png");
        Image enemyImg  = Toolkit.getDefaultToolkit().getImage("src/Serie 5/Project/sprites/enemy.png");
        Image shotImg   = Toolkit.getDefaultToolkit().getImage("src/Serie 5/Project/sprites/shot.png");

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
        System.out.println("=== Game Object Tester ===\n");

        PointAndVector();
        PlayerMove();
        EnemyMoveHorizontal();
        EnemyMoveDescent();
        ShotMoveUp();
        ShotMoveDown();

        System.out.println("\nAll tests passed");
    }

    //helper
    public static void check(String label, double expected, double actual){
        if (Double.compare(expected, actual) == 0)
            throw new AssertionError(label + "expected" + expected + "got" + actual);
        System.out.println("PASS: " + label + " = " + actual);
    }

    private static void section (String title){
        System.out.println("Section " + title);
    }

    //tests
    private static void PointAndVector() {
        section("Point.translate() with Vector");
        Point point = new Point(50, 90);
        point.translate(new Vector(30, 60));
        check("x after translate", 80, point.getX());
        check("y after translate", 150, point.getY());

        point.translate(new Vector(20, 70));
        check("x after translate", 100, point.getX());
        check("y after translate", 220, point.getY());
    }



    private static void PlayerMove() { }

    private static void EnemyMoveHorizontal() { }

    private static void EnemyMoveDescent() { }

    private static void ShotMoveUp() { }

    private static void ShotMoveDown() { }

}