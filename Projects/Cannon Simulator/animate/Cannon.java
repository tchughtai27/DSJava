package animate;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.net.URL;
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
        this.angle = 45;
        this.muzzleVelocity = 50;

        loadImage();
        loadSounds();
    }

    public void fire(CannonBall ball, double power) {
        ball.launch(angle, power, x + 15, y); // x + 15 is near the barrel tip
    }

    private void loadImage() {
        try {
            // Relative path to the image
            URL imageURL = getClass().getResource("../media/sm_cannon.png");
            if (imageURL != null) {
                image = new ImageIcon(imageURL).getImage();
            } else {
                System.out.println("Cannon image not found.");
            }
        } catch (Exception e) {
            System.out.println("Failed to load cannon image.");
        }
    }

    public void setAngle(double angle) {
        this.angle = Math.max(0, Math.min(90, angle));
    }

    private void loadSounds() {
        wheelSound = loadSound("../media/wheel.wav");
        fireSound = loadSound("../media/cannon.wav");
    }

    private Clip loadSound(String path) {
        try {
            URL soundURL = getClass().getResource(path);
            if (soundURL == null) {
                System.out.println("Sound file not found: " + path);
                return null;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
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

            int imgHeight = image.getHeight(null);
            double pivotX = 15;
            double pivotY = imgHeight / 2.0;

            at.translate(x, y);
            at.rotate(Math.toRadians(-angle), pivotX, pivotY);
            g2d.drawImage(image, at, null);

            g2d.setColor(Color.BLUE);
            g2d.fillOval((int) (x + pivotX - 5), (int) (y + pivotY - 5), 10, 10);

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
