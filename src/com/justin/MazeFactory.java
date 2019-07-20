package com.justin;

import org.jetbrains.annotations.Contract;

import java.util.Random;

class MazeFactory {
    private MazeFactory() {

    }

    static Maze openMaze(int rows, int cols){
        return new Maze(rows, cols, 0, 0, rows - 1, cols - 1, 0);
    }

    static Maze closedMaze(int rows, int cols) {
        return new Maze(rows, cols, 0, 0, rows - 1, cols - 1, 1);
    }

    static Maze standardMaze(int rows, int cols, double density) {
        Random rand = new Random();

        return new Maze(rows, cols, 0, rand.nextInt(cols), rows - 1, rand.nextInt(cols), density);
    }

    static Maze MiddleStartGoal(int rows, int cols, double density) {
        Random rand = new Random();

        return new Maze(rows, cols, 0, cols/2, rows - 1, cols/2, density);
    }
}
