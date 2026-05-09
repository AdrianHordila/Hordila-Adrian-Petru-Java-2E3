import java.util.*;

public class GameMap {
    private final int size;
    private final int[][] cells;
    private final Map<String, int[]> positions = new HashMap<>();
    private boolean running = true;
    private final int exitX, exitY;

    public GameMap(int size) {
        this.size = size;
        this.cells = new int[size][size]; 
        this.exitX = size - 1;
        this.exitY = size - 1;
    }

    public synchronized boolean move(String name, int newX, int newY) {
        if (newX < 0 || newX >= size || newY < 0 || newY >= size) return false;
        
        for (Map.Entry<String, int[]> entry : positions.entrySet()) {
            if (!entry.getKey().equals(name)) {
                if (entry.getValue()[0] == newX && entry.getValue()[1] == newY) {
                    if (name.startsWith("Robot") && entry.getKey().equals("Bunny")) {
                        System.out.println("Robot " + name + " caught the Bunny!");
                        running = false;
                    }
                    return false;
                }
            }
        }

        positions.put(name, new int[]{newX, newY});
        
        if (name.equals("Bunny") && newX == exitX && newY == exitY) {
            System.out.println("Bunny reached the exit!");
            running = false;
        }
        
        return true;
    }

    public synchronized boolean isRunning() {
        return running;
    }

    public void display() {
        synchronized (this) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    String symbol = ". ";
                    for (Map.Entry<String, int[]> e : positions.entrySet()) {
                        if (e.getValue()[0] == i && e.getValue()[1] == j) {
                            symbol = e.getKey().equals("Bunny") ? "B " : "R ";
                        }
                    }
                    if (i == exitX && j == exitY && symbol.equals(". ")) symbol = "E ";
                    System.out.print(symbol);
                }
                System.out.println();
            }
            System.out.println("---------------");
        }
    }
}