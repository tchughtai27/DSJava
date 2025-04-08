package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener {
    private final int B_WIDTH = 1440;
    private final int B_HEIGHT = 720;
    private final int FLOOR = B_HEIGHT - 50;

    private Cannon cannon;

    public Board() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true);
        addKeyListener(this);

        // Initialize cannon 60px from left, 60px above floor
        cannon = new Cannon(60, FLOOR - 60);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Sky background
        g2d.setColor(new Color(0, 255, 255));
        g2d.fillRect(0, 0, B_WIDTH, B_HEIGHT);

        // Green ground
        g2d.setColor(new Color(0, 255, 0));
        g2d.fillRect(0, FLOOR, B_WIDTH, B_HEIGHT - FLOOR);

        // Ground line
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, FLOOR, B_WIDTH, FLOOR);

        // Draw cannon
        cannon.draw(g2d);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                cannon.rotateLeft();
                repaint();
            }
            case KeyEvent.VK_RIGHT -> {
                cannon.rotateRight();
                repaint();
            }
            case KeyEvent.VK_SPACE -> {
                cannon.fire();
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
