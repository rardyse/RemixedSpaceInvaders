//4.1
package Project;

import java.awt.Image;
import oop.lib.Paintable;
import oop.lib.Painting;
import java.awt.*;
/*
    Class Sprite avec les objets :
        - x, y = position
        - width, height = taille pour image
        - image = répresentation
        - paint() = méthode pour que les objets soient dessinés

    Comportements dans un jeu :
        - bouger pour les joueurs, ennemies,
        - tirer pour les shots
        - savoir quand on est toucher ou quand on a touché quelque chose

    Donc :
        - on met d'abord les champs (x ,y et image)
        - ensuite les méthodes (paint, get)
        - Ensuite on s'occupe de la classe Player, Enemy, Shot

    Player :
        - bouger
        - tirer
        - se faire tirer dessus

    Ennemi :
        - bouger
        - tirer
        - se faire tirer dessus

    Shot :
        - bouger
 */
public abstract class Sprite implements Paintable {
    private int x; //x-coordinate of the whole sprite
    private int y; //y-coordinate of the whole sprite
    private Image image;  //Image representing the sprite

    //Constructor (on passe de private à protected)
    protected Sprite (Image image, int x, int y) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    // PUBLIC
    @Override
    public void paint(Painting painting) {
        painting.drawImage(image, x, y);
    }

    // GETTERS & SETTERS
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWidth() {
        return image.getWidth(null);
    }

    public int getHeight() {
        return image.getHeight(null);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void move(String direction);
    public abstract boolean isHit();
}
