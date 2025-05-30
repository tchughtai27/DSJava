package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener {
    private final int B_WIDTH = 1440; // Panel width
    private final int B_HEIGHT = 720; // Panel height
    private final int FLOOR = B_HEIGHT - 50; // Position of the ground (50 pixels above the bottom)

    private Cannon cannon; // Add cannon to the board
    private CannonBall ball;

    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int TIMER_INTERVAL = 20; // msec

    private class ScheduledUpdate extends TimerTask {
        /*
         * Override the run() method.
         * Update the position of our ball here.
         */
        public void run() {
            // update the ball.
            ball.updateBall();

            // repaint board.
            repaint();
        }
    }

    public Board() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true); // Allows this panel to receive input
        addKeyListener(this); // Add the KeyListener to key events

        cannon = new Cannon(60, FLOOR - 60); // Cannon at the bottom-left corner

        // create a new ball.
        ball = new CannonBall(0, 1, FLOOR);

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(),
                INITIAL_DELAY, TIMER_INTERVAL);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Fill the sky
        g2d.setColor(new java.awt.Color(0, 255, 255));
        g2d.fillRect(0, 0, B_WIDTH, B_HEIGHT);

        // Fill the grass
        g2d.setColor(new java.awt.Color(0, 255, 0));
        g2d.fillRect(0, FLOOR, B_WIDTH, B_HEIGHT - FLOOR);

        // Draw the ground line
        g2d.setColor(java.awt.Color.BLACK);
        g2d.drawLine(0, FLOOR, B_WIDTH, FLOOR);

        // Draw the cannon
        cannon.draw(g2d); // Draw the cannon using its own method

        // draw cannonball;
        ball.draw(g2d);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                System.out.println("Left arrow was pressed.");
                cannon.rotateLeft(); // Rotate cannon left
                repaint();
            }
            case KeyEvent.VK_RIGHT -> {
                System.out.println("Right arrow was pressed.");
                cannon.rotateRight(); // Rotate cannon right
                repaint();
            }
            case KeyEvent.VK_SPACE -> {
                System.out.println("Spacebar was pressed.");
                cannon.fire(ball); // Fire the cannon
                repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}