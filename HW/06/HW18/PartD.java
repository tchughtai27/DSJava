/*
 * Talha Chughtai
 * 12/16/24
 * HW 18 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class PartD {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter integers or 'q' to quit:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            int number = Integer.parseInt(input); //not sure if this is the way we are supposed to be doing this for these problems, but its something. 
            numbers.add(number);
        }
        
        numbers.removeIf(n -> n % 2 != 0); // Remove odd numbers
        
        System.out.println("\nModified List (Even Numbers Only):");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}