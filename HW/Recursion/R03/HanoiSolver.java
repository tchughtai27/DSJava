import java.util.*;

public class HanoiSolver {

    static List<Stack<Integer>> pegs = new ArrayList<>();
    static int totalDisks;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of disks to solve: ");
        totalDisks = scanner.nextInt();

        // Initialize 3 pegs
        for (int i = 0; i < 3; i++) {
            pegs.add(new Stack<>());
        }

        // Put all disks on peg 0
        for (int i = totalDisks; i >= 1; i--) {
            pegs.get(0).push(i);
        }

        clearScreen();
        drawPegs();
        Thread.sleep(1500);

        hanoi(totalDisks, 0, 2);

        scanner.close();
    }

    public static void hanoi(int n, int start, int end) throws InterruptedException {
        if (n == 1) {
            moveDisk(start, end);
        } else {
            int interim = 3 - start - end;
            hanoi(n - 1, start, interim);
            moveDisk(start, end);
            hanoi(n - 1, interim, end);
        }
    }

    public static void moveDisk(int start, int end) throws InterruptedException {
        int disk = pegs.get(start).pop();
        pegs.get(end).push(disk);

        clearScreen();
        drawPegs();
        Thread.sleep(1000);
    }

    public static void drawPegs() {
        int pegCount = 3;
        int pegHeight = totalDisks;

        for (int level = 0; level < pegHeight; level++) {
            for (int peg = 0; peg < pegCount; peg++) {
                int pegLevel = pegHeight - level - 1; // Bottom to top
                Stack<Integer> currentPeg = pegs.get(peg);

                if (pegLevel < currentPeg.size()) {
                    int size = currentPeg.get(pegLevel);
                    printDisk(size);
                } else {
                    if (currentPeg.isEmpty()) {
                        printDisk(0); // Empty peg, still draw a rod
                    } else {
                        printRod(); // Rod should be continuous upwards
                    }
                }
            }
            System.out.println();
        }

        System.out.println("   1            2            3 ");
    }

    public static void printDisk(int size) {
        int totalWidth = totalDisks * 2;
        int width = size * 2;
        int spaces = (totalWidth - width) / 2;

        for (int i = 0; i < spaces; i++)
            System.out.print(" ");
        if (size == 0) {
            System.out.print("|");
        } else {
            for (int i = 0; i < width; i++)
                System.out.print("=");
        }
        for (int i = 0; i < spaces; i++)
            System.out.print(" ");

        System.out.print("     ");
    }

    public static void printRod() {
        int totalWidth = totalDisks * 2;
        int spaces = (totalWidth - 1) / 2;

        for (int i = 0; i < spaces; i++)
            System.out.print(" ");
        System.out.print("|");
        for (int i = 0; i < spaces; i++)
            System.out.print(" ");

        if (totalWidth % 2 == 0)
            System.out.print(" "); // Even width correction
        System.out.print("     ");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
