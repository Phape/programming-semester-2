package programming_2.exercise_12;

import javax.swing.*;
import java.awt.*;

public class BlinkButton extends JButton implements Runnable {

    private String switchText = "Hoppala";

    public BlinkButton(String name) {
        super(name);
        new Thread(this).start();
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException iex) {}
            String s = this.getText();
            this.setText(switchText);//
            switchText = s;
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,200);
        frame.setLayout(new FlowLayout());
        frame.add(new BlinkButton("stupid testbutton"));
        frame.add(new BlinkButton("second testbutton"));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
