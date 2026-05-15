import java.io.*;
import java.net.*;

public class ClientThread implements Runnable {
    private Socket socket;
    private GameServer server;
    private PrintWriter out;
    private BufferedReader in;
    private Player player;

    public ClientThread(Socket socket, GameServer server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                if (request.equalsIgnoreCase("stop")) {
                    out.println("Server stopped");
                    server.stop();
                    break;
                }
                if (request.equalsIgnoreCase("exit")) {
                    break;
                }

                String response = processRequest(request);
                out.println(response);
            }
        } catch (IOException e) {
        } finally {
            try {
                socket.close();
            } catch (IOException e) {}
        }
    }

    private String processRequest(String request) {
        String[] parts = request.split(" ");
        String cmd = parts[0].toLowerCase();

        switch (cmd) {
            case "join":
                if (parts.length > 1) {
                    this.player = new Player(parts[1], out);
                    server.getGameManager().addPlayer(player);
                    return "Server received the request: Player " + parts[1] + " joined";
                }
                return "Usage: join <name>";
            case "submit":
                if (player != null && parts.length > 1) {
                    server.getGameManager().handleAnswer(player, parts[1]);
                    return "Server received the request: Answer submitted";
                }
                return "Join first or provide answer index";
            case "start":
                new Thread(() -> server.getGameManager().startGame()).start();
                return "Server received the request: Game starting";
            default:
                return "Server received the request: " + request;
        }
    }
}