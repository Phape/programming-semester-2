package Programming2.Exercise_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeGui {
    private JFrame frame;
    private JLabel label;
    private JLabel dateTextField;
    private JComboBox<String> formatChoice;
    private Date date;
    private JButton refreshButton;
    private static final SimpleDateFormat shortDateFormat = new SimpleDateFormat("d.MM.yyyy (hh:mm)");
    private static final SimpleDateFormat normalDateFormat = new SimpleDateFormat("EEE, d.MMM, h:mm");
    private static final SimpleDateFormat longDateFormat = new SimpleDateFormat("d.MMM, h:mm:ss");
    public static SimpleDateFormat chosenDateFormat = longDateFormat;

    public TimeGui() {
        frame = new JFrame("Time");
        frame.setSize(500, 250);
        frame.setLayout(new BorderLayout());
        label = new JLabel("Date and time:");
        date = new Date(System.currentTimeMillis());
        dateTextField = new JLabel(chosenDateFormat.format(date));
        refreshButton = new JButton("refresh");
        refreshButton.addActionListener(new ButtonListener(dateTextField));

        formatChoice = new JComboBox<>();
        formatChoice.addItem("short Date");
        formatChoice.addItem("normal Date");
        formatChoice.addItem("long Date");

        frame.add(label, BorderLayout.WEST);
        frame.add(dateTextField, BorderLayout.EAST);
        frame.add(formatChoice, BorderLayout.NORTH);
        frame.add(refreshButton, BorderLayout.SOUTH);

        formatChoice.addItemListener(new DisplayListener());

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class DisplayListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            switch(formatChoice.getSelectedIndex()) {
                case 0:
                    chosenDateFormat = shortDateFormat;
                    break;
                case 1:
                    chosenDateFormat = normalDateFormat;
                    break;
                case 2:
                    chosenDateFormat = longDateFormat;
                    break;
            }
            dateTextField.setText(chosenDateFormat.format(date));
        }
    }

    public static void main(String[] args) {
        TimeGui timeGui = new TimeGui();
    }
}
