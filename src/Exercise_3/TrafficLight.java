package Exercise_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLight {

    private JFrame frame;
    private ButtonGroup buttonGroup;
    private JRadioButton redRadioButton;
    private JRadioButton yellowRadioButton;
    private JRadioButton greenRadioButton;
    private JButton redButton;
    private JButton yellowButton;
    private JButton greenButton;


    public TrafficLight() {
        frame = new JFrame("Traffic light");
        frame.setSize(500, 250);
        frame.setLayout(new GridLayout(3, 2));

        buttonGroup = new ButtonGroup();
        redRadioButton = new JRadioButton("red", true);
        yellowRadioButton = new JRadioButton("yellow");
        greenRadioButton = new JRadioButton("green");
        redButton = new JButton();
        yellowButton = new JButton();
        greenButton = new JButton();

        buttonGroup.add(redRadioButton);
        buttonGroup.add(yellowRadioButton);
        buttonGroup.add(greenRadioButton);

        redButton.setActionCommand("red");
        yellowButton.setActionCommand("yellow");
        greenButton.setActionCommand("green");

        ButtonHandler bh = new ButtonHandler();
        redRadioButton.addActionListener(bh);
        redButton.addActionListener(bh);
        yellowRadioButton.addActionListener(bh);
        yellowButton.addActionListener(bh);
        greenRadioButton.addActionListener(bh);
        greenButton.addActionListener(bh);

        frame.add(redRadioButton);
        frame.add(redButton);
        frame.add(yellowRadioButton);
        frame.add(yellowButton);
        frame.add(greenRadioButton);
        frame.add(greenButton);

        redButton.setBackground(Color.RED);
        yellowButton.setBackground(Color.BLACK);
        greenButton.setBackground(Color.BLACK);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            redButton.setBackground(Color.BLACK);
            yellowButton.setBackground(Color.BLACK);
            greenButton.setBackground(Color.BLACK);

            switch (e.getActionCommand()) {
                case "red":
                    redButton.setBackground(Color.RED);
                    break;
                case "yellow":
                    yellowButton.setBackground(Color.YELLOW);
                    break;
                case "green":
                    greenButton.setBackground(Color.GREEN);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
    }
}
