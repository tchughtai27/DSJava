import java.util.Scanner;

public class PartC {
    public static void main(String[] args) {
        final double COST_OF_COOKIE = 0.99;

        // Prompt user for the number of cookies they are buying.
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of cookies: ");
        int num = in.nextInt(); //was a compile error here

        // Calculate the cost before discount.
        double cost = num * COST_OF_COOKIE;

        // Determine discount based on the cookies.
        double discount = 0; //was a logic error
        if (num > 24) {
            discount = 0.15;
        } else if (num > 12) {
            discount = 0.05;
        } else if (num > 6) {
            discount = 0.025;
        }

        // Apply the discount to total cost and display 
        cost = cost * (1 - discount);
        System.out.printf("For %d cookies, your total cost is $%.2f%n", num, cost);
    }
}
