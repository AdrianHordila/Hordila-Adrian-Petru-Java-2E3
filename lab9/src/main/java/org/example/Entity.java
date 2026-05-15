public abstract class Entity implements Runnable {
    protected String id;
    protected int r, c;
    protected Maze maze;
    protected volatile long speed = 1000;
    protected volatile boolean running = true;
    protected volatile boolean paused = false;

    public Entity(String id, int r, int c, Maze maze) {
        this.id = id;
        this.r = r;
        this.c = c;
        this.maze = maze;
        maze.getCell(r, c).occupy();
    }

    public void setSpeed(long speed) { this.speed = speed; }
    public void pause() { paused = true; }
    public synchronized void resumeEntity() {
        paused = false;
        notify();
    }
    public void stop() { running = false; }

    protected synchronized void checkPause() throws InterruptedException {
        while (paused) wait();
    }

    protected boolean moveTo(int nextR, int nextC) {
        Cell next = maze.getCell(nextR, nextC);
        if (next.occupy()) {
            maze.getCell(r, c).release();
            this.r = nextR;
            this.c = nextC;
            return true;
        }
        return false;
    }

    public String getId() { return id; }
    public int getR() { return r; }
    public int getC() { return c; }
}