/*
 * Challenge 2/3 Unit 02 AT3
 * Talha Chughtai
 * AT CS
 * 10/19 
 */

import java.util.Scanner;

public class ChallengeProblem2_PhoneFormat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a 10-digit telephone number: ");
        String phoneNumber = in.nextLine();
        
        String formattedNumber = String.format("(%s) %s-%s", //formatted here, %s means to keep it the same as it is
            phoneNumber.substring(0, 3), //each of the formatted sections
            phoneNumber.substring(3, 6), 
            phoneNumber.substring(6));
        
            System.out.println(formattedNumber);//print
    }

}