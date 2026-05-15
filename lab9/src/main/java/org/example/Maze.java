import java.util.*;

public class Maze {
    private final int rows, cols;
    private final Cell[][] grid;
    private final Cell exitCell;
    private volatile boolean gameOver = false;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
        exitCell = grid[rows - 1][cols - 1];
        exitCell.setExit(true);
    }

    public Cell getCell(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) return null;
        return grid[r][c];
    }

    public List<Cell> getNeighbors(int r, int c) {
        List<Cell> neighbors = new ArrayList<>();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            Cell n = getCell(r + dr[i], c + dc[i]);
            if (n != null) neighbors.add(n);
        }
        return neighbors;
    }

    public boolean isFinished() { return gameOver; }
    public void setFinished() { gameOver = true; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }
}