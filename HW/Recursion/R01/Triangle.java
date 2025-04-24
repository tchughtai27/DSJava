public class Triangle {

    public static void printTriangle(int n) {
        printTriangleH(1, n);
    }

    private static void printTriangleH(int current, int n) {
        if (current > n)
            return;
        printStars(current);
        System.out.println();
        printTriangleH(current + 1, n);
    }

    private static void printStars(int count) {
        if (count == 0)
            return;
        System.out.print("*");
        printStars(count - 1);
    }

    public static void main(String[] args) {
        printTriangle(1000);
    }
}
