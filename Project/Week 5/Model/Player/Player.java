package serie5.Project.Model.Player;

import serie5.Project.Model.List.ShotList;
import serie5.Project.Model.Shots.Shot;
import serie5.Project.View.Sprite;
import serie5.Project.Model.Shots.Hittable;
import serie5.Project.Model.Shots.Moveable;
import serie5.Project.Model.Shots.Attacker;
import serie5.Project.Model.Vector;
import java.awt.Image;

public abstract class Player extends Sprite implements Attacker, Hittable, Moveable {
    private int points = 3;
    private long lastShot;
    private int cooldown = 400;

    public Player(int x, int y, Image image, int speedX, int speedY) {
        super(image, x, y);
    }

    @Override
    public void move(String direction) {
        switch (direction) {
            case "LEFT":
                translate(new Vector(-10, 0));
                break;
            case "RIGHT":
                translate(new Vector(10, 0));
                break;
            default:
                throw new RuntimeException("Invalid direction: " + direction);
        }
    }

    @Override
    public void isHit(Shot shot) { }

    @Override
    public boolean isDead() { return false; }

    @Override
    public void attack() { }
}