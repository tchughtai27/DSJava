/*
 * Talha Chughtai ATCS
 * HW11 PartC
 * 11/4
 */
import java.util.Scanner;

public class PartC {
    
    // Method that calculates the volume of a sphere
    public static double calculateSphereVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Asking for the radius
        System.out.print("Enter the radius of the sphere: ");
        double radius = in.nextDouble();
        
        // Calculating volume by invoking the method
        double volume = calculateSphereVolume(radius);
        
        // Displaying the volume
        System.out.printf("The volume of the sphere with radius %.2f is %.2f%n", radius, volume);
        
        in.close();
    }
}
