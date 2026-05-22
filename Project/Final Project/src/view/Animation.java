package project.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;

public class Animation implements Runnable, ActionListener {
    private static final int DELAY_MS = 16;
    private JFrame frame;
    private Timer timer;
    private Board display;

    public void launch(boolean start) {
        frame = new JFrame("Spaceinvaders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800, 600);

        // affiche le start screen
        StartScreen startScreen = new StartScreen(e -> {
            frame.getContentPane().removeAll();
            init();
            if (display != null) {
                frame.add(display);
                frame.pack();
            }
            frame.revalidate();
            frame.repaint();
            timer = new Timer(DELAY_MS, this);
            if (start) {
                timer.start();
            }
            display.requestFocusInWindow();
        });

        frame.add(startScreen);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void init() {}

    protected void step() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        step();
        if (display != null) {
            display.repaint();
        }
    }

    @Override
    public void run() {
        launch(true);
    }

    protected void setDisplay(Board display) {
        this.display = display;
    }

    protected Board getDisplay() {
        return display;
    }

    protected void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    protected JFrame getFrame() {
        return frame;
    }
}