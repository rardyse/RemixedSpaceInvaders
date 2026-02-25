import oop.lib.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tester extends Animation {

    public static void main(String[] args) {
        new Tester().launch(true);
    }

    @Override
    public void init() {
        super.init();

        try {
            Image img = ImageIO.read(Tester.class.getResource("/Images/landscape.jpg"));
            Sprite sprite = new Sprite(img, 30, 50);
            add(sprite);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}