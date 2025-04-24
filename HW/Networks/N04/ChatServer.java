import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java ChatServer <port number>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(clientSocket);
                clients.add(handler);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }

    public static void broadcast(String message, ClientHandler sender) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(message);
                }
            }
        }
    }

    public static void removeClient(ClientHandler client) {
        clients.remove(client);
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String name;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Enter your name:");
            name = in.readLine();
            System.out.println(name + " connected.");
            ChatServer.broadcast(name + " has joined the chat!", this);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(name + ": " + message);
                ChatServer.broadcast(name + ": " + message, this);
            }
        } catch (IOException e) {
            System.err.println("Connection with " + name + " lost. :(");
        } finally {
            try {
                ChatServer.broadcast(name + " has left the chat.", this);
                ChatServer.removeClient(this);
                if (socket != null)
                    socket.close();
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
            } catch (IOException e) {
                System.err.println("Error closing resources for " + name);
            }
        }
    }
}
