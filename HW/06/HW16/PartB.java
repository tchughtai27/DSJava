public class PartB {
    public static void main(String[] args) {
        // Test case 1: Direct values
        double avg1 = average(10, 8, 10);
        System.out.println("Average of 10, 8, 10: " + avg1);

        // Test case 2: Array of doubles
        double[] scores = {100, 90, 80, 100, 80};
        double avg2 = average(scores);
        System.out.println("Average of scores: " + avg2);
    }

    public static double average(double... values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}