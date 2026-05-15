import java.io.*;
import java.util.*;

public class GameManager {
    private List<Question> questions = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private int currentQuestionIndex = -1;
    private long questionStartTime;
    private boolean gameInProgress = false;

    public GameManager() {
        loadQuestions();
    }

    private void loadQuestions() {
        try (BufferedReader br = new BufferedReader(new FileReader("questions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                questions.add(new Question(line));
            }
        } catch (IOException e) {
            System.err.println("Error loading questions: " + e.getMessage());
        }
    }

    public synchronized void addPlayer(Player p) {
        players.add(p);
    }

    public void startGame() {
        if (gameInProgress) return;
        gameInProgress = true;
        for (int i = 0; i < questions.size(); i++) {
            currentQuestionIndex = i;
            broadcast("QUESTION: " + questions.get(i).toString());
            questionStartTime = System.currentTimeMillis();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                break;
            }
        }
        determineWinner();
    }

    public synchronized void handleAnswer(Player p, String ans) {
        long responseTime = System.currentTimeMillis() - questionStartTime;
        if (responseTime <= 10000 && currentQuestionIndex >= 0) {
            try {
                int answerIdx = Integer.parseInt(ans);
                if (answerIdx == questions.get(currentQuestionIndex).correctIndex) {
                    p.score++;
                    p.totalTime += responseTime;
                }
            } catch (NumberFormatException e) {}
        }
    }

    private void broadcast(String msg) {
        for (Player p : players) p.sendMessage(msg);
    }

    private void determineWinner() {
        players.sort((p1, p2) -> {
            if (p2.score != p1.score) return p2.score - p1.score;
            return Long.compare(p1.totalTime, p2.totalTime);
        });

        StringBuilder sb = new StringBuilder("FINAL RESULTS: ");
        for (Player p : players) {
            sb.append(p.name).append(" (").append(p.score).append(" pts, ").append(p.totalTime).append("ms) ");
        }
        broadcast(sb.toString());
        if (!players.isEmpty()) broadcast("WINNER: " + players.get(0).name);
        gameInProgress = false;
    }
}