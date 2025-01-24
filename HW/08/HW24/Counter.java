import java.util.Scanner;

public class Counter {
    public int look() {
        return total;
    }

    public int pie() {
        this.total_pie = this.total_pie + 1;
        return total_pie;
    }

    public int cake() {
        this.total_cake = this.total_cake + 1;
        return total_cake;
    }

    private int total = 0;
    private int total_cake = 0;
    private int total_pie = 0;

    public static void main(String[] args) {
        Counter a = new Counter();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 'c' for cake, 'p' for pie, and 'q' to quit");
        String s = in.nextLine();
        if (in.hasNext("c")) {
            a.cake();
        } else if (in.hasNext("p")) {
            a.pie();
        } else {
            System.out.println("Ending program.");
        }

    }
}