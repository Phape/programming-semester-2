package FunctionalProgramming.ExamplesFromLectures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class ClientGUI {
    static String weather;

    public static void serverAnfrage() {
        weather = Server.getData();
    }


    public static void main(String[] args) {
        Font myFont = new Font("Arial", Font.PLAIN, 40);
        JFrame frame = new JFrame();
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        b1.setFont(myFont);
        b2.setFont(myFont);
        frame.setLayout(new GridLayout(1,2));
        frame.add(b1);
        frame.add(b2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,100);
        frame.setVisible(true);

        ActionListener listener1 = e -> {
            Runnable r = () -> {

                serverAnfrage();
                JButton button = (JButton) e.getSource();
                button.setText(weather);
            };
            new Thread(r).start(); //set this line as comment to test
        };

        ActionListener listener2 = e -> {
            int random = (int)(Math.random() * 100);
            JButton button = (JButton)e.getSource();
            button.setText("" + random);
        };

        b1.addActionListener(listener1);
        b2.addActionListener(listener2);
    }
}


