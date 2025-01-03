/*
 * Talha Chughtai
 * 12/16/24
 * HW 18 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter a name or 'q' to quit: ");
            String input = in.nextLine();
            if (input.equals("q")) {
                break;
            }
            names.add(input);
        }
        
        System.out.println("\nNames entered:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}