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

        if (isPrime(x)) { //calls isPrime function from below
            System.out.println("Prime");
        } else {
            System.out.println("Not prime");
        }
    }
    //isPrime function
    public static boolean isPrime(int x) {  //this line means isPrime of int x has to return a boolean (true false)
        if (x<2) {
            return false; //1 is not prime
        } 
        for (int i = 2; i <= Math.sqrt(x); i++) { //checking for factors from 2, to the sqrt of x
            if (x % i == 0) {
                return false; //if its divisble by i, its not prime
            }
        }
        return true; // no divisors found means its prime
    }   
 }