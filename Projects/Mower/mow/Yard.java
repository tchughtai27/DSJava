package mow;

import java.util.Scanner;

// Class that should represent a yard with a lawn  red brick borders
public class Yard {
    private char[][] yard; // 2D array representing the yard
    private int lawnHeight; // Height of the lawn wihtout border
    private int lawnWidth; // Width of the lawn without border

    // Constructor that initializes the yard with given height and width
    public Yard(int height, int width) {
        this.lawnHeight = height;
        this.lawnWidth = width;
        int totalHeight = height + 2; // Including borders
        int totalWidth = width + 2; // Including borders

        yard = new char[totalHeight][totalWidth];

        // Loop through the yard for the red brick borders and unmowed grass
        for (int i = 0; i < totalHeight; i++) {
            for (int j = 0; j < totalWidth; j++) {
                if (i == 0 || i == totalHeight - 1 || j == 0 || j == totalWidth - 1) {
                    yard[i][j] = 'R'; // Represents red brick borders
                } else {
                    yard[i][j] = '+'; // Represents unmowed grass
                }
            }
        }
    }

    // Method to get the > at a specific cell in the yard
    public char getCell(int row, int col) {
        return yard[row][col];
    }

    // Method to set a specific cell in the yard
    public void setCell(int row, int col, char value) {
        yard[row][col] = value;
    }

    // Method to get the height of the lawn
    public int getLawnHeight() {
        return lawnHeight;
    }

    // Method to get the width of the lawn
    public int getLawnWidth() {
        return lawnWidth;
    }

    // Method to print the current yard
    public void printYard() {
        for (char[] row : yard) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    // Method to clear the console screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Main method to interact with the user and create a yard instance
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Ask user for lawn dimensions
        System.out.print("Enter the height of the lawn: ");
        int height = in.nextInt();

        System.out.print("Enter the width of the lawn: ");
        int width = in.nextInt();

        clearScreen(); // Clears the console screen
        Yard yard = new Yard(height, width); // Creates a Yard object with given dimensions

        yard.printYard(); // Display the yard
        in.close();
    }
}