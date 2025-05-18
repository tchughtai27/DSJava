package calculator;

public class Stack {
    private double[] data;
    private int top;

    public Stack(int capacity) {
        data = new double[capacity];
        top = -1;
    }

    public void push(double value) {
        if (top == data.length - 1)
            return;
        data[++top] = value;
    }

    public double pop() {
        if (isEmpty())
            return 0;
        return data[top--];
    }

    public double peek() {
        if (isEmpty())
            return 0;
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void clear() {
        top = -1;
    }
}
