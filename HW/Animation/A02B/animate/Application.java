package animate;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Application extends JFrame {
    private final int FRAME_WIDTH = 640;
    private final int FRAME_HEIGHT = 480;

    /*
     * Constructor.
     */
    public Application(String title) {
        // the values for border width and title bar height
        // depend on the operating system.
        int border_width = 0;
        int bar_height = 0;
        OS os = checkOS();
        switch (os) {
            case WIN -> {
                border_width = 7;
                bar_height = 30;
            }
            case MAC -> {
                border_width = 0;
                bar_height = 28;
            }
            case LINUX -> {
            }
            case OTHER -> {
            }
        }
        // I don't know what the values are for Linux.

        Board board = new Board();
        this.add(board);

        // int application_width = FRAME_WIDTH + 2 * border_width;
        // int application_height = FRAME_HEIGHT + bar_height + border_width;
        this.setTitle(title);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // set the size based on the board size
        // and also account for the border width and the bar height.
        int application_height = (int) board.getPreferredSize().getHeight() + bar_height + border_width;
        int application_width = (int) board.getPreferredSize().getWidth() + 2 * border_width;
        this.setSize(application_width, application_height);

    }

    public static enum OS {
        WIN, MAC, LINUX, OTHER
    }

    public static OS checkOS() {
        OS val;
        String name = System.getProperty("os.name").toLowerCase();
        if (name.indexOf("win") >= 0) {
            val = OS.WIN;
        } else if (name.indexOf("mac") >= 0) {
            val = OS.MAC;
        } else if (name.indexOf("nux") >= 0) {
            val = OS.LINUX;
        } else {
            val = OS.OTHER;
        }
        return val;
    }

    public static void main(String[] args) {
        // Application a = new Application("Winter 2025 demo");
        // a.setVisible(true);
        EventQueue.invokeLater(() -> {
            Application a = new Application("Title");
            a.setVisible(true);
        });

    }
}