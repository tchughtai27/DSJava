package animate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int SIDE_LEN = 150;

    /*
     * Constructor
     */
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        // call the parent class method.
        super.paintComponent(g);

        // cast our Graphics object to a Graphics2D object.
        Graphics2D g2d = (Graphics2D) g;

        // Calculate center of the content area
        int centerX = B_WIDTH / 2;
        int centerY = B_HEIGHT / 2;

        // Create an AffineTransform
        AffineTransform affineTransform = new AffineTransform();

        // Translate rectangle to center
        affineTransform.translate(centerX, centerY);

        // Rotate 22.5 degrees (Math.PI / 8 radians) about the center
        affineTransform.rotate(Math.PI / 8);

        // Move back so the rectangle is centered correctly
        affineTransform.translate(-SIDE_LEN / 2, -SIDE_LEN / 2);

        // Get transformed shape
        Rectangle rect = new Rectangle(0, 0, SIDE_LEN, SIDE_LEN);
        Shape transformedShape = affineTransform.createTransformedShape(rect);

        // Draw the transformed rectangle
        g2d.setColor(Color.MAGENTA);
        g2d.fill(transformedShape);

        // Draw text in blue
        g2d.setColor(Color.BLUE);
        g2d.drawString("Hello, world!", 20, 30);
    }
}
