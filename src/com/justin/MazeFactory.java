package com.justin;

import org.jetbrains.annotations.Contract;

import java.util.Random;

class MazeFactory {
    private MazeFactory(){}

    static Maze openMaze(int rows, int cols){

        Location start = new Location(0, 0);
        Location goal = new Location(rows - 1, cols - 1);
        return new Maze(rows, cols, start, goal, 0);
    }

    static Maze closedMaze(int rows, int cols) {
        Location start = new Location(0, 0);
        Location goal = new Location(rows - 1, cols - 1);

        return new Maze(rows, cols, start, goal, 1);
    }

    static Maze standardMaze(int rows, int cols, double density) {
        Random rand = new Random();

        Location start = new Location(0, rand.nextInt(cols));
        Location goal = new Location(rows - 1, rand.nextInt(cols));

        return new Maze(rows, cols, start, goal, density);
    }

    static Maze middleStartGoal(int rows, int cols, double density) {
        Random rand = new Random();

        Location start = new Location(0, cols / 2);
        Location goal = new Location(rows - 1, cols / 2);

        return new Maze(rows, cols, start, goal, density);
    }
}
