package project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class StartScreen extends JPanel {

    private int[] starX, starY, starSize;
    private float[] starSpeed;
    private Timer animTimer;
    private float titleGlow = 0;
    private boolean glowUp = true;

    public StartScreen(ActionListener onPlay) {
        setBackground(new Color(5, 0, 20));
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800, 600));

        // génère des étoiles aléatoires
        Random rand = new Random();
        int nbStars = 150;
        starX = new int[nbStars];
        starY = new int[nbStars];
        starSize = new int[nbStars];
        starSpeed = new float[nbStars];
        for (int i = 0; i < nbStars; i++) {
            starX[i] = rand.nextInt(800);
            starY[i] = rand.nextInt(600);
            starSize[i] = rand.nextInt(3) + 1;
            starSpeed[i] = rand.nextFloat() * 0.5f + 0.1f;
        }

        // animation des étoiles + glow du titre
        animTimer = new Timer(30, e -> {
            for (int i = 0; i < starX.length; i++) {
                starY[i] += starSpeed[i];
                if (starY[i] > 600) {
                    starY[i] = 0;
                    starX[i] = rand.nextInt(800);
                }
            }
            if (glowUp) {
                titleGlow += 0.05f;
                if (titleGlow >= 1) glowUp = false;
            } else {
                titleGlow -= 0.05f;
                if (titleGlow <= 0) glowUp = true;
            }
            repaint();
        });
        animTimer.start();

        GridBagConstraints gbc = new GridBagConstraints();

        // titre
        JLabel title = new JLabel("SPACE INVADERS", SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int alpha = (int) (100 + 155 * titleGlow);
                g2.setFont(getFont());
                FontMetrics fm = g2.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2; // ← centré
                g2.setColor(new Color(180, 0, 255, alpha));
                g2.drawString(getText(), x + 3, getHeight() - 5);
                g2.setColor(new Color(230, 150, 255));
                g2.drawString(getText(), x, getHeight() - 8);
            }
        };
        title.setFont(new Font("Courier New", Font.BOLD, 42));
        title.setForeground(new Color(230, 150, 255));
        title.setPreferredSize(new Dimension(600, 60));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(title, gbc);


        // bouton jouer stylé
        JButton playButton = new JButton("PLAY") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(30, 0, 60));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                g2.setColor(new Color(180, 0, 255));
                g2.setStroke(new BasicStroke(2));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 25, 25);
                g2.setFont(getFont());
                g2.setColor(new Color(230, 150, 255));
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(getText(), (getWidth() - fm.stringWidth(getText())) / 2, getHeight() / 2 + fm.getAscent() / 2 - 2);
            }
        };
        playButton.setFont(new Font("Courier New", Font.BOLD, 22));
        playButton.setPreferredSize(new Dimension(160, 50));
        playButton.setContentAreaFilled(false);
        playButton.setBorderPainted(false);
        playButton.setFocusPainted(false);
        playButton.addActionListener(e -> {
            animTimer.stop();
            onPlay.actionPerformed(e);
        });
        gbc.gridy = 2;
        gbc.insets = new Insets(40, 0, 0, 0);
        add(playButton, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // fond dégradé
        GradientPaint gradient = new GradientPaint(0, 0, new Color(5, 0, 20), 0, getHeight(), new Color(20, 0, 50));
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // étoiles
        for (int i = 0; i < starX.length; i++) {
            int alpha = Math.min(255, starSize[i] * 80);
            g2.setColor(new Color(200, 200, 255, alpha));
            g2.fillOval(starX[i], starY[i], starSize[i], starSize[i]);
        }
    }
}
