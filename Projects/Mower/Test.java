import java.util.Scanner;
import mow.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the height of the lawn: ");
        int height = scanner.nextInt();

        System.out.print("Enter the width of the lawn: ");
        int width = scanner.nextInt();

        Yard yard = new Yard(height, width);
        Mower mower = new Mower();
        mower.randomizePosition(yard);

        System.out.println("Starting position of mower:");
        Yard.clearScreen();
        yard.printYard(mower);

        while (mower.updateMower(yard)) {
            Yard.delay(500);
            Yard.clearScreen();
            yard.printYard(mower);
        }

        System.out.println("All grass mowed!");
        scanner.close();
    }
}
