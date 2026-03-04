//4.1

package Project;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import oop.lib.Paintable;
import oop.lib.Painting;
import java.awt.Toolkit;

public class Sprite implements Paintable {

    //encapsulation
    private Image image;
    private int x;
    private int y;

    //constructor
    private Sprite(Image image, int x, int y){
        this.image = image;
        this.x = x;
        this.y = y;
    }

    //three factory methods
    public static Sprite createImage1(int x, int y) {
        Image img = Toolkit.getDefaultToolkit().getImage(Sprite.class.getResource("/Images/rain.jpg")); //we made some researches on Google because the images didn't want to download themselves so we found the library Toolkit on a forum
        return new Sprite(img, x, y);
    }

    public static Sprite createImage2(int x, int y) {
        Image img = Toolkit.getDefaultToolkit().getImage(Sprite.class.getResource("/Images/sky.jpg"));
        return new Sprite(img, x, y);
    }

    public static Sprite createImage3(int x, int y) {
        Image img = Toolkit.getDefaultToolkit().getImage(Sprite.class.getResource("/Images/sunset.jpg"));
        return new Sprite(img, x, y);
    }

    @Override
    public void paint(Painting painting) {
        painting.drawImage(image, x, y);
    }

    public int getX(){ return x; }
    public int getY(){ return y; }

    public int getWidth(){
        return image.getWidth(null);
    }

    public int getHeight(){
        return image.getHeight(null);
    }

    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }
}