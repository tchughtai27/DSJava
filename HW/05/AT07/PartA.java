/*
 * Talha Chughtai
 * ATCS
 * HW AT07 Part A
 * 11/9
 */
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of sides for the die (default is 6): ");
        int sides = scanner.nextInt();
        scanner.nextLine();  

        Die die;
        if (sides < 1) {
            System.out.println("Invalid number of sides. Defaulting to 6-sided die.");
            die = new Die();
        } else {
            die = new Die(sides);
        }

        System.out.println("Welcome!");
        System.out.println("Enter 'r' to roll the die, 'd' to display the current value, or 'q' to quit.");

        while (true) {
            System.out.print("Enter command (r/d/q): ");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "r":
                    die.roll(); 
                    System.out.println("You rolled a " + die.getCurrentValue() + "!");
                    break;
                case "d":
                    System.out.println("Current value of die: \n" + die.getAsciiRepresentation());
                    break;
                case "q":
                    System.out.println("Quitting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please enter 'r', 'd', or 'q'.");
            }
        }
    }
}

class Die {
    private int currentValue;  
    private final int numSides;  // Number of sides on the die

    // Default constructor (6-sided die)
    public Die() {
        this(6);  // Calls the other constructor with default 6 sides
    }

    // Overloaded constructor to specify number of sides
    public Die(int numSides) {
        if (numSides < 1) {
            throw new IllegalArgumentException("A die must have at least one side.");
        }
        this.numSides = numSides;
        roll();  // Initialize by rolling the die
    }

    // Roll die to get a random value based on the number of sides
    public void roll() {
        currentValue = (int) (Math.random() * numSides) + 1;  
    }

    // Get current face value
    public int getCurrentValue() {
        return currentValue;
    }

    // ASCII representation
    public String getAsciiRepresentation() {
        if (numSides != 6) {
            return "ASCII representation only available for a 6-sided die.";
        }

        return switch (currentValue) {
            case 1 -> " _______\n|       |\n|   *   |\n|_______|";
            case 2 -> " _______\n| *     |\n|       |\n|_____*_|";
            case 3 -> " _______\n| *     |\n|   *   |\n|_____*_|";
            case 4 -> " _______\n| *   * |\n|       |\n|_*___*_|";
            case 5 -> " _______\n| *   * |\n|   *   |\n|_*___*_|";
            case 6 -> " _______\n| *   * |\n| *   * |\n|_*___*_|";
            default -> "Error: Invalid die value!";
        };
    }
}
