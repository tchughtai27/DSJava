public class InvertedTriangle {

    public static void printInverted(int n) {
        if (n == 0) {
            return;
        }
        printStars(n);
        System.out.println();
        printInverted(n - 1);
    }

    private static void printStars(int count) {
        if (count == 0)
            return;
        System.out.print("*");
        printStars(count - 1);
    }

    public static void main(String[] args) {
        printInverted(5);
    }
}
