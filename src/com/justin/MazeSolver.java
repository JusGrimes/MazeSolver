package com.justin;

import java.util.Stack;

class MazeSolver {
    private Maze maze;
    final private int rowSize;
    final private int colSize;
    private Stack<Node> solvedPath;
    private boolean solved = false;

    MazeSolver(Maze maze) {
        this.maze = maze;
        rowSize = maze.getRowSize();
        colSize = maze.getColSize();

    }

    Maze getMaze(){
        return maze;
    }

    private boolean outOfBounds(int row, int col) {
        return row < 0 || col < 0 || row >= rowSize || col >= colSize;
    }

    private void drawPath() {
        for (Node curNode : solvedPath) {
            Location loc = curNode.getLocation();
            State locState = maze.getLocationState(loc);
            if (locState!= State.GOAL && locState != State.START) {
                maze.setLocationState(loc,State.PATH);
            }
        }
    }

    void solveDFS(){
        Location start = maze.getStart();
        Stack<Node> path = new Stack<>();
        Stack<Location> visited = new Stack<>();
        DFS(maze.getStart(),path,visited);
        if (maze.getLocationState(path.peek().getLocation()) == State.GOAL){
            solved = true;
            solvedPath = path;
            drawPath();
        }
    }

    private void DFS(Location loc, Stack<Node> path, Stack<Location> visited){

        if (outOfBounds(loc.getRow(),loc.getCol())) return;
        if (maze.getLocationState(loc) == State.BLOCKED) return;
        if (visited.contains(loc)) return;
        Node parent = null;

        if (!path.isEmpty()){
            Location parentLocation = path.peek().getLocation();
            if (maze.getLocationState(parentLocation) == State.GOAL) return;
            parent = path.peek();
        }
        path.push(new Node(parent, loc, 0, 0));
        visited.push(loc);

        DFS(new Location(loc.getRow(), loc.getCol() - 1), path, visited);
        DFS(new Location(loc.getRow() + 1, loc.getCol()), path, visited);
        DFS(new Location(loc.getRow(), loc.getCol() + 1), path, visited);
        DFS(new Location(loc.getRow() - 1, loc.getCol()), path, visited);
    }
}
