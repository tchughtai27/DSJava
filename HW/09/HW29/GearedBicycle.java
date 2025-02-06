public class GearedBicycle extends Bicycle {

    private final int MAX_GEARS = 6;
    private int gear = 1;
    private final int GEARED_MAX_SPEED = 50;
    private int speed;

    public int getGear() {
        return gear;
    }

    public void shiftUp() {
        gear++;
        if (gear > MAX_GEARS) {
            gear = MAX_GEARS;
        }
    }

    public void shiftDown() {
        gear--;
        if (gear == 1) {
            gear = 1;
        }
    }

    public void pedal() {
        int newSpeed = getSpeed() + getGear();
        if (newSpeed > GEARED_MAX_SPEED) {
            newSpeed = GEARED_MAX_SPEED;
        }
        setSpeed(newSpeed);
    }

    public void brake() {
        int newSpeed = getSpeed() + getGear();
        if (newSpeed > GEARED_MAX_SPEED) {
            newSpeed = GEARED_MAX_SPEED;
        }
        setSpeed(newSpeed);
    }

    public void display() {
        System.out.printf("Gear = %02d; ", getGear());
        super.display();
    }

    public GearedBicycle() {
        // first invoke the parent's constructor.
        super();

        // then initialize the child's member variables.
        gear = 1;
    }

    public static void main(String[] args) {
        GearedBicycle tracysBicycle = new GearedBicycle();
        System.out.println(tracysBicycle.getGear());
        System.out.println(tracysBicycle.getSpeed());
    }
}
