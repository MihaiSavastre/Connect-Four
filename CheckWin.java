import java.awt.*;

class CheckWin {
    private final static int ROWS = ButtonBoard.ROWS;
    private final static int COLS = ButtonBoard.COLS;
    public static void checkWin() {
        //check all cells if they are the starting point of a winning line
        //return bottom-left-most if two exist
        for (int i = ROWS - 1; i >= 0; i--) {
            for (int j = 0; j < COLS; j++) {
                //avoid empty cells
                if (ButtonBoard.getButton(i,j).getBackground().equals(ConnectFour.defaultBackground)) continue;
                Direction foundDir = findFour(i, j);
                //Direction(0,0) is return of findFour on unsuccessful find
                if (!foundDir.equals(new Direction(0,0))) endGame(i, j, foundDir);
            }
        }
    }

    private static Direction findFour(int startRow, int startCol) {
        //all possible lines and diagonals from a given point
        final Direction[] directions = {
                new Direction(1,0), new Direction(1,1), new Direction (0,1),
                new Direction(-1,1), new Direction(-1, 0), new Direction(-1,-1),
                new Direction (0, -1), new Direction(1, -1)
        };

        Color checkedValue = ButtonBoard.getButton(startRow,startCol).getBackground();

        for (Direction dir : directions) {
            //check boundaries
            if (startRow + 3 * dir.row >= ROWS || startRow + 3 * dir.row < 0) continue;
            if (startCol + 3 * dir.col >= COLS || startCol + 3 * dir.col < 0) continue;

            //check if the next 3 cells in the direction are the same
            boolean win = true;
            for (int i = 1; i < 4; i++) {
                if (!ButtonBoard.getButton(startRow + i * dir.row,startCol + i * dir.col)
                        .getBackground().equals(checkedValue)) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return dir;
            }
        }
        return new Direction(0,0);
    }

    private static void endGame(int startRow, int startCol, Direction foundDir) {

        for (int i = 0; i < 4; i++) {
            ButtonBoard.getButton(startRow + i * foundDir.row, startCol + i * foundDir.col)
                    .setBackground(Color.GREEN);
        }
        Cell.movesLeft = 0;
    }
}

class Direction {
    int row;
    int col;

    public Direction (int i, int j) {
        row = i;
        col = j;
    }

    public boolean equals (Direction dir) {
        return this.row == dir.row && this.col == dir.col;
    }
}