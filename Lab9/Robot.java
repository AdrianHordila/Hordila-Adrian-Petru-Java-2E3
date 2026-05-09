import java.util.Random;

public class Robot extends Thread {
    private final String name;
    private int x, y;
    private final GameMap map;
    private final Random random = new Random();

    public Robot(String name, int x, int y, GameMap map) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.map = map;
        map.move(name, x, y);
    }

    @Override
    public void run() {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (map.isRunning()) {
            int dir = random.nextInt(4);
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (map.move(name, nx, ny)) {
                x = nx;
                y = ny;
            }

            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}