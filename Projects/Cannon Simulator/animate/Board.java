package animate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Cannon cannon;
    private CannonBall cannonBall;
    private double power = 20; // initial launch speed

    public Board() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);

        cannon = new Cannon(100, 500); // x and y position in pixels
        cannonBall = new CannonBall();

        timer = new Timer(16, this); // ~60 FPS
        timer.start();

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        cannon.draw(g2d);
        cannonBall.draw(g2d); // Still works since draw() in CannonBall takes Graphics
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cannonBall.updatePosition(0.016); // 16 ms per frame
        repaint();
    }

    // Optional: Arrow key controls to change cannon angle
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            cannon.setAngle(cannon.getAngle() - 2);
        } else if (code == KeyEvent.VK_DOWN) {
            cannon.setAngle(cannon.getAngle() + 2);
        } else if (code == KeyEvent.VK_SPACE) {
            if (cannonBall.getState() == CannonBall.IDLE) {
                cannon.fire(); // plays sound
                cannon.fire(cannonBall, power); // this method doesn't exist yet – read below!
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
