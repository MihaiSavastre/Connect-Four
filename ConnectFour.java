import javax.swing.*;
import java.awt.*;

/*
ConnectFour class arranges the UI elements
 */

public class ConnectFour extends JFrame {
    public static final Color defaultBackground = Color.lightGray;

    public static void main(String[] args) {
        new ConnectFour();
    }

    public ConnectFour() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Connect Four");

        //create the grid
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(ButtonBoard.ROWS, ButtonBoard.COLS));

        for (int i = 0; i < ButtonBoard.ROWS; i++) {
            for (int j = 0; j < ButtonBoard.COLS; j++) {
                String name = Character.toString(j + 'A') + (ButtonBoard.ROWS - i);
                Cell button = new Cell(name, i, j);
                grid.add(button);
            }
        }

        //create reset button
        JPanel reset = new JPanel();
        reset.setLayout(new FlowLayout(FlowLayout.RIGHT));
        ResetButton resetButton = new ResetButton();
        reset.add(resetButton);

        //all together
        setLayout(new BorderLayout());
        add(grid, BorderLayout.CENTER);
        add(reset, BorderLayout.SOUTH);
        setVisible(true);
    }

}









