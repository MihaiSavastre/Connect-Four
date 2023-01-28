/*
Class of global variables
To encapsulate the board implementation, each button could store its row and col and
loop in other classes could iterate over a getter for buttons and call getRow and getCol
whenever an iteration index is used in the current implementation
 */
public class ButtonBoard {
    public static final int ROWS = 6;
    public static final int COLS = 7;
    public static Cell[][] buttons = new Cell[ROWS][COLS];

    public static void setButton (Cell button, int row, int col) {
        buttons[row][col] = button;
    }

    public static Cell getButton  (int row, int col) {
        return buttons[row][col];
    }
}
