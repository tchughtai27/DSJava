/*
 * Talha C
 * ATCS
 * HW25
 */

public class Car {
    private double speed; // Speed
    private static final double MAX_SPEED = 120.0; // Max
    private static final double MIN_SPEED = 0.0; // Min

    public Car() {
        this.speed = 0.0; // Set speed in this to 0
    }

    // Overloaded constructor with the initial speed
    public Car(double initialSpeed) {
        if (initialSpeed > MAX_SPEED) {
            this.speed = MAX_SPEED;
        } else if (initialSpeed < MIN_SPEED) {
            this.speed = MIN_SPEED;
        } else {
            this.speed = initialSpeed;
        }
    }

    // Get speed
    public double getSpeed() {
        return speed;
    }

    // Accelerate method
    public void accelerate() {
        if (speed < MAX_SPEED) {
            speed += 1.0;
        }
    }

    // Brake method
    public void brake() {
        if (speed > MIN_SPEED) {
            speed -= 0.1;
        }
    }

    public static void main(String[] args) {
        // Create a car with default speed (0.0 mph)
        Car car1 = new Car();
        System.out.println("Car 1 Initial Speed: " + String.format("%.1f", car1.getSpeed()) + " mph");

        // Accelerate car1 twice (is there a way to do this wihtout having to write it
        // twice?)
        car1.accelerate();
        car1.accelerate();
        System.out.println("Car 1 Speed after acceleration: " + String.format("%.1f", car1.getSpeed()) + " mph");

        // Brake car1 once
        car1.brake();
        System.out.println("Car 1 Speed after braking: " + String.format("%.1f", car1.getSpeed()) + " mph\n");

        // Create a car with an initial speed of 50.0 mph
        Car car2 = new Car(50.0);
        System.out.println("Car 2 Initial Speed: " + String.format("%.1f", car2.getSpeed()) + " mph");

        // Accelerate car2 until max speed
        while (car2.getSpeed() < MAX_SPEED) {
            car2.accelerate();
        }
        System.out.println("Car 2 Speed after full acceleration: " + String.format("%.1f", car2.getSpeed()) + " mph");

        // Brake car2 five times
        for (int i = 0; i < 5; i++) {
            car2.brake();
        }
        System.out.println("Car 2 Speed after braking: " + String.format("%.1f", car2.getSpeed()) + " mph");
    }
}

/*
 * Output is as expected
 */