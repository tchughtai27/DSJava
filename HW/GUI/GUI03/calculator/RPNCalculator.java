package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RPNCalculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        JFrame frame = new JFrame("RPN Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JTextField inputField = new JTextField(20);
        JTextField resultField = new JTextField(20);
        resultField.setEditable(false);

        JButton evaluateButton = new JButton("Evaluate");
        evaluateButton.addActionListener((ActionEvent e) -> {
            String input = inputField.getText();
            double result = calculator.evaluate(input);
            resultField.setText(String.valueOf(result));
        });

        c.gridx = 0;
        c.gridy = 0;
        panel.add(new JLabel("Enter Expression:"), c);

        c.gridx = 1;
        panel.add(inputField, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JLabel("Result:"), c);

        c.gridx = 1;
        panel.add(resultField, c);

        c.gridx = 1;
        c.gridy = 2;
        panel.add(evaluateButton, c);

        frame.add(panel);
        frame.setVisible(true);
    }
}
