package mow;

public class Yard {
    private char[][] yard;
    private int lawnHeight;
    private int lawnWidth;

    public Yard(int height, int width) {
        this.lawnHeight = height;
        this.lawnWidth = width;
        int totalHeight = height + 2; // Adding borders
        int totalWidth = width + 2;

        yard = new char[totalHeight][totalWidth];
        for (int i = 0; i < totalHeight; i++) {
            for (int j = 0; j < totalWidth; j++) {
                if (i == 0 || i == totalHeight - 1 || j == 0 || j == totalWidth - 1) {
                    yard[i][j] = 'R'; // Red brick border
                } else {
                    yard[i][j] = '+'; // Unmowed grass
                }
            }
        }
    }

    public char getCell(int row, int col) {
        return yard[row][col];
    }

    public void setCell(int row, int col, char value) {
        yard[row][col] = value;
    }

    public boolean hasUnmowedGrass() {
        for (int i = 1; i <= lawnHeight; i++) {
            for (int j = 1; j <= lawnWidth; j++) {
                if (yard[i][j] == '+') {
                    return true; // Found unmowed grass
                }
            }
        }
        return false;
    }

    public void printYard(Mower mower) {
        char[][] yardCopy = copyYard();
        yardCopy[mower.getRow()][mower.getCol()] = getDirectionArrow(mower.getDirection());
        for (char[] row : yardCopy) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private char[][] copyYard() {
        char[][] copy = new char[yard.length][yard[0].length];
        for (int i = 0; i < yard.length; i++) {
            System.arraycopy(yard[i], 0, copy[i], 0, yard[i].length);
        }
        return copy;
    }

    private char getDirectionArrow(int direction) {
        switch (direction) {
            case 0:
                return '^';
            case 1:
                return '>';
            case 2:
                return 'v';
            case 3:
                return '<';
        }
        return ' ';
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int getLawnHeight() {
        return lawnHeight;
    }

    public int getLawnWidth() {
        return lawnWidth;
    }
}
