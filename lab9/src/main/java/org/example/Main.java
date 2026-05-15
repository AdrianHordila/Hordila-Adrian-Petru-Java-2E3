import java.util.*;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze(10, 10);
        SharedMemory memory = new SharedMemory(10, 10);
        List<Entity> entities = new ArrayList<>();

        Bunny bunny = new Bunny(0, 0, maze);
        entities.add(bunny);

        for (int i = 1; i <= 3; i++) {
            entities.add(new Robot("robot" + i, 9, 9 - i, maze, memory));
        }

        List<Thread> threads = new ArrayList<>();
        for (Entity e : entities) {
            Thread t = new Thread(e);
            threads.add(t);
            t.start();
        }

        new DaemonManager(maze, entities).start();

        Scanner scanner = new Scanner(System.in);
        while (!maze.isFinished()) {
            String cmd = scanner.nextLine();
            String[] parts = cmd.split(" ");

            if (parts.length < 1) continue;
            String action = parts[0];
            String target = parts.length > 1 ? parts[1] : "all";

            for (Entity e : entities) {
                if (target.equals("all") || e.getId().equals(target)) {
                    switch (action) {
                        case "slow": e.setSpeed(2000); break;
                        case "fast": e.setSpeed(200); break;
                        case "stop": e.pause(); break;
                        case "resume": e.resumeEntity(); break;
                    }
                }
            }

            if (action.equals("exit")) {
                maze.setFinished();
                break;
            }
        }

        for (Entity e : entities) e.stop();
        System.out.println("Application terminated.");
    }
}