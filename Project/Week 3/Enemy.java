package Project;

import java.awt.*;

public class Enemy extends Sprite{
    private int points;
    private int speed;

    public Enemy(int x, int y, Image image, int points, int speed){
        super(image, x, y);
        this.points = points;
        this.speed = speed;
    }

    @Override
    public void move(){
    }

    @Override
    public void shoot(){
    }

    @Override
    public boolean isHit(){
        return false;
    }
}