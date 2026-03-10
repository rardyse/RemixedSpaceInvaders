//4.1
package Project;

import java.awt.Toolkit;
import java.awt.Image;
import oop.lib.Paintableimport oop.lib.Painting;

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
    //x-coordinate of the whole sprite
    private int x;
    //y-coordinate of the whole sprite
    private int y;
    //Image representing the sprite
    private Image image;

    //Constructor
    private Sprite(Image image, int x, int y) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    // PUBLIC
    @Override
    public <Painting> void paint(Painting painting) {
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

    public abstract void move();
    public abstract boolean isHit();
    public abstract void shoot();
}