package Aufgabe_3;

import javax.swing.*;

public class TrafficLight {

    private JFrame frame;
    private ButtonGroup buttonGroup;
    private JRadioButton radioButton;

    public TrafficLight() {
        frame = new JFrame("Traffic light");
        frame.setSize(500, 250);
        buttonGroup = new ButtonGroup();
        radioButton = new JRadioButton("TestButton");
        //frame.add(buttonGroup);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
    }
}
