package functional_programming.exercise_sheet_2; //sheet 2 ex. 4

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LambdaFrame {

    private JFrame frame;
    private JButton[] buttons;
    private int[] buttonCounts;
    private Font myFont = new Font("Arial", Font.PLAIN, 20);
    private final int MAX_VALUE = 1000;
    //increase the button counters by 1 and display the new text on the button
    private ActionListener al = e -> {
        if (e.getSource() == buttons[0])
            buttons[0].setText(String.valueOf(++buttonCounts[0]));
        if (e.getSource() == buttons[1])
            buttons[1].setText(String.valueOf(++buttonCounts[1]));
        if (e.getSource() == buttons[2])
            buttons[2].setText(String.valueOf(++buttonCounts[2]));
    }; //I think there might be a more efficient way to code this lambda expression [maybe with e.getSource()]


    private void initializeFrame() {
        frame = new JFrame("LambdaFrame");
        frame.setSize(500,200);
        frame.setLayout(new GridLayout(1,3));

        buttons = new JButton[3];
        buttonCounts = new int[3];

        //initializes the buttonCounts with 0, adds that to the buttons, sets myFont as Font for the buttons,
        // adds ActionListeners and adds the buttons to the frame
        for (int i = 0; i < 3; i++) {
            buttonCounts[i] = 0;
            buttons[i] = new JButton(String.valueOf(buttonCounts[i]));
            buttons[i].setFont(myFont);
            buttons[i].addActionListener(al);
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * increases the value of one random button by 1
     */
    public void increaseCount() {
        while(!checkMaxReached()) {
            int random = (int) (Math.random() * 3);
           // buttons[random].doClick(); //slower alternative to the following two lines
            ++buttonCounts[random];
            buttons[random].setText(String.valueOf(++buttonCounts[random]));
            //I implemented the Thread.sleep for the faster alternative above so the buttonCounts do not instantly reach 1000
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean checkMaxReached() {
        for (int buttonCount : buttonCounts) {
            if (buttonCount >= MAX_VALUE)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        LambdaFrame lambdaFrame = new LambdaFrame();
        lambdaFrame.initializeFrame();
        Runnable runnable = lambdaFrame::increaseCount;
        runnable.run();
    }
}
