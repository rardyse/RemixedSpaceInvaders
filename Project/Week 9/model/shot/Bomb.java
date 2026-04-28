package Serie_9.project.model.shot;

import Serie_9.project.model.Direction;
import Serie_9.project.util.Point;
import Serie_9.project.util.Vector;

import javax.imageio.ImageIO;
import java.io.IOException;

//attaque de l'ennemi

public class Bomb extends Shot {

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    public Bomb(Point pos, Direction direction) throws IOException {
        super(ImageIO.read(Bomb.class.getResource("/shotenemy.png")),
                pos, direction, 1);
    }

    //////////////////////////////////////////////////////////////////////
    // PUBLIC
    //////////////////////////////////////////////////////////////////////
    @Override
    public void move() {
        int y_VELOCITY = 1;
        switch (direction) {
            case UP:
                getPos().translate(new Vector(0, -y_VELOCITY));
                break;
            case DOWN:
                getPos().translate(new Vector(0, y_VELOCITY));
                break;
        }
    }
}