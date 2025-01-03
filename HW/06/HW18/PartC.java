/*
 * Talha Chughtai
 * 12/16/24
 * HW 18 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class PartC {
    public static void main(String[] args) {
        ArrayList<Integer> temperatures = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int lowest = Integer.MAX_VALUE;
        
        System.out.println("Enter temperatures or 'q' to quit:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            int temp = Integer.parseInt(input);
            temperatures.add(temp);
            if (temp < lowest) {
                lowest = temp;
            }
        }
        
        System.out.println("\nTemperatures:");
        for (int temp : temperatures) {
            if (temp == lowest) {
                System.out.println(temp + " <= lowest");
            } else {
                System.out.println(temp);
            }
        }
    }
}