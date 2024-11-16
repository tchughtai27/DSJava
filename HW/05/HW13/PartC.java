import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class PartC {
    /*
     * Draws the rose
     */
    public static void draw(Graphics g) {
        final int WIDTH = 400;   // Area width
        final int HEIGHT = 400;  // Area height
        final double SCALE = 150.0; // Scale factor that should make the rose visible/bigger/smaller
        final int STEPS = 1000;  // Amount of steps from 0 to 2π
        
        g.setColor(Color.RED);  // Set the color for the rose, red is the best color
        
        // Translate origin to the center of the content area so that I can use polar coordinates (thats how they work)
        int centerX = WIDTH / 2;
        int centerY = HEIGHT / 2;

        // Loop through θ from 0 to 2π in the amount of STEPS increments
        for (int i = 0; i < STEPS; i++) {
            double theta1 = (2 * Math.PI / STEPS) * i;        // Current θ
            double theta2 = (2 * Math.PI / STEPS) * (i + 1);  // Next θ after

            // Find r for the current and next θ
            double r1 = Math.cos(2 * theta1); // First r
            double r2 = Math.cos(2 * theta2); // Second r

            // Convert polar coordinates to Cartesian for current and next points
            // Will make it so that we can graph it
            int x1 = (int) (SCALE * r1 * Math.cos(theta1)) + centerX;
            int y1 = (int) (SCALE * r1 * Math.sin(theta1)) + centerY;
            int x2 = (int) (SCALE * r2 * Math.cos(theta2)) + centerX;
            int y2 = (int) (SCALE * r2 * Math.sin(theta2)) + centerY;

            // Draw a line between the current and next points
            g.drawLine(x1, y1, x2, y2);

            
        }
    }

    public static enum OS {
        WIN, MAC, LINUX, OTHER
    }

    public static OS checkOS() {
        OS val;
        String name = System.getProperty("os.name").toLowerCase();
        if (name.indexOf("win") >= 0) {
            val = OS.WIN;
        } else if (name.indexOf("mac") >= 0) {
            val = OS.MAC;
        } else if (name.indexOf("nux") >= 0) {
            val = OS.LINUX;
        } else {
            val = OS.OTHER;
        }

        return val;
    }

    // Do not modify the code in the main method.
    // Your code will go into the draw method above.
    public static void main(String[] args) {
        // this is the desired dimensions of the content area
        // of our JFrame window.
        final int CONTENT_WIDTH = 400;
        final int CONTENT_HEIGHT = 400;

        // the values for border width and title bar height
        // depend on the operating system.
        int border_width = 0;
        int bar_height = 0;
        OS os = checkOS();
        switch (os) {
            case WIN:
                border_width = 7;
                bar_height = 30;
                break;
            case MAC:
                border_width = 0;
                bar_height = 28;
                break;
            case LINUX:
                // I don't know what the values are for Linux.
                break;
            case OTHER:
                break;
        }

        int frame_width = CONTENT_WIDTH + 2 * border_width;
        int frame_height = CONTENT_HEIGHT + bar_height + border_width;
        JFrame frame = new JFrame();
        frame.setSize(frame_width, frame_height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent component = new JComponent() {
            public void paintComponent(Graphics graph) {
                draw(graph);
            }
        };

        frame.add(component);
        frame.setVisible(true);

        System.out.println("Frame Size   : " + frame.getSize());
        System.out.println("Frame Insets : " + frame.getInsets());
        System.out.println("Content Size : " + frame.getContentPane().getSize());
    }
}
