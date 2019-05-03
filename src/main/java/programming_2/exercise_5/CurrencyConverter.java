package programming_2.exercise_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CurrencyConverter {

    //todo: Berechnung bei Drücken der Enter Taste, Eingabe im unteren Textfeld ermöglichen
    //Methode updateInputTextfield bereits vorhanden

    private JFrame frame;
    private Container container;
    private JLabel euro;
    private JTextField input;
    private JTextField output;
    private JComboBox<String> conversionChoice;

    private CurrencyConverter() {
        initializeFrame();
    }

    private void initializeFrame() {
        frame = new JFrame("Currency Converter");
        frame.setSize(500, 400);
        container = frame.getContentPane();
        container.setLayout(new GridLayout(4,1));

        conversionChoice = new JComboBox<>();
        for(int i = 0; i < 12; i++) {
            conversionChoice.addItem(EuroConverter.getBezeichnung(i));
        }
        conversionChoice.addItemListener(new ConversionChoiceListener());

        euro = new JLabel("Euro");
        input = new JTextField();
        output = new JTextField();

        container.add(euro);
        container.add(input);
        container.add(conversionChoice);
        container.add(output);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updateOutputTextField(int chosenCurrencyIndex) {
        double amountInEuros = Double.parseDouble(input.getText());
        double amountInChosenCurrency = EuroConverter.convertFromEuro(amountInEuros, chosenCurrencyIndex);
        output.setText(String.valueOf(amountInChosenCurrency));
    }

    private void updateInputTextField(int chosenCurrencyIndex) {
        double amountInChosenCurrency = Double.parseDouble(output.getText());
        double amountInEuros = EuroConverter.convertToEuro(amountInChosenCurrency, chosenCurrencyIndex);
        input.setText(String.valueOf(amountInEuros));
    }

    private class ConversionChoiceListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            int chosenIndex = conversionChoice.getSelectedIndex();
            updateOutputTextField(chosenIndex);
        }
    }

    public static void main(String[] args) {
        CurrencyConverter currencyConverter = new CurrencyConverter();
    }
}
