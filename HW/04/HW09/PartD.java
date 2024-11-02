/*
 * Talha Chughtai
 * ATCS
 * HW 09 Part D
 * 10/28
 */
import java.util.Scanner;

public class PartD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Die die = new Die();  

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

   
    public Die() {
        roll();  
    }

    
    public void roll() {
        currentValue = (int) (Math.random() * 6) + 1;  
    }

    
    public int getCurrentValue() {
        return currentValue;
    }

    
    public String getAsciiRepresentation() {
        return switch (currentValue) {
            case 1 -> " _______\n|       |\n|   *   |\n|_______|"; // Is this the way we were suppposed to do this?
            case 2 -> " _______\n| *     |\n|       |\n|_____*_|";
            case 3 -> " _______\n| *     |\n|   *   |\n|_____*_|";
            case 4 -> " _______\n| *   * |\n|       |\n|_*___*_|";
            case 5 -> " _______\n| *   * |\n|   *   |\n|_*___*_|";
            case 6 -> " _______\n| *   * |\n| *   * |\n|_*___*_|";
            default -> "Error: Invalid die value!";
        };
    }
}

