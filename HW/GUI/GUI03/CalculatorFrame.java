import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorFrame extends JFrame {
    private JTextField display;
    private RPNStack stack;
    private String currentInput = "";

    public CalculatorFrame() {
        stack = new RPNStack(100);
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "+/-", "Enter", "+",
                "C", "CE"
        };

        for (String label : buttons) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.PLAIN, 20));
            btn.addActionListener(new ButtonHandler());
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);

        setTitle("RPN Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();

            if (cmd.matches("\\d")) {
                currentInput += cmd;
                display.setText(currentInput);
            } else if (cmd.equals("Enter")) {
                if (!currentInput.isEmpty()) {
                    stack.push(Double.parseDouble(currentInput));
                    currentInput = "";
                    display.setText("");
                }
            } else if (cmd.equals("C")) {
                stack.clear();
                currentInput = "";
                display.setText("");
            } else if (cmd.equals("CE")) {
                currentInput = "";
                display.setText("");
            } else if (cmd.equals("+/-")) {
                if (!currentInput.isEmpty()) {
                    if (currentInput.startsWith("-"))
                        currentInput = currentInput.substring(1);
                    else
                        currentInput = "-" + currentInput;
                    display.setText(currentInput);
                }
            } else if ("+-*/".contains(cmd)) {
                if (!currentInput.isEmpty()) {
                    stack.push(Double.parseDouble(currentInput));
                    currentInput = "";
                }
                if (stack.size() >= 2) {
                    double b = stack.pop();
                    double a = stack.pop();
                    double result = 0;

                    if (cmd.equals("+"))
                        result = a + b;
                    if (cmd.equals("-"))
                        result = a - b;
                    if (cmd.equals("*"))
                        result = a * b;
                    if (cmd.equals("/"))
                        result = b != 0 ? a / b : 0;

                    stack.push(result);
                    display.setText("" + result);
                }
            }
        }
    }
}
