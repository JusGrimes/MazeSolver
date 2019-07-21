package com.justin;

public class Node {

    private Node parent;
    private Location location;
    private double cost;
    private double heuristic;

    Node(Node parent, Location location, double cost, double heuristic) {
        this.parent = parent;
        this.location = location;
        this.cost = cost;
        this.heuristic = heuristic;
    }

    Location getLocation() {
        return location;
    }

    public Node getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Node{ Location{" +
                "row: " + location.getRow() +
                "col: " + location.getCol() +
                "}}";
    }
}
