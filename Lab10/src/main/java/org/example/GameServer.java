import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private final ExecutorService pool = Executors.newFixedThreadPool(10);
    private volatile boolean running = true;
    private final GameManager gameManager = new GameManager();

    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            while (running) {
                try {
                    Socket socket = serverSocket.accept();
                    pool.execute(new ClientThread(socket, this));
                } catch (SocketException e) {
                    if (!running) break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    public void stop() {
        running = false;
        try {
            pool.shutdown();
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.start();
    }
}