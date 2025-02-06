public class OverrideDemo {
    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        System.out.println("Bike speed = " + b.getSpeed());

        b.pedal();
        System.out.println("Bike speed = " + b.getSpeed());
    }
}