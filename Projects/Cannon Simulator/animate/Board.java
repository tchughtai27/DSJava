package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener {
    private final int B_WIDTH = 1440; // Panel width
    private final int B_HEIGHT = 720; // Panel height
    private final int FLOOR = B_HEIGHT - 50; // Position of the ground (50 pixels above the bottom)

    private Cannon cannon; // Add cannon to the board

    public Board() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true); // Allow this panel to receive keyboard input
        addKeyListener(this); // Add the KeyListener to handle key events

        cannon = new Cannon(60, FLOOR - 60); // Instantiate the cannon at the bottom-left corner
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
        repaint();
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
                cannon.fire(); // Fire the cannon
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
