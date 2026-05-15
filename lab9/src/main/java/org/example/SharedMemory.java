import java.util.concurrent.ConcurrentHashMap;

public class SharedMemory {
    private final boolean[][] visited;
    private volatile int bunnyR = -1;
    private volatile int bunnyC = -1;

    public SharedMemory(int rows, int cols) {
        this.visited = new boolean[rows][cols];
    }

    public synchronized void markVisited(int r, int c) {
        visited[r][c] = true;
    }

    public synchronized boolean isVisited(int r, int c) {
        return visited[r][c];
    }

    public void updateBunnyPos(int r, int c) {
        this.bunnyR = r;
        this.bunnyC = c;
    }

    public int getBunnyR() { return bunnyR; }
    public int getBunnyC() { return bunnyC; }
}