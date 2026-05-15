import java.util.*;

public class Robot extends Entity {
    private final SharedMemory memory;
    private final Stack<Cell> path = new Stack<>();

    public Robot(String id, int r, int c, Maze maze, SharedMemory memory) {
        super(id, r, c, maze);
        this.memory = memory;
        memory.markVisited(r, c);
    }

    @Override
    public void run() {
        try {
            while (running && !maze.isFinished()) {
                checkPause();
                Thread.sleep(speed);

                if (Math.abs(r - memory.getBunnyR()) <= 1 && Math.abs(c - memory.getBunnyC()) <= 1) {
                    if (r == memory.getBunnyR() && c == memory.getBunnyC()) {
                        System.out.println("\n[GAME] " + id + " caught the bunny!");
                        maze.setFinished();
                        break;
                    }
                }

                List<Cell> neighbors = maze.getNeighbors(r, c);
                boolean moved = false;
                for (Cell n : neighbors) {
                    if (!memory.isVisited(n.getR(), n.getC())) {
                        if (moveTo(n.getR(), n.getC())) {
                            memory.markVisited(r, c);
                            path.push(maze.getCell(r, c));
                            moved = true;
                            break;
                        }
                    }
                }

                if (!moved && !path.isEmpty()) {
                    Cell back = path.pop();
                    moveTo(back.getR(), back.getC());
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}