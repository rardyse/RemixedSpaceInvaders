package project.model.enemy;

import project.model.Attacker;
import project.model.Direction;
import project.model.Hittable;
import project.model.Moveable;
import project.model.shot.Shot;
import project.util.MyLinkedList;
import project.view.Sprite;
import project.util.Point;
import project.util.Vector;

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
    public void gotHit(Shot shot) {
        if(healthPoints <= 0){
            throw new IllegalStateException("The ennemy is already dead...");
        }
        healthPoints -= shot.damage;
    }

    @Override
    public boolean isDead() {
        return healthPoints <= 0;
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
