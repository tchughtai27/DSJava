public class PartB {
    private double x;
    private double y;

    public PartB() {
        this.x = 0;
        this.y = 0;
    }

    public PartB(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return Math.sqrt(x * x + y * y);
    }

    public double getAngle() {
        return Math.atan2(y, x);
    }

    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public double distanceTo(PartB other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        PartB p1 = new PartB();
        System.out.println("Default Point p1: (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("Polar coordinates of p1: r = " + p1.getR() + ", theta = " + p1.getAngle());

        PartB p2 = new PartB(3, 4);
        System.out.println("Point p2: (" + p2.getX() + ", " + p2.getY() + ")");
        System.out.println("Polar coordinates of p2: r = " + p2.getR() + ", theta = " + p2.getAngle());

        p2.translate(2, -1);
        System.out.println("After translating p2 by (2, -1): (" + p2.getX() + ", " + p2.getY() + ")");

        PartB p3 = new PartB(6, 8);
        System.out.println("Point p3: (" + p3.getX() + ", " + p3.getY() + ")");
        
        double distance = p2.distanceTo(p3);
        System.out.println("Distance from p2 to p3: " + distance);
    }
}
