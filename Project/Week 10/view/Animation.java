package view;

import view.Board;
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

        init();

        if (display != null) {
            frame.add(display);
            frame.pack();
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        // transfère les KeyListeners du board au frame
        if (display != null) {
            for (KeyListener kl : display.getKeyListeners()) {
                frame.addKeyListener(kl);
            }
        }

        timer = new Timer(DELAY_MS, this);
        if (start) {
            timer.start();
        }
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