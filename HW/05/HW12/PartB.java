/*
 * Talha Chughtai 11/14
 * ATCS HW12 PartB
 */
public class PartB {
    
    // Method to find the smallest of three double values
    public static double smallest(double x, double y, double z) {
        if (x <= y && x <= z) {
            return x;
        } else if (y <= x && y <= z) {
            return y;
        } else {
            return z;
        }
    }

    // Main method to test the smallest method
    public static void main(String[] args) {
        // Test cases
        double a = 3.5, b = 2.8, c = 4.1;
        System.out.println("The smallest of " + a + ", " + b + ", and " + c + " is: " + smallest(a, b, c));

        a = -1.5; b = -2.3; c = -1.9;
        System.out.println("The smallest of " + a + ", " + b + ", and " + c + " is: " + smallest(a, b, c));

        a = 5.0; b = 5.0; c = 5.0;
        System.out.println("The smallest of " + a + ", " + b + ", and " + c + " is: " + smallest(a, b, c));
    }
}
