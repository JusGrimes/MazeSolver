package com.justin;

import javax.imageio.spi.ImageInputStreamSpi;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Maze {

    private Location start;
    private Location goal;
    private State[][] grid;

    Maze(int rows, int cols, Location start, Location goal, double density) {
        final Random rand = new Random();
        grid = new State[rows][cols];
        if (outsideGrid(rows, cols, start.getRow(), start.getCol(), goal.getRow(), goal.getCol())) {
            throw new IllegalArgumentException("Goal or Start are outside of grid");
        }
        if (rows <= 0 || cols <= 0){
            throw new IllegalArgumentException("Row and Col must be greater than 0");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = rand.nextDouble() > density ? State.OPEN : State.BLOCKED;
            }
        }
        grid[start.getRow()][start.getCol()] = State.START;
        grid[goal.getRow()][goal.getCol()] = State.GOAL;
        this.start = start;
        this.goal = goal;
    }

    private Maze(State[][] grid, Location start, Location goal){
        if (grid == null) throw new IllegalArgumentException();
        this.grid = grid;
        this.start = start;
        this.goal = goal;
    }

    Maze copy(){
        State[][] retGrid = new State[grid.length][];
        for (int i = 0; i < grid.length; i++) {

            retGrid[i] = Arrays.copyOf(grid[i],grid[i].length);
        }

        return new Maze(retGrid,start, goal);
    }

    private boolean outsideGrid(int rows, int cols, int startRow, int startCol, int goalRow, int goalCol) {
        // determines if row,col are outside the grid
        return startRow < 0 || startCol < 0 || goalRow < 0 || goalCol < 0
        ||  startRow >= rows || startCol >= cols || goalRow >= rows || goalCol > cols;
    }

    State getLocationState(Location loc) {
        return grid[loc.getRow()][loc.getCol()];
    }

    int getRowSize() {
        return grid.length;
    }

    int getColSize() {
        return grid[0].length;
    }


    @Override
    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            IntStream.range(0,grid[0].length +2).forEach(a->sb.append('-'));
            sb.append("\n");
            for (State[] row : grid) {
                sb.append("|");
                for (int col = 0; col < grid[0].length; col++) {
                    sb.append(row[col].getGlyph());
                }
                sb.append("|");
                sb.append('\n');
            }
            IntStream.range(0, grid[0].length + 2).forEach(a -> sb.append('-'));
            sb.append("\n");
            return sb.toString();
        } catch (NullPointerException e) {
            return "Array is Empty";
        }
    }

    void setLocationState(Location loc, State newState) {
        grid[loc.getRow()][loc.getCol()] = newState;
    }

    Location getStart() {
        return start;
    }

    public Location getGoal() {
        return goal;
    }

    public Location getStart() {
        return start;
    }

    public Location getGoal() {
        return goal;
    }
}
