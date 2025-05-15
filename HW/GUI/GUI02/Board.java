import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class Board extends JPanel {

    private final int B_WIDTH = 320;
    private final int B_HEIGHT = 240;
    private JTextField interestRateField;
    private JTextArea balanceHistoryArea;
    private double balance = 1000.0;
    private DecimalFormat df = new DecimalFormat("#.00");

    public Board() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setLayout(null);

        // Label for interest rate
        JLabel interestRateLabel = new JLabel("Interest Rate (%):");
        interestRateLabel.setBounds(20, 20, 120, 25);
        add(interestRateLabel);

        // TextField for inputting interest rate
        interestRateField = new JTextField("5.00");
        interestRateField.setBounds(150, 20, 100, 25);
        add(interestRateField);

        // Button to apply interest rate
        JButton addInterestButton = new JButton("Add Interest");
        addInterestButton.setBounds(90, 60, 140, 30);
        add(addInterestButton);

        // Label to display the updated balance
        JLabel balanceLabel = new JLabel("Balance ($): " + formatBalance(balance));
        balanceLabel.setBounds(90, 100, 200, 25);
        add(balanceLabel);

        // Scrollable text area for balance history
        balanceHistoryArea = new JTextArea(10, 30);
        balanceHistoryArea.setEditable(false); // Making it non-editable
        JScrollPane scrollPane = new JScrollPane(balanceHistoryArea);
        scrollPane.setBounds(20, 140, 280, 80);
        add(scrollPane);

        // Add initial balance to history
        balanceHistoryArea.append("Initial Balance: $1000.00\n");

        // Action listener for the "Add Interest" button
        addInterestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double rate = Double.parseDouble(interestRateField.getText());
                    balance += balance * (rate / 100.0);
                    balanceLabel.setText("Balance ($): " + formatBalance(balance));
                    balanceHistoryArea.append("Added " + rate + "% interest: " + formatBalance(balance) + "\n");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Board.this,
                            "Please enter a valid number for the interest rate.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Helper method to format balance to two decimal places
    private String formatBalance(double amount) {
        return df.format(amount);
    }
}
