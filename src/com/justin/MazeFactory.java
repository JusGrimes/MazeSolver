package com.justin;


import java.util.Random;

class MazeFactory {
    public static Maze createMaze(String mazeType,int rows, int cols, double density){
        Maze retMaze = null;
        switch (mazeType) {
            case "open":
                retMaze = openMaze(rows, cols);
                break;

            case "closed":
                retMaze = closedMaze(rows, cols);
                break;

            case "middle":
                retMaze = middleStartGoal(rows, cols, density);
                break;

            case "standard":
                retMaze = standardMaze(rows, cols, density);
                break;

        }

        if (retMaze == null) {
            throw new IllegalArgumentException("Invalid maze type");
        }
        return retMaze;
    }

    private static Maze openMaze(int rows, int cols){

        Location start = new Location(0, 0);
        Location goal = new Location(rows - 1, cols - 1);
        return new Maze(rows, cols, start, goal, 0);
    }

    private static Maze closedMaze(int rows, int cols) {
        Location start = new Location(0, 0);
        Location goal = new Location(rows - 1, cols - 1);

        return new Maze(rows, cols, start, goal, 1);
    }

    private static Maze standardMaze(int rows, int cols, double density) {
        Random rand = new Random();

        Location start = new Location(0, rand.nextInt(cols));
        Location goal = new Location(rows - 1, rand.nextInt(cols));

        return new Maze(rows, cols, start, goal, density);
    }

    private static Maze middleStartGoal(int rows, int cols, double density) {
        Random rand = new Random();

        Location start = new Location(0, cols / 2);
        Location goal = new Location(rows - 1, cols / 2);

        return new Maze(rows, cols, start, goal, density);
    }
}
