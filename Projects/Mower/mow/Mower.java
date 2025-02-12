package mow;

public class Mower {
    private int row;
    private int col;
    private int direction; // 0 = up, 1 = right, 2 = down, 3 = left

    public Mower(int startRow, int startCol, int startDirection) {
        this.row = startRow;
        this.col = startCol;
        this.direction = startDirection;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int newRow) {
        row = newRow;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int newCol) {
        col = newCol;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int newDirection) {
        direction = newDirection;
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
        yard.setCell(row, col, ' ');
    }
}
