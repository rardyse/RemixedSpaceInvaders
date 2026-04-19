package Serie_7.project.model.player;

import Serie_7.project.model.Attacker;
import Serie_7.project.model.Direction;
import Serie_7.project.model.Hittable;
import Serie_7.project.model.Moveable;
import Serie_7.project.model.shot.Bullet;
import Serie_7.project.model.shot.Shot;
import Serie_7.project.util.MyLinkedList;
import Serie_7.project.view.Sprite;
import Serie_7.project.util.Point;
import Serie_7.project.util.Vector;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Player extends Sprite implements Hittable, Moveable, Attacker {

    private int healthPoints = 5;
    private long lastShot;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    public Player(Point pos) throws IOException {
        super(ImageIO.read(Player.class.getResource("/Serie_7/project/resources/player.png")),
                pos);
    }

    //////////////////////////////////////////////////////////////////////
    // HITTABLE
    //////////////////////////////////////////////////////////////////////
    @Override
    public void gotHit(Shot shot) {
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

        int cooldown = 500;
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