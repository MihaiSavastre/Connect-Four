import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ResetButton extends JButton implements ActionListener {
    public ResetButton() {
        super();
        this.setText("Reset");
        this.setName("ButtonReset");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (var row : ButtonBoard.buttons) {
            for (Cell cell : row) {
                cell.setBackground(ConnectFour.defaultBackground);
                cell.setText(" ");
                Cell.resetPlayOrder();
            }
        }
    }
}
