import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Board extends JPanel {

    private final int B_WIDTH = 320;
    private final int B_HEIGHT = 240;

    private JTextField interestRateField;
    private JLabel balanceLabel;
    private double balance = 1000.0;

    public Board() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setLayout(null); // Use absolute layout for precise placement

        // Set border and title
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Display Interest", TitledBorder.CENTER, TitledBorder.TOP));

        // Interest rate label
        JLabel interestRateLabel = new JLabel("Interest Rate (%):");
        interestRateLabel.setBounds(20, 40, 120, 25);
        add(interestRateLabel);

        // Text field for entering interest rate
        interestRateField = new JTextField("5.00");
        interestRateField.setBounds(150, 40, 100, 25);
        add(interestRateField);

        // Button to add interest
        JButton addInterestButton = new JButton("Add Interest");
        addInterestButton.setBounds(90, 80, 140, 30);
        add(addInterestButton);

        // Label to display balance
        balanceLabel = new JLabel("Balance ($): " + formatBalance(balance));
        balanceLabel.setBounds(90, 130, 200, 25);
        add(balanceLabel);

        // Action for button
        addInterestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double rate = Double.parseDouble(interestRateField.getText());
                    balance += balance * (rate / 100.0);
                    balanceLabel.setText("Balance ($): " + formatBalance(balance));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Board.this,
                            "Please enter a valid number for the interest rate.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private String formatBalance(double amount) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(amount);
    }
}
