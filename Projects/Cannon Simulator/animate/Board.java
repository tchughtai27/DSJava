package animate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Board extends JPanel implements KeyListener {
    private final int B_WIDTH = 1440; // Panel width
    private final int B_HEIGHT = 720; // Panel height
    private final int FLOOR = B_HEIGHT - 50; // Position of the ground (50 pixels above the bottom)

    private int x = 100; // Starting x position of the cannonball
    private int y = FLOOR - 50; // Starting y position of the cannonball (above the ground)
    private int xSpeed = 5; // Speed in the x direction
    private int ySpeed = -10; // Speed in the y direction (negative to simulate upward movement)

    public Board() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true); // Allow this panel to receive keyboard input
        addKeyListener(this); // Add the KeyListener to handle key events
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

        // Draw the cannonball
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x, y, 20, 20);

        // Update the cannonball's position
        x += xSpeed;
        y += ySpeed;

        ySpeed += 1; // Gravity is pulling the cannonball down

        // Ensure cannonball does not go below the ground
        if (y >= FLOOR - 20) { // If the cannonball hits the ground
            y = FLOOR - 20;
            ySpeed = 0; // Stop motion after hitting the ground
        }

        // Check if the cannonball goes out of bounds
        if (x < 0 || x > B_WIDTH - 20) {
            xSpeed = -xSpeed; // Reverse direction if hitting the sides?
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE -> System.out.println("Spacebar was pressed.");
            case KeyEvent.VK_LEFT -> {
                System.out.println("Left arrow was pressed.");
                xSpeed -= 1;
            }
            case KeyEvent.VK_RIGHT -> {
                System.out.println("Right arrow was pressed.");
                xSpeed += 1;
            }
            case KeyEvent.VK_UP -> {
                System.out.println("Up arrow was pressed.");
                ySpeed -= 1;
            }
            case KeyEvent.VK_DOWN -> {
                System.out.println("Down arrow was pressed.");
                ySpeed += 1;
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
