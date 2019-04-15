package FunctionalProgramming; //sheet 2 ex. 4

import javax.swing.*;
import java.awt.*;

public class LambdaFrame {

    private JFrame frame;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private int button1Count;
    private int button2Count;
    private int button3Count;

    private void initializeFrame() {
        frame = new JFrame("LambdaFrame");
        frame.setSize(500,200);
        frame.setLayout(new GridLayout(1,3));

        button1Count = button2Count = button3Count = 0;

        button1 = new JButton(String.valueOf(button1Count));
        button2 = new JButton(String.valueOf(button2Count));
        button3 = new JButton(String.valueOf(button3Count));

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        //increase the button counters by 1 and display the new text on the button
        button1.addActionListener(e -> button1.setText(String.valueOf(++button1Count)));
        button2.addActionListener(e -> button2.setText(String.valueOf(++button2Count)));
        button3.addActionListener(e -> button3.setText(String.valueOf(++button3Count)));

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        LambdaFrame lambdaFrame = new LambdaFrame();
        lambdaFrame.initializeFrame();
    }
}
