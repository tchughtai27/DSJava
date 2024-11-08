public class PRACTICAL_0304_A {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;

        // Loops from 1 to 100 and calculates the sum
        for (int i = 1; i <= 100; i++) {
            sum += i;
            count++;
        }

        // Calculates the average
        double average = (double) sum / count;

        // Displays the average
        System.out.println("The average of integers from 1 to 100 is: " + average);
    }
}
