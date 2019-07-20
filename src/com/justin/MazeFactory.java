package com.justin;

import org.jetbrains.annotations.Contract;

public class MazeFactory {
    private MazeFactory() {

    }

    static public Maze openMaze(int rows, int cols){
        return new Maze(rows, cols, 0, 0, rows - 1, cols - 1, 0);
    }

    static public Maze closedMaze(int rows, int cols) {
        return new Maze(rows, cols, 0, 0, rows - 1, cols - 1, 1);
    }

    static public Maze standardMaze(int rows, int cols, double density) {
        return new Maze(rows, cols, 0, 0, rows - 1, cols - 1, density);
    }
}
