package programming_2.exercise_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import static programming_2.exercise_2.TimeGui.chosenDateFormat;

public class ButtonListener implements ActionListener {

    private JLabel dateTextField;
    private Date date;

    public ButtonListener(JLabel dateTextField) {
        this.dateTextField = dateTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        date = new Date(System.currentTimeMillis());
        dateTextField.setText(chosenDateFormat.format(date));
    }
}
