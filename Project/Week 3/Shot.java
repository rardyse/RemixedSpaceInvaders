package Project;

import java.awt.*;

public class Shot extends Sprite {
    private int direction;
    private int speed;

    public Shot(int x, int y, Image image, int direction, int speed) {
        super(image, x, y);
        this.direction = direction;
        this.speed = speed;
    }

    @Override
    public void move(){
    }

    @Override
    public boolean isHit(){
        return false;
    }

    @Override
    public void shoot() {
    }
}
