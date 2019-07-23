package com.justin;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
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

    private boolean outOfBounds(Location loc) {
        return loc.getRow() < 0 || loc.getCol() < 0 || loc.getRow() >= rowSize || loc.getCol() >= colSize;
    }

    private void drawPath(Node goalPath) {

        Node curNode = goalPath;

        while (curNode != null) {
            State curState = maze.getLocationState(curNode.getLocation());

            if (curState != State.GOAL && curState != State.START) {
                maze.setLocationState(curNode.getLocation(), State.PATH);
            }

            curNode = curNode.getParent();
        }
    }

    void solveDFS(){
        Location startLocation = maze.getStart();
        Set<Location> visited = new HashSet<>();
        Node goal = DFS(null, startLocation, visited);
        if (goal == null){
            System.out.println("UNSOLVABLE!");
        }
        drawPath(goal);
    }

    private Node DFS(Node parent, Location loc, Set<Location> visited) {
        if (outOfBounds(loc) || visited.contains(loc)){
            return null;
        }

        State currentLocState = maze.getLocationState(loc);
//        State parentState = null;
//
//        if (parent != null){
//            parentState = maze.getLocationState(parent.getLocation());
//        }

        if (currentLocState == State.BLOCKED) return null;
        if (currentLocState == State.GOAL) return new Node(parent,loc,0,0);

        visited.add(loc);

        Location down = new Location(loc.getRow() + 1, loc.getCol());
        Location left = new Location(loc.getRow(), loc.getCol() - 1);
        Location right = new Location(loc.getRow(), loc.getCol() + 1);
        Location up = new Location(loc.getRow() - 1, loc.getCol());

        Node curNode = new Node(parent,loc,0,0);
        Node goalNode = null;

        Location[] locArr = new Location[] {down,left,right,up};

        for (int i = 0; i < locArr.length && goalNode == null; i++) {
            goalNode = DFS(curNode, locArr[i], visited);
        }
        return goalNode;
    }
}
