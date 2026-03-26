package serie5.Project.View;

import java.awt.*;
import oop.lib.Paintable;
import oop.lib.Painting;
import serie5.Project.Model.Point;
import serie5.Project.Model.Vector;

public abstract class Sprite implements Paintable {

    private Point position;
    private Image image;

    public Sprite(Image image, int x, int y) {
        this.position = new Point(x, y);
        this.image = image;
    }

    @Override
    public void paint(Painting painting) {
        painting.drawImage(image, (int) position.getX(), (int) position.getY());
    }

    public boolean checkCollision(Sprite sprite) {
        return false;
    }

    public void translate(Vector v) {
        position.translate(v);
    }

    public double getX() { return position.getX(); }
    public double getY() { return position.getY(); }

    public void setX(double x) { position.translate(new Vector(x - position.getX(), 0)); }
    public void setY(double y) { position.translate(new Vector(0, y - position.getY())); }

    public int getWidth()  { return image.getWidth(null); }
    public int getHeight() { return image.getHeight(null); }
}