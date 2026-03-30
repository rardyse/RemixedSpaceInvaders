package Serie_6.project.model.enemy;

import Serie_6.project.model.Direction;
import Serie_6.project.model.shot.Bomb;
import Serie_6.project.util.ShotList;
import Serie_6.project.util.Point;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AlienShip extends Enemy {

    public final static Point ALIEN_INIT_POS = new Point(150, 5);
    private final static double FIRE_CHANCE = 0.005;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    public AlienShip(Point pos) throws IOException {
        super(ImageIO.read(AlienShip.class.getResource("/Serie_6/project/resources/enemy.png")),
                pos, 15, 1);
    }

    //////////////////////////////////////////////////////////////////////
    // ATTACKER
    //////////////////////////////////////////////////////////////////////
    @Override
    public ShotList attack() {
        ShotList shots = new ShotList();
        if (random.nextDouble() < FIRE_CHANCE) {
            try {
                shots.add(new Bomb(new Point(getPos().x() + getWidth() / 2., getPos().y() + getHeight()), Direction.DOWN));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return shots;
    }
}