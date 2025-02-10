public class GearedBicycle extends Bicycle {
    private final int MAX_GEARS = 6;
    private int gear = 1;
    private final int GEARED_MAX_SPEED = 50;

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
        if (gear < 1) {
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
        int newSpeed = getSpeed() - 4;
        setSpeed(newSpeed);
    }

    public void display() {
        System.out.printf("Gear = %02d; ", getGear());
        super.display();
    }

    public GearedBicycle() {
        super();
        gear = 1;
    }

    public static void main(String[] args) {
        Bicycle normalBike = new Bicycle();
        GearedBicycle gearedBike = new GearedBicycle();

        normalBike.pedal();
        normalBike.pedal();
        gearedBike.pedal();
        gearedBike.pedal();

        System.out.println("Before braking:");
        System.out.print("Normal Bike: ");
        normalBike.display();
        System.out.print("Geared Bike: ");
        gearedBike.display();

        normalBike.brake();
        gearedBike.brake();

        System.out.println("\nAfter braking:");
        System.out.print("Normal Bike: ");
        normalBike.display();
        System.out.print("Geared Bike: ");
        gearedBike.display();
    }
}
