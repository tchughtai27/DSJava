package animate;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Application extends JFrame {

    public Application(String title) {
        Board board = new Board();
        this.add(board);

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Set size to match board's preferred size
        int height = (int) board.getPreferredSize().getHeight() + 30; // bar height
        int width = (int) board.getPreferredSize().getWidth() + 14; // borders
        this.setSize(width, height);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application a = new Application("Projectile Motion Simulation - Part A");
            a.setVisible(true);
        });
    }
}
