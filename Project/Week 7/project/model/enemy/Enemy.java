package Serie_7.project.model.enemy;

import Serie_7.project.model.Attacker;
import Serie_7.project.model.Direction;
import Serie_7.project.model.Hittable;
import Serie_7.project.model.Moveable;
import Serie_7.project.model.shot.Shot;
import Serie_7.project.util.MyLinkedList;
import Serie_7.project.view.Sprite;
import Serie_7.project.util.Point;
import Serie_7.project.util.Vector;

import java.awt.*;
import java.util.Random;

public abstract class Enemy extends Sprite implements Attacker, Hittable, Moveable {

    private final int descentStep;
    private int healthPoints;
    static final Random random = new Random();

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    Enemy(Image alienImg, Point pos, int descentStep, int healthPoints) {
        super(alienImg, pos);
        this.descentStep = descentStep;
        this.healthPoints = healthPoints;
    }

    //////////////////////////////////////////////////////////////////////
    // HITTABLE
    //////////////////////////////////////////////////////////////////////
    @Override
    public void gotHit(Shot shot) {}

    @Override
    public boolean isDead() {
        return false;
    }

    //////////////////////////////////////////////////////////////////////
    // MOVEABLE
    //////////////////////////////////////////////////////////////////////
    @Override
    public void move(Direction direction) {
        switch (direction) {
            case LEFT:
                getPos().translate(new Vector(-1, 0));
                break;
            case RIGHT:
                getPos().translate(new Vector(1, 0));
                break;
            case DOWN:
                getPos().translate(new Vector(0, descentStep));
                break;
            default:
                throw new RuntimeException("Invalid direction for Enemy: " + direction);
        }
    }

    //////////////////////////////////////////////////////////////////////
    // ATTACKER
    //////////////////////////////////////////////////////////////////////
    @Override
    public abstract MyLinkedList<Shot> attack();
}