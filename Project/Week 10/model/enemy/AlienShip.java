package model.enemy;

import model.Direction;
import model.shot.Bomb;
import model.shot.Shot;
import util.MyLinkedList;
import util.Point;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AlienShip extends Enemy {

    public final static Point ALIEN_INIT_POS = new Point(150, 5);
    private final static double FIRE_CHANCE = 0.005;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    public AlienShip(Point pos) throws IOException {
        super(ImageIO.read(AlienShip.class.getResource("/enemy.png")),
                pos, 15, 1);
    }

    //////////////////////////////////////////////////////////////////////
    // ATTACKER
    //////////////////////////////////////////////////////////////////////
    @Override
    public MyLinkedList<Shot> attack() {
        MyLinkedList<Shot> shots = new MyLinkedList<>();

        if (random.nextDouble() < FIRE_CHANCE) {
            try {
                shots.add(new Bomb(
                        new Point(getPos().x() + getWidth() / 2., getPos().y() + getHeight()),
                        Direction.DOWN
                ));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return shots;
    }
}