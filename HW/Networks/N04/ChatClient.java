import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java ChatClient <server ip> <port number>");
            System.exit(1);
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        try (
                Socket socket = new Socket(host, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Connected to chat server at " + host + ":" + port);

            // Thread for reading server messages
            Thread readerThread = new Thread(() -> {
                try {
                    String fromServer;
                    while ((fromServer = in.readLine()) != null) {
                        System.out.println(fromServer);
                    }
                } catch (IOException e) {
                    System.err.println("Disconnected from server.");
                }
            });
            readerThread.start();

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
            }

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
