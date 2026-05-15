import java.util.List;

public class DaemonManager extends Thread {
    private final Maze maze;
    private final List<Entity> entities;
    private final long startTime;
    private final long timeLimit = 60000;

    public DaemonManager(Maze maze, List<Entity> entities) {
        this.maze = maze;
        this.entities = entities;
        this.startTime = System.currentTimeMillis();
        setDaemon(true);
    }

    @Override
    public void run() {
        while (!maze.isFinished()) {
            long elapsed = System.currentTimeMillis() - startTime;
            if (elapsed > timeLimit) {
                System.out.println("\n[TIME OUT] Game stopped.");
                maze.setFinished();
                break;
            }

            System.out.print("\rTime: " + (elapsed / 1000) + "s | Positions: ");
            for (Entity e : entities) {
                System.out.print(e.getId() + "(" + e.getR() + "," + e.getC() + ") ");
            }

            try { Thread.sleep(2000); } catch (InterruptedException e) { break; }
        }
    }
}