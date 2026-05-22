package project.model.player;

import project.model.Attacker;
import project.model.Direction;
import project.model.Hittable;
import project.model.Moveable;
import project.model.shot.Bullet;
import project.model.shot.Shot;
import project.util.MyLinkedList;
import project.view.Sprite;
import project.util.Point;
import project.util.Vector;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Player extends Sprite implements Hittable, Moveable, Attacker {

    private int healthPoints = 5;
    private long lastShot;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    public Player(Point pos) throws IOException {
        super(ImageIO.read(Player.class.getResource("/resources/player.png")),
                pos);
    }

    //////////////////////////////////////////////////////////////////////
    // HITTABLE
    //////////////////////////////////////////////////////////////////////
    @Override
    public void gotHit(Shot shot) {
        if(healthPoints <= 0) {
            throw new IllegalStateException("The player is already dead... ");
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
                getPos().translate(new Vector(-5, 0));
                break;
            case RIGHT:
                getPos().translate(new Vector(5, 0));
                break;
            default:
                throw new RuntimeException("Invalid direction for Player: " + direction);
        }
    }

    //////////////////////////////////////////////////////////////////////
    // ATTACKER
    //////////////////////////////////////////////////////////////////////
    @Override
    public MyLinkedList<Shot> attack() {
        MyLinkedList<Shot> shots = new MyLinkedList<>();

        int cooldown = 800;  //Plus on augmente, plus le joueur va tirer moins rapidement
        if (System.currentTimeMillis() - lastShot > cooldown) {
            try {
                shots.add(new Bullet(
                        new Point(getPos().x() + getWidth() / 2., getPos().y()),
                        Direction.UP
                ));
            } catch (IOException e) {
                e.printStackTrace();
            }
            lastShot = System.currentTimeMillis();
        }

        return shots;
    }
}