package serie5.Project.Model.Enemy;

import serie5.Project.Model.List.ShotList;
import serie5.Project.View.Sprite;
import serie5.Project.Model.Shots.Shot;
import serie5.Project.Model.Shots.Hittable;
import serie5.Project.Model.Shots.Moveable;
import serie5.Project.Model.Shots.Attacker;
import java.awt.*;
import java.util.Random;

public abstract class Enemy extends Sprite implements Attacker, Hittable, Moveable {
    private final int descentStep;
    static final Random random = new Random();

    public Enemy(int x, int y, Image image, int descentStep){
        super(image, x, y);
        this.descentStep = descentStep;
    }

    @Override
    public void move(String direction){
        switch (direction) {
            case "LEFT":
                setX(getX() - 1);
                break;
            case "RIGHT":
                setX(getX() + 1);
                break;
            case "DOWN":
                setY(getY() + descentStep);
                break;
            default:
                throw new RuntimeException("Invalid direction");
        }
    }

    @Override
    public void isHit(Shot shot){ }

    public boolean isDead() { return false; }

    public ShotList Attack(){ return null; }
}