import java.io.*;
import java.net.*;
import java.util.Scanner;

public class GameClient {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 8100;

    public void start() {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            Thread listenerThread = new Thread(new ServerListener(in));
            listenerThread.start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String command = scanner.nextLine();
                out.println(command);
                if (command.equalsIgnoreCase("exit")) break;
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new GameClient().start();
    }
}