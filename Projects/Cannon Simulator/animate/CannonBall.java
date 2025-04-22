package animate;

import java.awt.Color;
import java.awt.Graphics;

public class CannonBall {
    private int x, y;
    private double dx, dy;
    private int state;
    private long explosionStartTime;

    public static final int IDLE = 0;
    public static final int FLYING = 1;
    public static final int EXPLODING = 2;

    public CannonBall() {
        this.state = IDLE;
        this.x = 0;
        this.y = 0;
    }

    public void launch(int startX, int startY, int angle) {
        this.x = startX;
        this.y = startY;
        this.dx = Math.cos(Math.toRadians(angle)) * 10;
        this.dy = -Math.sin(Math.toRadians(angle)) * 10;
        this.state = FLYING;
    }

    public void update() {
        if (state == FLYING) {
            x += dx;
            dy += 0.5; // gravity
            y += dy;
            if (y > 450) { // ground level
                state = EXPLODING;
                explosionStartTime = System.currentTimeMillis();
            }
        } else if (state == EXPLODING) {
            if (System.currentTimeMillis() - explosionStartTime > 1000) {
                state = IDLE;
            }
        }
    }

    public void draw(Graphics g) {
        if (state == FLYING) {
            g.setColor(Color.BLACK);
            g.fillOval(x - 5, y - 5, 10, 10);
        } else if (state == EXPLODING) {
            g.setColor(Color.ORANGE);
            g.fillOval(x - 15, y - 15, 30, 30);
        }
    }

    public int getState() {
        return state;
    }
}
