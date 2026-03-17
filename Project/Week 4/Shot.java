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
    public void move(String direction){
        setY(getY() + speed);               //Le shot peut aller qu'en bas sur le joueur
    }

    @Override
    public boolean isHit(){
        return false;
    }

    /*@Override
    public void shoot() {
    }*/
}
