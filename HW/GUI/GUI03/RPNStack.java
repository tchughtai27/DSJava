public class RPNStack {
    private double[] data;
    private int top;

    public RPNStack(int capacity) {
        data = new double[capacity];
        top = 0;
    }

    public void push(double value) {
        if (top < data.length) {
            data[top++] = value;
        }
    }

    public double pop() {
        if (top > 0) {
            return data[--top];
        }
        return 0;
    }

    public void clear() {
        top = 0;
    }

    public int size() {
        return top;
    }
}
