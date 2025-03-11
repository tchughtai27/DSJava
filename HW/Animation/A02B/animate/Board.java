package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int B_WIDTH = 720;
    private final int B_HEIGHT = 720;

    private int x = 0; // Starts at upper-left corner
    private int y = 0;
    private double angle = 0; // Rotation angle in degrees

    private BufferedImage img;

    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;
    private final int xSpeed = 1;
    private final int ySpeed = 1;

    /*
     * Constructor
     */
    public Board() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(), INITIAL_DELAY, PERIOD_INTERVAL);

        try {
            File imageFile = new File("media/Andy.png");
            img = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (img != null) {
            int imgWidth = img.getWidth();
            int imgHeight = img.getHeight();

            // Apply AffineTransform for position and rotation
            AffineTransform at = new AffineTransform();
            at.translate(x, y);
            at.rotate(Math.toRadians(angle), imgWidth / 2.0, imgHeight / 2.0);

            g2d.drawImage(img, at, this);
        }
    }

    private class ScheduledUpdate extends TimerTask {
        public void run() {
            // Move diagonally
            x += xSpeed;
            y += ySpeed;

            // Wrap around in x-direction
            if (x > B_WIDTH)
                x = -img.getWidth();
            if (x < -img.getWidth())
                x = B_WIDTH;

            // Wrap around in y-direction
            if (y > B_HEIGHT)
                y = -img.getHeight();
            if (y < -img.getHeight())
                y = B_HEIGHT;

            // Rotate by 5° per update
            angle += 5;
            if (angle >= 360)
                angle = 0;

            repaint();
        }
    }
}
