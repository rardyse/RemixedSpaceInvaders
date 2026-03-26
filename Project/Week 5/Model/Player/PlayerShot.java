package serie5.Project.Model.Player;

import serie5.Project.Model.Shots.Shot;
import java.awt.Image;

public class PlayerShot extends Shot {
    public PlayerShot(int x, int y, Image image, int speedX, int speedY) {
        super(x, y, image, "UP", speedY);
    }
}