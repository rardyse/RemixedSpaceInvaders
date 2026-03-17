//4.1
package Project;

import java.awt.Image;

public abstract class Shot extends Sprite {
    private int direction;
    private int speed;

    public Shot(int x, int y, Image image, int direction, int speed) {
        super(image, x, y);
        this.direction = direction;
        this.speed = speed;
    }

    public int getDirection(){
        return direction;
    }

    public int getSpeed(){
        return speed;
    }

    @Override
    public void move(String direction) {
        if (direction.equals("UP")) {
            setY(getY() - speed);  //monte
        } else {
            setY(getY() + speed);  //descend
        }
    }

    @Override
    public boolean isHit(){
        return false;
    }
}
