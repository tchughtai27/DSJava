
/*
 * Talha C
 * ATCS
 * HW24
 */
import java.util.Scanner;

public class Counter {
    private int totalCake = 0;
    private int totalPie = 0;

    public void addCake() {
        totalCake++;
    }

    public void addPie() {
        totalPie++;
    }

    public int getTotalCake() {
        return totalCake;
    }

    public int getTotalPie() {
        return totalPie;
    }

    public static void main(String[] args) {
        Counter z = new Counter();
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("Enter 'c' for cake, 'p' for pie, and 'q' to quit:");

        while (true) {
            input = in.nextLine().toLowerCase(); // Read input and convert to lowercase to match with respective letter

            if (input.equals("q")) {
                break; // Exit the loop if user enters q
            } else if (input.equals("c")) {
                z.addCake(); // Cake counter
            } else if (input.equals("p")) {
                z.addPie(); // Pie counter
            } else {
                System.out.println("Invalid input. Please enter 'c', 'p', or 'q'.");
            }
        }

        // Display the results after q is hit
        System.out.println("Total votes for cake: " + z.getTotalCake());
        System.out.println("Total votes for pie: " + z.getTotalPie());
    }
}
