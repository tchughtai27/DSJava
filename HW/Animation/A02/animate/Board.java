package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int B_WIDTH = 720;
    private final int B_HEIGHT = 720;
    private BufferedImage img;

    /*
     * Constructor
     */
    public Board() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        try {
            File imageFile = new File("media/cakes.jpg");
            img = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (img != null) {
            // 1/4 of content area
            double targetWidth = B_WIDTH / 2.0;
            double targetHeight = B_HEIGHT / 2.0;

            // Calculate correct scaling factor 
            double scaleX = targetWidth / img.getWidth();
            double scaleY = targetHeight / img.getHeight();
            double scale = Math.min(scaleX, scaleY); // Keep proportions correct

            // Compute final scaled dimensions
            double scaledWidth = img.getWidth() * scale;
            double scaledHeight = img.getHeight() * scale;

            // Position in right corner
            double x = B_WIDTH - scaledWidth;
            double y = B_HEIGHT - scaledHeight;

            // AffineTransform
            AffineTransform at = new AffineTransform();
            at.translate(x, y);
            at.scale(scale, scale);

            g2d.drawImage(img, at, this);
        }
    }
}
