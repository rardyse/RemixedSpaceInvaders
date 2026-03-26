package serie5.Project.Model.Enemy;

import serie5.Project.Model.Shots.Shot;
import java.awt.Image;

public class EnemyShot extends Shot {
    public EnemyShot(int x, int y, Image image, int speed) {
        super(x, y, image, "DOWN", speed);
    }
}