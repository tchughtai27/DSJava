package mow;

import java.util.Random;

public class Mower {
    private int row; // Current row position of the mower
    private int col; // Current column position of the mower
    private int direction; // Current direction (0 = up, 1 = right, 2 = down, 3 = left)

    // Constructor
    public Mower() {
    }

    // Get the current row of the mower
    public int getRow() {
        return row;
    }

    // Get the current column of the mower
    public int getCol() {
        return col;
    }

    // Get the current direction of the mower
    public int getDirection() {
        return direction;
    }

    // Randomize the mower's starting position and direction
    public void randomizePosition(Yard yard) {
        Random random = new Random();
        int corner = random.nextInt(4); // Randomly pick one of four corners

        // Assign the row and column based on the chosen corner
        switch (corner) {
            case 0 -> {
                row = 1;
                col = 1;
            } // Top-left corner
            case 1 -> {
                row = 1;
                col = yard.getLawnWidth();
            } // Top-right corner
            case 2 -> {
                row = yard.getLawnHeight();
                col = yard.getLawnWidth();
            } // Bottom-right corner
            case 3 -> {
                row = yard.getLawnHeight();
                col = 1;
            } // Bottom-left corner
        }

        direction = random.nextInt(4); // Randomly set initial direction
    }

    // Check if there's an obstacle (like a border) in front of the mower
    public boolean senseObstacle(Yard yard) {
        int nextRow = row;
        int nextCol = col;

        if (direction == 0)
            nextRow--; // Check up
        else if (direction == 1)
            nextCol++; // Check right
        else if (direction == 2)
            nextRow++; // Check down
        else if (direction == 3)
            nextCol--; // Check left

        return yard.getCell(nextRow, nextCol) == 'R'; // Return true if it's a border
    }

    // Mark the current spot as mowed
    public void cutGrass(Yard yard) {
        yard.setCell(row, col, ' '); // Change the cell to ' ' (mowed)
    }

    // Move the mower forward in its current direction
    public void moveForward() {
        if (direction == 0)
            row--; // Move up
        else if (direction == 1)
            col++; // Move right
        else if (direction == 2)
            row++; // Move down
        else if (direction == 3)
            col--; // Move left
    }

    // Turn the mower 90 degrees to the left
    public void turnLeft() {
        direction = (direction + 3) % 4; // Update direction for a left turn
    }

    // Turn the mower 90 degrees to the right
    public void turnRight() {
        direction = (direction + 1) % 4; // Update direction for a right turn
    }

    // Update the mower's position and behavior during the mowing process
    public boolean updateMower(Yard yard) {
        // If there is still unmowed grass, the mower will take action
        if (yard.hasUnmowedGrass()) {
            // Move forward if there's unmowed grass directly ahead
            if (!senseObstacle(yard) && canMowInFront(yard)) {
                moveForward();
            }
            // If there's unmowed grass to the right, turn right and move forward
            else if (canMowToRight(yard)) {
                turnRight();
                moveForward();
            }
            // If no grass ahead or to the right, turn left
            else {
                turnLeft();
            }
            // Cut grass at the current position
            cutGrass(yard);
            return true; // Mower continues working
        }
        return false; // No unmowed grass left
    }

    // Check if the mower can cut grass directly in front
    private boolean canMowInFront(Yard yard) {
        int nextRow = row;
        int nextCol = col;

        if (direction == 0)
            nextRow--; // Check up
        else if (direction == 1)
            nextCol++; // Check right
        else if (direction == 2)
            nextRow++; // Check down
        else if (direction == 3)
            nextCol--; // Check left

        return yard.getCell(nextRow, nextCol) == '+'; // Return true if it's unmowed grass
    }

    // Check if the mower can cut grass to its right
    private boolean canMowToRight(Yard yard) {
        int nextRow = row;
        int nextCol = col;

        // Determine the position to the right based on the current direction
        if (direction == 0)
            nextCol++; // Facing up = right is +1 column
        else if (direction == 1)
            nextRow++; // Facing right = right is +1 row
        else if (direction == 2)
            nextCol--; // Facing down = right is -1 column
        else if (direction == 3)
            nextRow--; // Facing left = right is -1 row

        return yard.getCell(nextRow, nextCol) == '+'; // Return true if it's unmowed grass
    }
}
