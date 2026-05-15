import java.io.*;

public class ServerListener implements Runnable {
    private BufferedReader in;

    public ServerListener(BufferedReader in) {
        this.in = in;
    }

    public void run() {
        try {
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("\n[SERVER]: " + response);
            }
        } catch (IOException e) {
            System.out.println("Disconnected from server.");
        }
    }
}