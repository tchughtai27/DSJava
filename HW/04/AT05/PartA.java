/*
 * Talha Chughtai AT05 PartA
 * 10/25
 */



import java.util.Random;

public class PartA {
    public static void main(String[] args) {
        Random in = new Random();

        for (int i = 0; i < 100; i++) {
            int randomNumber = in.nextInt(100);

            System.out.println(randomNumber);
        }
    }
}