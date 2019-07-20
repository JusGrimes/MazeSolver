package com.justin;

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
        for (int i = 0; i < colSize; i++) {
            if (maze.getLocationState(0,i) == State.START) {
                DFS(0,i-1);
                DFS(0,i+1);
                DFS(1,i);
                break;
            }
        }
    }

    private void DFS(int row, int col){

        if (outOfBounds(row,col)) return;

        State locationState = maze.getLocationState(row, col);

        if (locationState != State.OPEN) return;

        maze.setLocationState(row, col, State.PATH);

        DFS(row,col-1);
        DFS(row,col+1);
        DFS(row-1,col);
        DFS(row+1,col);

    }
}
