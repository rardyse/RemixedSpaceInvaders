package Project;

import java.awt.Image;

public class EnemyShot extends Shot {
    public EnemyShot(int x, int y, Image image, int speed) {
        super(x, y, image, 1, speed);  // direction 1 = vers le bas
    }
}