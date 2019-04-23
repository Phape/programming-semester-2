package Programming2.Exercise_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JTextField operand1;
    private JTextField operand2;
    private JLabel result;
    private JLabel operatorLabel;
    private JLabel equals;
    private JButton add;
    private JButton subtract;
    private JButton multiply;
    private JButton divide;
    private JButton reset;
    private double firstNumber;
    private double secondNumber;

    private Calculator() {
        frame = new JFrame();
        frame.setLayout(new GridLayout(2, 5));
        frame.setSize(1000,400);

        operand1 = new JTextField();
        operand2 = new JTextField();
        result = new JLabel();
        operatorLabel = new JLabel("", SwingConstants.CENTER);
        equals = new JLabel("=", SwingConstants.CENTER);
        add = new JButton("add");
        subtract = new JButton("subtract");
        multiply = new JButton("multiply");
        divide = new JButton("divide");
        reset = new JButton("reset");

        add.addActionListener(new OperatorListener('+'));
        subtract.addActionListener(new OperatorListener('-'));
        multiply.addActionListener(new OperatorListener('*'));
        divide.addActionListener(new OperatorListener('/'));
        reset.addActionListener(new OperatorListener('1'));

        frame.add(operand1);
        frame.add(operatorLabel);
        frame.add(operand2);
        frame.add(equals);
        frame.add(result);

        frame.add(add);
        frame.add(subtract);
        frame.add(multiply);
        frame.add(divide);
        frame.add(reset);

        

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class OperatorListener implements ActionListener {

        private char operator;

        private OperatorListener(char operator) {
            this.operator = operator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("reset")) {
                reset();
            }
            else {
                readUserInput();
                operatorLabel.setText(String.valueOf(operator));
                calculate(operator);
            }
        }
    }

    private void readUserInput() {
        try {
            firstNumber = Double.parseDouble(operand1.getText());
            secondNumber = Double.parseDouble(operand2.getText());
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "This is a calculator. Please don't enter random shit!");
            reset();
        }
    }

    private void calculate(char operator) {
        switch (operator) {
            case '+':
                result.setText(String.valueOf(firstNumber+secondNumber));
                break;
            case '-':
                result.setText(String.valueOf(firstNumber-secondNumber));
                break;
            case '*':
                result.setText(String.valueOf(firstNumber*secondNumber));
                break;
            case '/':
                result.setText(String.valueOf(firstNumber/secondNumber));
                break;

        }
    }

    private void reset() {
        firstNumber = 0;
        secondNumber = 0;
        operand1.setText("0");
        operand2.setText("0");
        result.setText("0");
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
