public class Factorial {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater than or equal to zero.");
        }

        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void doFactorial(int n) {
        System.out.printf("factorial(%d) = %d%n", n, factorial(n));
    }

    public static void main(String[] args) {
        doFactorial(0);
        doFactorial(1);
        doFactorial(5);
    }
}