package com.justin;

import java.util.Random;

public class Maze {

    private State[][] grid;

    Maze(int rows, int cols, int startRow, int startCol, int goalRow, int goalCol, double density) {
        final Random rand = new Random();
        grid = new State[rows][cols];
        if (outsideGrid(rows, cols, startRow, startCol, goalRow, goalCol)) {
            throw new IllegalArgumentException("Goal or Start are outside of grid");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                State newState;

                if (i == startRow && j == startCol) {
                    newState = State.START;
                } else if (i == goalRow & j == goalCol) {
                    newState = State.GOAL;
                } else {
                    newState = rand.nextDouble() > density ? State.OPEN : State.BLOCKED;
                }
                grid[i][j] = newState;
            }
        }
    }

    private boolean outsideGrid(int row, int col, int startRow, int startCol, int goalRow, int goalCol) {
        // determines if row,col are outside the grid
        return startRow < 0 || startCol < 0 || goalRow < 0 || goalCol < 0
        ||  startRow >= row || startCol >= col || goalRow >= row || goalCol > col;
    }

    public State getLocationState(int row, int col) {
        return grid[row][col];
    }


    @Override
    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            for (State[] row : grid) {
                for (int col = 0; col < grid[0].length; col++) {
                    sb.append(row[col].getGlyph());
                }
                sb.append('\n');
            }
            return sb.toString();
        } catch (NullPointerException e) {
            return "Array is Empty";
        }
    }
}
