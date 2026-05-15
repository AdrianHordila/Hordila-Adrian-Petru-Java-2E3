public class Cell {
    private final int r, c;
    private boolean occupied = false;
    private boolean isExit = false;

    public Cell(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public synchronized boolean occupy() {
        if (occupied) return false;
        occupied = true;
        return true;
    }

    public synchronized void release() {
        occupied = false;
    }

    public void setExit(boolean exit) {
        isExit = exit;
    }

    public boolean isExit() {
        return isExit;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}