package animate;

import javax.swing.JFrame;

public class Application {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        frame.add(new Board());
        frame.setVisible(true);
    }
}
