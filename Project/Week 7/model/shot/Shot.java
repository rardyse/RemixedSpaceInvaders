package Serie_7.project.model.shot;

import Serie_7.project.model.Direction;
import Serie_7.project.view.Sprite;
import Serie_7.project.util.Point;

import java.awt.*;

public abstract class Shot extends Sprite {

    final Direction direction;
    public final int damage;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    Shot(Image img, Point pos, Direction direction, int damage) {
        super(img, pos);
        this.direction = direction;
        this.damage = damage;
    }

    //////////////////////////////////////////////////////////////////////
    // ABSTRACT
    //////////////////////////////////////////////////////////////////////
    abstract public void move();
}