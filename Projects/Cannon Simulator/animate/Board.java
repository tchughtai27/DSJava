import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener, KeyListener {
    private Cannon cannon;
    private CannonBall cannonball;
    private Timer timer;

    public Board() {
        setPreferredSize(new Dimension(800, 500));
        setBackground(Color.CYAN); // Sky color
        setFocusable(true);
        addKeyListener(this);

        cannon = new Cannon(100, 450); // Cannon at bottom left
        cannonball = new CannonBall();

        timer = new Timer(16, this); // ~60 FPS
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw background
        g.setColor(Color.CYAN); // Sky
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.GREEN); // Ground
        g.fillRect(0, 450, getWidth(), 50); // ground at bottom

        // Draw objects
        cannon.draw(g);
        cannonball.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cannonball.update();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            cannon.rotateUp();
        } else if (key == KeyEvent.VK_DOWN) {
            cannon.rotateDown();
        } else if (key == KeyEvent.VK_SPACE) {
            if (cannonball.getState() == CannonBall.IDLE) {
                cannonball.launch(cannon.getMuzzleX(), cannon.getMuzzleY(), cannon.getAngle());
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
