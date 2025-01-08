package mathutils;

public class Geometry {
    public static double calcVolSphere(double r) {
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);  // Volume formula (4/3)πr³
    }

    public static double calcSurfSphere(double r) {
        return 4 * Math.PI * Math.pow(r, 2);  // Surface area formula 4πr²
    }
}
