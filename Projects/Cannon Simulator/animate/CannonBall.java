package animate;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class CannonBall {
    public double ax;
    public double ay;
    public double vx;
    public double vy;
    public double x;
    public double y;
    public static final int DIAMETER = 20;
    public double ground;
    BufferedImage imgFlame;

    public enum STATE {
        IDLE,
        FLYING,
        EXPLODING
    }

    public STATE state = STATE.IDLE;

    public CannonBall(double ax, double ay, double ground) {
        // public constructor for CannonBall class.
        // takes the acceleration rates (x and y) and the location of the ground (as a
        // double)
        // as arguments
        this.ax = ax;
        this.ay = ay;
        this.ground = ground;

        // get flame
        try {
            File file = new File("media/flame.png");
            imgFlame = ImageIO.read(file);

        } catch (Exception e) {
            System.err.println("Couldn't load flame image.");
        }

    }

    /*
     * The draw method is called by the Board object
     * and is used to paint the current location and state of the ball.
     * If the ball is flying through the air, the ball is drawn as a red
     * filled in circle. If the ball is in the exploded state, a flame image is
     * drawn. If the ball is idle, then the ball is not drawn at all
     * (since we assume the ball is hidden inside the cannon).
     */
    public void draw(Graphics2D g2d) {
        if (state == STATE.FLYING) {
            // draw cannonball in air
            int xpos = (int) x - DIAMETER / 2;
            int ypos = (int) y - DIAMETER / 2;
            g2d.fillOval(xpos, ypos, DIAMETER, DIAMETER);
        } else if (state == STATE.EXPLODING) {
            // draw image of flame
            AffineTransform af = new AffineTransform();
            af.translate(x - 27, y - 17);
        }
    }

    /*
     * The updateBall() method uses the constant acceleration equations
     * to update the velocity and position of the ball each timer interval.
     * note that when calculating the new velocity, the acceleration term is divided
     * by the
     * time scale in case the user wants to slow down the animation.
     * Similarly, when calculating the new position, the velocity term is divided by
     * the time scale
     * in case the user wants to slow down the animation.
     */
    public void updateBall() {
        if (state == STATE.FLYING) {
            // laws of physics to update position
            vx = vx + ax;
            x = x + vx;
            vy = vy + ay;
            y = y + vy;

            // did it hit the ground
            if (y > ground) {
                // exploding state
                state = STATE.EXPLODING;
            }
        }
    }

    /*
     * If the ball is not flying through the air, the launch() method
     * will change the state to FLYING and start the ball moving from position (x,y)
     * with the inital velocity of (vx, vy).
     */
    public void launch(double x, double y, double vx, double vy) {
        if (state == STATE.FLYING) {
            return;
        }
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;

        this.state = STATE.FLYING;
    }
}
