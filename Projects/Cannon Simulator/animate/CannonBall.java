package animate;

import java.awt.*;

public class CannonBall {
    // Constants
    private static final double GRAVITY = 9.8; // m/s^2 (can be scaled for visual effect)
    private static final double SCALE = 30.0; // pixels per meter

    // State tracking
    public static final int IDLE = 0;
    public static final int FLYING = 1;
    public static final int EXPLODING = 2;

    private int state;

    // Position and velocity (in meters)
    private double x, y;
    private double startX, startY;
    private double vx, vy;
    private double time;

    public CannonBall() {
        state = IDLE;
    }

    // Launch method
    public void launch(double angleDegrees, double power, double startX, double startY) {
        this.startX = startX;
        this.startY = startY;

        this.x = startX;
        this.y = startY;

        double angleRadians = Math.toRadians(angleDegrees);
        vx = power * Math.cos(angleRadians);
        vy = power * Math.sin(angleRadians);

        time = 0;
        state = FLYING;
    }

    // Update position using physics
    public void updatePosition(double dt) {
        if (state == FLYING) {
            time += dt;
            x = startX + vx * time;
            y = startY - (vy * time - 0.5 * GRAVITY * time * time);
        }
    }

    public void draw(Graphics g) {
        if (state == FLYING) {
            int drawX = (int)(x * SCALE);
            int drawY = (int)(y * SCALE);
            g.setColor(Color.BLACK);
            g.fillOval(drawX - 5, drawY - 5, 10, 10);
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int newState) {
        state = newState;
    }
}
