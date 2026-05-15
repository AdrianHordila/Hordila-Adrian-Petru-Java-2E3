import java.io.PrintWriter;

public class Player {
    String name;
    int score = 0;
    long totalTime = 0;
    PrintWriter out;

    public Player(String name, PrintWriter out) {
        this.name = name;
        this.out = out;
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }
}