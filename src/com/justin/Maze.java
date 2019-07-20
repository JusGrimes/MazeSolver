package com.justin;

import java.util.Random;

public class Maze {

    private State[][] grid;

    public Maze(int rows, int cols, int startRow, int startCol, int goalRow, int goalCol, double density) {
        final Random rand = new Random();
        grid = new State[rows][cols];
        if (startRow < 0 || startCol < 0 || goalRow < 0 || goalCol < 0
        ||  startRow >= rows || startCol >= cols || goalRow >= rows || goalCol > cols) {
            throw new IllegalArgumentException("Goal or Start are outside of grid");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                State newState;

                if (i == startRow && j == startRow) {
                    newState = State.START;
                } else if (i == goalRow & j == goalCol) {
                    newState = State.GOAL;
                } else {
                    newState = rand.nextDouble() < density ? State.OPEN : State.BLOCKED;
                }
                grid[i][j] = newState;
            }
        }
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
