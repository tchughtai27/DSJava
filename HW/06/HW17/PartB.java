/*
 * Talha C
 * HW17 
 * Due 12/13
 */
public class PartB {
    public static void main(String[] args) {
        // Declare and initialize the first array
        int[][] firstArray = {
            {8, 6, 7},
            {5, 3, 0}
        };

        // Declare and initialize the second array
        int[][] secondArray = {
            {0, 7, 6, 5},
            {2, 2, 0, 1},
            {8, 4, 5, 7}
        };

        // Print the first array
        System.out.println("First array:");
        print(firstArray);

        // Print the second array
        System.out.println("\nSecond array:");
        print(secondArray);
    }

    // Method to print a 2D array in row by column format
    public static void print(int[][] values) {
        for (int[] row : values) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

