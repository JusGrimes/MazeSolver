package com.justin;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    private List<Location> neighbors(Location loc) {
        Location down = new Location(loc.getRow() + 1, loc.getCol());
        Location left = new Location(loc.getRow(), loc.getCol() - 1);
        Location right = new Location(loc.getRow(), loc.getCol() + 1);
        Location up = new Location(loc.getRow() - 1, loc.getCol());

        return Stream.of(up,left,right,down)
                .filter(location -> !outOfBounds(location))
                .filter(location -> maze.getLocationState(location) != State.BLOCKED)
                .collect(Collectors.toList());
    }


    void solveDFSorBFS(String solveAlgo){
        boolean solveDFS = solveAlgo.equals("DFS");
        Deque<Node> frontier = new ArrayDeque<>();
        Set<Location> explored = new HashSet<>();
        Location currentLocation = maze.getStart();
        Node goal = null;
        frontier.push(new Node(null, currentLocation, 0, 0));

        // push start location
        explored.add(currentLocation);

        while (!frontier.isEmpty()) {
            Node curNode;
            if (solveDFS) {
                curNode = frontier.pollLast();
            } else {
                curNode = frontier.poll();
            }
            if (curNode != null) {
                currentLocation = curNode.getLocation();
            }
            State curLocState = maze.getLocationState(currentLocation);

            if (curLocState == State.GOAL) {
                goal = curNode;
                break;
            }

            for (Location newNeighborLoc :
                    neighbors(currentLocation)) {
                if (explored.contains(newNeighborLoc)) {
                    continue;
                }
                explored.add(newNeighborLoc);
                Node newNode = new Node(curNode, newNeighborLoc, 0, 0);
                if (solveDFS) {
                    frontier.push(newNode);
                } else {
                    frontier.addFirst(newNode);
                }
            }
        }

        if (goal == null){
            System.out.println("UNSOLVABLE!");
        }
        drawPath(goal);
    }

}
