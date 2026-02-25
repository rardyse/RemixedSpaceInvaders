import java.awt.Image;
import oop.lib.Paintable;
import oop.lib.Painting;

public class Sprite implements Paintable {

    private Image image;
    private int x;
    private int y;

    //////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    public Sprite(Image image, int x, int y){
        this.image = image;
        this.x = x;
        this.y = y;
    }
    //////////////////////////////////////////////////////////////////////


    //////////////////////////////////////////////////////////////////////
    // PUBLIC
    //////////////////////////////////////////////////////////////////////
    @Override
    public void paint(Painting painting) {
        painting.drawImage(image, x, y);
    }

    //////////////////////////////////////////////////////////////////////
    // GETTERS
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return image.getWidth(null);
    }

    public int getHeight(){
        return image.getHeight(null);
    }

    //SETTERS
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
    //////////////////////////////////////////////////////////////////////

}