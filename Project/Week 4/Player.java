//4.1
package Project;

import java.awt.Image;

public class Player extends Sprite implements Shootable{
    private int lives;
    private int speed;

    public Player(int x, int y, Image image, int lives, int speed) {
        super(image, x, y);
        this.lives = lives;
        this.speed = speed;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
    public void shoot(){        //Il tire sur les ennemies
    }

    @Override
    public boolean isHit(){     //Il est touché par le tir
        return false;
    }
}

