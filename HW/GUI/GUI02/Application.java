import java.awt.EventQueue;
import javax.swing.*;
import java.util.Scanner;

public class Application extends JFrame {

    public Application(String title) {
        this.setTitle(title);

        // Add the Board panel
        Board board = new Board();
        this.add(board);

        // Set window size and location
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application myApp = new Application("Interest Rate Calculator");
            myApp.setVisible(true);
        });
    }
}
