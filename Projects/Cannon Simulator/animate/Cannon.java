package animate;

import java.awt.Color;
import java.awt.Graphics;

public class Cannon {
    private int x, y, angle;

    public Cannon(int x, int y) {
        this.x = x;
        this.y = y;
        this.angle = 45;
    }

    public void rotateUp() {
        if (angle < 90)
            angle++;
    }

    public void rotateDown() {
        if (angle > 0)
            angle--;
    }

    public int getAngle() {
        return angle;
    }

    public int getMuzzleX() {
        return (int) (x + Math.cos(Math.toRadians(angle)) * 40);
    }

    public int getMuzzleY() {
        return (int) (y - Math.sin(Math.toRadians(angle)) * 40);
    }

    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        int endX = getMuzzleX();
        int endY = getMuzzleY();
        g.drawLine(x, y, endX, endY);
        g.fillOval(x - 10, y - 10, 20, 20);
    }
}
