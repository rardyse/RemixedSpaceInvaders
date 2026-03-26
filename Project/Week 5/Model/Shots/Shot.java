package serie5.Project.Model.Shots;

import serie5.Project.View.Sprite;
import serie5.Project.Model.Vector;
import java.awt.Image;

public abstract class Shot extends Sprite {
    private final String direction;
    private final int damage;

    public Shot(int x, int y, Image image, String direction, int damage) {
        super(image, x, y);
        this.direction = direction;
        this.damage = damage;
    }

    public void move() {
        switch (direction) {
            case "UP":
                setY(getY() - 5);
                break;
            case "DOWN":
                setY(getY() + 5);
                break;
        }
    }
}