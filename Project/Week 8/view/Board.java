package Serie_8.project.view;

import Serie_8.project.model.enemy.Enemy;
import Serie_8.project.model.player.Player;
import Serie_8.project.model.shot.Shot;
import Serie_8.project.util.MyLinkedList;
import oop.lib.Display;

import java.awt.*;

public class Board extends Display {

    private final int height;
    private final int width;
    private MyLinkedList<Enemy> enemies;
    private MyLinkedList<Shot> shots;
    private Player player;
    private boolean gameOver = false;
    private boolean victory = false;

    // constructor
    public Board(int width, int height, Player player, MyLinkedList<Enemy> enemies, MyLinkedList<Shot> shots) {
        super(width, height);
        this.width = width;
        this.height = height;
        this.player = player;
        this.enemies = enemies;
        this.shots = shots;
    }

    @Override
    public void paint(Display display) {
        setColor(new Color(15, 0, 30));
        display.fillPolygon(new double[][]{
                {0, 0}, {width, 0}, {width, height}, {0, height}
        });

        if (player != null) {
            player.paint(display);
        }

        for (Enemy enemy : enemies) {
            enemy.paint(display);
        }

        // applicable pour BULLET (shot du joueur) et BOMB (shot de l'ennemi)
        for (Shot shot : shots) {
            shot.paint(display);
        }

        if (gameOver) {
            displayDefeat(display);
        } else if (victory) {
            displayVictory(display);
        }
    }


    private void displayVictory(Display display) {
        setColor(new Color(0, 255, 100));
        display.fillPolygon(new double[][]{
                {width / 2.0 - 150, height / 2.0 - 40},
                {width / 2.0 + 150, height / 2.0 - 40},
                {width / 2.0 + 150, height / 2.0 + 40},
                {width / 2.0 - 150, height / 2.0 + 40}
        });
    }

    private void displayDefeat(Display display) {
        setColor(new Color(255, 50, 50));
        display.fillPolygon(new double[][]{
                {width / 2.0 - 150, height / 2.0 - 40},
                {width / 2.0 + 150, height / 2.0 - 40},
                {width / 2.0 + 150, height / 2.0 + 40},
                {width / 2.0 - 150, height / 2.0 + 40}
        });
    }

    // setters and guetters
    public int getBoardHeight() {
        return height; }
    public int getBoardWidth() {
        return width; }
    public Player getPlayer() {
        return player; }
    public void setPlayer(Player player) {
        this.player = player; }
    public MyLinkedList<Enemy> getEnemies() {
        return enemies; }
    public void setEnemies(MyLinkedList<Enemy> enemies) {
        this.enemies = enemies; }
    public MyLinkedList<Shot> getShots() {
        return shots; }
    public void setShots(MyLinkedList<Shot> shots) {
        this.shots = shots; }
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver; }
    public void setVictory(boolean victory) {
        this.victory = victory; }

}