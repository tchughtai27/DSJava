package mow;

public class Yard {
    private char[][] yard; // Represents the yard grid
    private int lawnHeight; // Height of the lawn (excluding borders)
    private int lawnWidth; // Width of the lawn (excluding borders)

    // Constructor to set up the yard
    public Yard(int height, int width) {
        this.lawnHeight = height;
        this.lawnWidth = width;
        int totalHeight = height + 2; // Add borders
        int totalWidth = width + 2;

        yard = new char[totalHeight][totalWidth];
        // Fill the yard grid with borders and grass
        for (int i = 0; i < totalHeight; i++) {
            for (int j = 0; j < totalWidth; j++) {
                if (i == 0 || i == totalHeight - 1 || j == 0 || j == totalWidth - 1) {
                    yard[i][j] = 'R'; // Border (red brick)
                } else {
                    yard[i][j] = '+'; // Grass (unmowed)
                }
            }
        }
    }

    // Get the character at a specific position in the yard
    public char getCell(int row, int col) {
        return yard[row][col];
    }

    // Set a specific position in the yard to a new value
    public void setCell(int row, int col, char value) {
        yard[row][col] = value;
    }

    // Check if there is still unmowed grass in the yard
    public boolean hasUnmowedGrass() {
        for (int i = 1; i <= lawnHeight; i++) {
            for (int j = 1; j <= lawnWidth; j++) {
                if (yard[i][j] == '+') { // If grass is still unmowed
                    return true;
                }
            }
        }
        return false;
    }

    // Print the yard to the console
    public void printYard(Mower mower) {
        char[][] yardCopy = copyYard(); // Make a copy of the yard
        yardCopy[mower.getRow()][mower.getCol()] = getDirectionArrow(mower.getDirection()); // Add mower's position
        for (char[] row : yardCopy) {
            for (char cell : row) {
                System.out.print(cell); // Print each cell
            }
            System.out.println();
        }
    }

    // Create a copy of the yard grid (to keep original yard intact)
    private char[][] copyYard() {
        char[][] copy = new char[yard.length][yard[0].length];
        for (int i = 0; i < yard.length; i++) {
            System.arraycopy(yard[i], 0, copy[i], 0, yard[i].length);
        }
        return copy;
    }

    // Get the arrow symbol based on the mower's direction
    private char getDirectionArrow(int direction) {
        switch (direction) {
            case 0:
                return '^'; // Facing up
            case 1:
                return '>'; // Facing right
            case 2:
                return 'v'; // Facing down
            case 3:
                return '<'; // Facing left
        }
        return ' '; // Default (if direction is invalid)
    }

    // Pause the program for a given amount of time (in milliseconds)
    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Clear the console screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Get the height of the lawn (without borders)
    public int getLawnHeight() {
        return lawnHeight;
    }

    // Get the width of the lawn (without borders)
    public int getLawnWidth() {
        return lawnWidth;
    }
}
