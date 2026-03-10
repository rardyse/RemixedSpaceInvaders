package Project;

import java.awt.Image;

public class Player extends Sprite {
    private int lives;
    private int speed;

    public Player(int x, int y, Image image, int lives, int speed) {
        super(image, x, y);
        this.lives = lives;
        this.speed = speed;
    }
    @Override
    public void move(){         //Il se déplace
    }

    @Override
    public void shoot(){        //Il tire sur les ennemies
    }

    @Override
    public boolean isHit(){     //Il est touché par le tir
        return false;
    }
}


