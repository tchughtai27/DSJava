import java.util.Scanner;

public class PRACTICAL_0304_B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Prompt the user to enter three integers
        System.out.print("Enter the first integer: ");
        int num1 = in.nextInt();

        System.out.print("Enter the second integer: ");
        int num2 = in.nextInt();

        System.out.print("Enter the third integer: ");
        int num3 = in.nextInt();

        
        if (num1 >= num2 && num2 >= num3) {
            System.out.println(num1 + " " + num2 + " " + num3);
        } else if (num1 >= num3 && num3 >= num2) {
            System.out.println(num1 + " " + num3 + " " + num2);
        } else if (num2 >= num1 && num1 >= num3) {
            System.out.println(num2 + " " + num1 + " " + num3);
        } else if (num2 >= num3 && num3 >= num1) {
            System.out.println(num2 + " " + num3 + " " + num1);
        } else if (num3 >= num1 && num1 >= num2) {
            System.out.println(num3 + " " + num1 + " " + num2);
        } else {
            System.out.println(num3 + " " + num2 + " " + num1);
        }

        in.close();
    }
}
