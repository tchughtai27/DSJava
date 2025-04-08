package animate;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;

public class Cannon {
    private double x, y;
    private double angle; // in degrees
    private double muzzleVelocity;
    private Image image;

    private Clip wheelSound;
    private Clip fireSound;

    public Cannon(double x, double y) {
        this.x = x;
        this.y = y;
        this.angle = 45; // default angle
        this.muzzleVelocity = 50; // default velocity

        loadImage();
        loadSounds();
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("media/sm_cannon.png");
        image = ii.getImage();
    }

    private void loadSounds() {
        wheelSound = loadSound("media/wheel.wav");
        fireSound = loadSound("media/cannon.wav");
    }

    private Clip loadSound(String path) {
        try {
            File soundFile = new File(path);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error loading sound: " + path);
            return null;
        }
    }

    public void rotateLeft() {
        if (angle < 90) {
            angle += 5;
            playSound(wheelSound);
        }
    }

    public void rotateRight() {
        if (angle > 0) {
            angle -= 5;
            playSound(wheelSound);
        }
    }

    public void fire() {
        playSound(fireSound);
    }

    private void playSound(Clip sound) {
        if (sound != null) {
            sound.stop();
            sound.setFramePosition(0);
            sound.start();
        }
    }

    public void draw(Graphics2D g2d) {
        if (image != null) {
            AffineTransform at = new AffineTransform();

            // pivot point of image is at (15, 25.5) in image coordinates
            int imgWidth = image.getWidth(null);
            int imgHeight = image.getHeight(null);
            double pivotX = 15;
            double pivotY = imgHeight / 2.0;

            at.translate(x, y);
            at.rotate(Math.toRadians(-angle), pivotX, pivotY);
            g2d.drawImage(image, at, null);

            // Draw the pivot circle (blue)
            g2d.setColor(Color.BLUE);
            g2d.fillOval((int) (x + pivotX - 5), (int) (y + pivotY - 5), 10, 10);

            // Draw the base (pink triangle with black outline)
            int baseX = (int) (x + pivotX);
            int baseY = (int) (y + pivotY);
            Polygon triangle = new Polygon();
            triangle.addPoint(baseX, baseY);
            triangle.addPoint(baseX - 20, baseY + 30);
            triangle.addPoint(baseX + 20, baseY + 30);

            g2d.setColor(Color.PINK);
            g2d.fillPolygon(triangle);
            g2d.setColor(Color.BLACK);
            g2d.drawPolygon(triangle);
        }
    }

    public double getAngle() {
        return angle;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getMuzzleVelocity() {
        return muzzleVelocity;
    }

    public void setMuzzleVelocity(double velocity) {
        this.muzzleVelocity = velocity;
    }
}
