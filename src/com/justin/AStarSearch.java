package com.justin;

import java.util.PriorityQueue;

import static java.lang.Math.*;

public class AStarSearch implements Algorithm {

    private PriorityQueue<Node> storageHeap = new PriorityQueue<>();

    @Override
    public void addNewNode(Node parent, Location location, double cost, Location goal) {
        storageHeap.add(new Node(parent, location, cost, heuristic(location,goal)));
    }

    private double heuristic(Location start,Location end) {
        return manhattanDistance(start, end);
    }

    private double manhattanDistance(Location start, Location end) {
        double rowDist = abs(start.getRow() - end.getRow());
        double colDist = abs(start.getCol() - end.getCol());
        return rowDist + colDist;
    }

    private double euclideanDistance(Location start, Location end){
        double rowDist = start.getRow() - end.getRow();
        double colDist = start.getCol() - end.getCol();
        return sqrt(pow(rowDist, 2) + pow(colDist, 2));
    }

    @Override
    public Node poll() {
        return storageHeap.poll();
    }

    @Override
    public boolean isEmpty() {
        return storageHeap.isEmpty();
    }
}
