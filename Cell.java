import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Cell extends JButton {
    /*
    The Cell class is responsible for modifying the board
    The static variable movesLeft keeps track of whether a new cell can be activated.
    It initially allows for as many moves as cells on the board, but it can be overwritten by the endGame method
    If the parity of movesLeft is the same as the parity of the number of cells, the next piece will be an X,
    otherwise an O
     */
    private final static int ROWS = ButtonBoard.ROWS;
    private final static int COLS = ButtonBoard.COLS;
    private final static clickButton buttonListener = new clickButton();
    static int movesLeft = ROWS * COLS;

    public Cell(String name, int row, int col) {
        super();
        this.setText(" ");
        this.setName("Button" + name);
        this.setFocusPainted(false);
        this.addActionListener(buttonListener);
        this.setBackground(ConnectFour.defaultBackground);
        ButtonBoard.setButton(this, row, col);
    }

    public static void resetPlayOrder() {
        movesLeft = ROWS*COLS;
    }
    private void fillCell () {
        if (movesLeft % 2 == ROWS * COLS % 2) {
            //this.setText("X");
            this.setBackground(Color.RED);
        }
        else {
            //this.setText("O");
            this.setBackground(Color.YELLOW);
        }
        movesLeft--;
    }

    private int getCellColumn () {
        return this.getName().charAt(6) - 'A';
    }

    public static int lastEmptyRowInColumn (int col) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (ButtonBoard.getButton(i, col).getBackground().equals(ConnectFour.defaultBackground)) {
                return i;
            }
        }
        return -1;
    }

    //does not need to be a class, if it does not need to be private
    private static class clickButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (movesLeft == 0) return;
            Cell cell = ((Cell)e.getSource());
            int col = cell.getCellColumn();
            int row = lastEmptyRowInColumn(col);
            if (row == -1) return;
            ButtonBoard.getButton(row, col).fillCell();
            CheckWin.checkWin();
        }

    }
}