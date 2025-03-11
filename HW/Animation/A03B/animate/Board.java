package animate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import sound.SoundClip;

public class Board extends JPanel {
    private final int B_WIDTH = 720;
    private final int B_HEIGHT = 720;

    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    private double angle = 0;

    private BufferedImage img;
    private Timer timer;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    private SoundClip sitar;
    private SoundClip ow;
    private Random rand = new Random();

    /*
     * Constructor
     */
    public Board() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        // Start Mr. Chappell in the middle
        x = B_WIDTH / 2;
        y = B_HEIGHT / 2;

        // Random speed between 1 and 5
        xSpeed = rand.nextInt(5) + 1;
        ySpeed = rand.nextInt(5) + 1;

        // Load sounds
        sitar = new SoundClip("media/sitar.wav");
        sitar.setLoop(true);
        sitar.play();

        ow = new SoundClip("media/ow.wav");

        // Load image
        try {
            File imageFile = new File("media/Andy.png");
            img = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(), INITIAL_DELAY, PERIOD_INTERVAL);
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
            x += xSpeed;
            y += ySpeed;

            boolean bounced = false;

            // Bounce off walls
            if (x <= 0 || x + img.getWidth() >= B_WIDTH) {
                xSpeed = -xSpeed;
                bounced = true;
            }
            if (y <= 0 || y + img.getHeight() >= B_HEIGHT) {
                ySpeed = -ySpeed;
                bounced = true;
            }

            // Play "ow" sound on bounce
            if (bounced) {
                ow.play();
            }

            // Rotate by 5° per update
            angle += 5;
            if (angle >= 360) {
                angle = 0;
            }

            repaint();
        }
    }
}
