//4.1
package Project;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public abstract class Enemy extends Sprite implements Shootable {
    private int points;
    private int speed;

    public Enemy(int x, int y, Image image, int points, int speed){
        super(image, x, y);
        this.points = points;
        this.speed = speed;
    }

    public int getPoints() {
        return points;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void move(String direction){
        switch (direction) {
            case "LEFT" -> setX(getX() - speed);
            case "RIGHT" -> setX(getX() + speed);
            case "DOWN" -> setY(getY() + speed);
        }
    }

    @Override
    public void shoot(){
    }

    @Override
    public boolean isHit(){
        return false;
    }
}
