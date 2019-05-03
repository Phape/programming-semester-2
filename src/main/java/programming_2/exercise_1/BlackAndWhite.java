package programming_2.exercise_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BlackAndWhite extends JFrame {
    private Container container;
    private JButton button;

    public BlackAndWhite() {
        container = this.getContentPane();
        button = new JButton("Click me!");
        button.addActionListener(new ButtonHandler(container));

        container.setLayout(new FlowLayout());
        container.add(button);
        container.addMouseListener(new MouseHandler());

    }

    private class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            container.setBackground(Color.WHITE);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public static void main(String[] args) {
        BlackAndWhite gui = new BlackAndWhite();
        gui.setVisible(true);
        gui.setSize(500, 250);
        gui.setLocationRelativeTo(null);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
