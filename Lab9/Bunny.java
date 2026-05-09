import java.util.Random;

public class Bunny extends Thread {
    private int x, y;
    private final GameMap map;
    private final Random random = new Random();

    public Bunny(int x, int y, GameMap map) {
        this.x = x;
        this.y = y;
        this.map = map;
        map.move("Bunny", x, y);
    }

    @Override
    public void run() {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (map.isRunning()) {
            int dir = random.nextInt(4);
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (map.move("Bunny", nx, ny)) {
                x = nx;
                y = ny;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}