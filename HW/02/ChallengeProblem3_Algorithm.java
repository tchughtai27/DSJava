/*
 * Challenge 3/3 Unit 02 AT3
 * Talha Chughtai
 * AT CS
 * 10/19 
 */

 import java.util.Scanner;

 public class ChallengeProblem3_Algorithm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a positive integer: ");
        int x = in.nextInt();

        if (isPrime(x)) {
            System.out.println("Prime");
        } else {
            System.out.println("Not prime");
        }
    }
    public static boolean isPrime(int x) {
        if (x<2) {
            return false;
        } 
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false; 
            }
        }
        return true;
    }   
 }