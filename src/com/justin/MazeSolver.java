package com.justin;

import java.util.Stack;

public class MazeSolver {
    private Maze maze;
    final private int rowSize;
    final private int colSize;

    public MazeSolver(Maze maze) {
        this.maze = maze;
        rowSize = maze.getRowSize();
        colSize = maze.getColSize();

    }

    public Maze getMaze(){
        return maze;
    }

    private boolean outOfBounds(int row, int col) {
        return row < 0 || col < 0 || row >= rowSize || col >= colSize;
    }

    public void solveDFS(){

    }

    private void DFS(Location loc, Stack<Node> path){

        if (outOfBounds(loc.getRow(),loc.getCol())) return;

        State locationState = maze.getLocationState(loc);

        if (locationState != State.OPEN) return;

        maze.setLocationState(loc, State.PATH);

        DFS(new Location(loc.getRow(),loc.getCol()-1));
        DFS(new Location(loc.getRow(),loc.getCol()+1));
        DFS(new Location(loc.getRow()-1,loc.getCol()));
        DFS(new Location(loc.getRow()+1,loc.getCol()));

    }
}
