package animate;

public class CannonBall {
    public enum STATE {
        IDLE,
        FLYING,
        EXPLODING
    }

    public CannonBall(double ax, double ay, double ground) {
        // public constructor for CannonBall class.
        // takes the acceleration rates (x and y) and the location of the ground (as a
        // double)
        // as arguments
    }

    private BufferedImage loadImage(String path) {
        // loads a buffered image (for the flame animation).
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
    }

    /*
     * If the ball is not flying through the air, the launch() method
     * will change the state to FLYING and start the ball moving from position (x,y)
     * with the inital velocity of (vx, vy).
     */
    public void launch(double x, double y, double vx, double vy) {
    }

    /*
     * Get/set methods for the private member variables.
     */
    public STATE getState() {
    }

    public double getX() {
    }

    public double getY() {
    }

    public double getVX() {
    }

    public double getVY() {
    }

    public double getAX() {
    }

    public double getAY() {
    }

    public double getTimeScale() {
    }

    public double getGround() {
    }

    public void setState(STATE newState) {
    }

    public void setX(double x) {
    }

    public void setY(double y) {
    }

    public void setVX(double vx) {
    }

    public void setVY(double vy) {
    }

    public void setAX(double ax) {
    }

    public void setAY(double ay) {
    }

    public void setTimeScale(double timeScale) {
    }

    public void changeTimeScale(double delta) {
    }

    public void setGround(double ground) {
    }

}