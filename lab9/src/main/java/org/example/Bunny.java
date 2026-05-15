import java.util.*;

public class Bunny extends Entity {
    public Bunny(int r, int c, Maze maze) {
        super("bunny", r, c, maze);
    }

    @Override
    public void run() {
        try {
            while (running && !maze.isFinished()) {
                checkPause();
                Thread.sleep(speed);

                List<Cell> neighbors = maze.getNeighbors(r, c);
                Cell next = neighbors.get(new Random().nextInt(neighbors.size()));

                if (moveTo(next.getR(), next.getC())) {
                    if (next.isExit()) {
                        System.out.println("\n[GAME] Bunny escaped!");
                        maze.setFinished();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}