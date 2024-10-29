/*
 * Talha Chughtai
 * ATCS
 * HW 09 Part B
 * 10/28
 */
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a phrase: ");
        String phrase = in.nextLine();

        int e_count = 0;  

        
        for (int i = 0; i < phrase.length(); i++) {
            
            if (phrase.charAt(i) == 'e' || phrase.charAt(i) == 'E') {
                e_count++;  
            }
        }

        
        System.out.println("The letter 'e' occurred " + e_count + " times.");

        in.close();
    }
}

