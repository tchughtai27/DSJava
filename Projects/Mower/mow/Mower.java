package mow;

import java.util.Random;

public class Mower {
    private int row;
    private int col;
    private int direction; // 0 = up, 1 = right, 2 = down, 3 = left

    public Mower() {
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getDirection() {
        return direction;
    }

    public void randomizePosition(Yard yard) {
        Random random = new Random();
        int corner = random.nextInt(4); // Randomize starting corner
        switch (corner) {
            case 0 -> {
                row = 1;
                col = 1;
            } // Top-left
            case 1 -> {
                row = 1;
                col = yard.getLawnWidth();
            } // Top-right
            case 2 -> {
                row = yard.getLawnHeight();
                col = yard.getLawnWidth();
            } // Bottom-right
            case 3 -> {
                row = yard.getLawnHeight();
                col = 1;
            } // Bottom-left
        }
        direction = random.nextInt(4); // Randomize initial direction
    }

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

        return yard.getCell(nextRow, nextCol) == 'R';
    }

    public void cutGrass(Yard yard) {
        yard.setCell(row, col, ' '); // Mark current position as mowed
    }

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

    public void turnLeft() {
        direction = (direction + 3) % 4; // Turns left (counterclockwise)
    }

    public void turnRight() {
        direction = (direction + 1) % 4; // Turns right (clockwise)
    }

    public boolean updateMower(Yard yard) {
        if (yard.hasUnmowedGrass()) {
            // If there is unmowed grass directly in front, move forward
            if (!senseObstacle(yard) && canMowInFront(yard)) {
                moveForward();
            }
            // If there is unmowed grass to the right, turn right and move
            else if (canMowToRight(yard)) {
                turnRight();
                moveForward();
            }
            // If there is no grass in front or to the right, turn left
            else {
                turnLeft();
            }
            cutGrass(yard); // Always cut grass at the current position
            return true;
        }
        return false; // No unmowed grass left
    }

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

        return yard.getCell(nextRow, nextCol) == '+'; // Unmowed grass
    }

    private boolean canMowToRight(Yard yard) {
        int nextRow = row;
        int nextCol = col;

        // Calculate position to the right of the current direction
        if (direction == 0)
            nextCol++; // Facing up -> right is +1 column
        else if (direction == 1)
            nextRow++; // Facing right -> right is +1 row
        else if (direction == 2)
            nextCol--; // Facing down -> right is -1 column
        else if (direction == 3)
            nextRow--; // Facing left -> right is -1 row

        return yard.getCell(nextRow, nextCol) == '+'; // Unmowed grass
    }
}
