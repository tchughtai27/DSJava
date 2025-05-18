package calculator;

public class Calculator {
    private Stack stack;

    public Calculator() {
        stack = new Stack(100);
    }

    public double evaluate(String input) {
        stack.clear();
        String[] tokens = input.trim().split("\\s+");

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2)
                    return Double.NaN;
                double b = stack.pop();
                double a = stack.pop();
                stack.push(applyOperator(token, a, b));
            } else {
                return Double.NaN;
            }
        }

        if (stack.size() != 1)
            return Double.NaN;
        return stack.pop();
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return "+-*/".contains(token) && token.length() == 1;
    }

    private double applyOperator(String op, double a, double b) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return b != 0 ? a / b : Double.NaN;
            default:
                return Double.NaN;
        }
    }
}
