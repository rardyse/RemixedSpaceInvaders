package view;

import oop.lib.Painting;
import util.Point;
import java.awt.Rectangle;
import java.awt.*;

public abstract class Sprite implements Representation {

    /**
     * x and y-coordinate of the whole sprite
     */
    private Point pos;

    /**
     * Image representing the sprite
     */
    private final Image image;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    //////////////////////////////////////////////////////////////////////
    public Sprite(Image img, Point pos) {
        this.pos = pos;
        this.image = img;
    }

    //////////////////////////////////////////////////////////////////////
    // PUBLIC
    //////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Painting painting) {
        painting.drawImage(image, pos.asArray());
    }

    public Rectangle getBoundingBox() {
        return new Rectangle((int) pos.x(), (int) pos.y(), getWidth(), getHeight());
    }

    public boolean checkCollision(Sprite other) {
        return getBoundingBox().intersects(other.getBoundingBox());
    }

    //////////////////////////////////////////////////////////////////////
    // GETTERS & SETTERS
    //////////////////////////////////////////////////////////////////////

    public int getWidth() {
        return image.getWidth(null);
    }

    public int getHeight() {
        return image.getHeight(null);
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }
}