//4.3

package Project;

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

        SpriteList list = new SpriteList();

        list.add(Sprite.createImage1(20, 60)); //we write random values for x and y
        list.add(Sprite.createImage2(153, 75));
        list.add(Sprite.createImage3(258, 124));
        list.add(Sprite.createImage1(341, 212));
        list.add(Sprite.createImage2(458, 367));
        list.add(Sprite.createImage3(516, 473));

        for (int i = 0; i < list.getSize(); i++){
            add(list.get(i)); //we struggled here because we forgot that add(...) is used to activate animations, so here we have iteration + animation in Sprite

        }
    }
}