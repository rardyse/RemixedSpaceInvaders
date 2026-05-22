package project.view;

import project.model.enemy.Enemy;
import project.model.player.Player;
import project.model.shot.Shot;
import project.util.MyLinkedList;
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
    private int score = 0;
    private int lives = 3;
    private Image lifeImage;
    private Image victoryImage;
    private Image gameOverImage;

    // constructor
    public Board(int width, int height, Player player, MyLinkedList<Enemy> enemies, MyLinkedList<Shot> shots) {
        super(width, height);
        this.width = width;
        this.height = height;
        this.player = player;
        this.enemies = enemies;
        this.shots = shots;
        try {
            lifeImage = javax.imageio.ImageIO.read(Board.class.getResource("/resources/vie.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Image rawVictory = javax.imageio.ImageIO.read(Board.class.getResource("/resources/victory.png"));
            victoryImage = rawVictory.getScaledInstance(650, 400, Image.SCALE_SMOOTH);

            Image rawGameOver = javax.imageio.ImageIO.read(Board.class.getResource("/resources/gameover.jpg"));
            gameOverImage = rawGameOver.getScaledInstance(650, 400, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // police pixel/arcade
        Font arcadeFont = new Font("Courier New", Font.BOLD, 20);
        Font titleFont = new Font("Courier New", Font.BOLD, 26);

        // score en haut à gauche
        g2.setFont(arcadeFont);
        g2.setColor(new Color(100, 200, 255));
        String scoreStr = String.format("SCORE: %06d", score);
        g2.drawString(scoreStr, 20, 35);

        // titre au centre
        g2.setFont(titleFont);
        g2.setColor(new Color(220, 100, 255));
        String title = "SPACE INVADERS";
        FontMetrics fm = g2.getFontMetrics();
        int titleX = (width - fm.stringWidth(title)) / 2;
        g2.drawString(title, titleX, 35);

        // message rejouer/exit quand game over ou victory
        if (gameOver || victory) {
            g2.setFont(new Font("Courier New", Font.BOLD, 18));
            g2.setColor(new Color(200, 200, 255));
            String replayMsg = "Press R to replay";
            FontMetrics fm2 = g2.getFontMetrics();
            g2.drawString(replayMsg, (width - fm2.stringWidth(replayMsg)) / 2, height - 60);

            g2.setColor(new Color(255, 200, 10));
            String exitMsg = "Press E to exit";
            g2.drawString(exitMsg, (width - fm2.stringWidth(exitMsg)) / 2, height - 35);
        }

        // bordure autour du jeu
        g2.setColor(new Color(150, 0, 200));
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(5, 45, width - 10, height - 50);

        // lives avec image en haut à droite
        g2.setFont(arcadeFont);
        g2.setColor(new Color(100, 200, 255));
        g2.drawString("LIVES: ", width - 200, 35);
        if (lifeImage != null) {
            for (int i = 0; i < lives; i++) {
                g2.drawImage(lifeImage, width - 115 + i * 35, 12, 25, 25, null);
            }
        }
    }

    private void displayVictory(Display display) {
        if (victoryImage != null) {
            display.drawImage(victoryImage, new double[]{
                    width / 2.0 - victoryImage.getWidth(null) / 2.0,
                    height / 2.0 - victoryImage.getHeight(null) / 2.0
            });
        }
    }

    private void displayDefeat(Display display) {
        if (gameOverImage != null) {
            display.drawImage(gameOverImage, new double[]{
                    width / 2.0 - gameOverImage.getWidth(null) / 2.0,
                    height / 2.0 - gameOverImage.getHeight(null) / 2.0
            });
        }
    }

    // setters and getters
    public int getBoardHeight() { return height; }
    public int getBoardWidth() { return width; }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public MyLinkedList<Enemy> getEnemies() { return enemies; }
    public void setEnemies(MyLinkedList<Enemy> enemies) { this.enemies = enemies; }
    public MyLinkedList<Shot> getShots() { return shots; }
    public void setShots(MyLinkedList<Shot> shots) { this.shots = shots; }
    public void setGameOver(boolean gameOver) { this.gameOver = gameOver; }
    public boolean isGameOver() { return gameOver; }
    public void setVictory(boolean victory) { this.victory = victory; }
    public boolean isVictory() { return victory; }
    public void setScore(int score) { this.score = score; }
    public int getScore() { return score; }
    public void setLives(int lives) { this.lives = lives; }
    public int getLives() { return lives; }
}