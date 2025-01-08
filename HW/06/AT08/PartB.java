
/*
 * Talha Chughtai
 * ATCS
 * HW AT08
 */
import math.Geometry;

public class PartB {
    public static void main(String[] args) {
        double radius = 5.0;
        double volume = Geometry.calcVolSphere(radius);
        double surfaceArea = Geometry.calcSurfSphere(radius);

        System.out.println("Volume of the sphere: " + volume);
        System.out.println("Surface area of the sphere: " + surfaceArea);
    }
}
