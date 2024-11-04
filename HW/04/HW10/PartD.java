public class PartD {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            // Print leading dots
            for (int j = 5; j > i; j--) {
                System.out.print(".");
            }
            // Print the digit 'i' i times
            for (int k = 1; k <= i; k++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
