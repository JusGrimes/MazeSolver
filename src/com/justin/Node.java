package com.justin;

public class Node implements Comparable<Node>{

    private Node parent;
    private Location location;

    public double getCost() {
        return cost;
    }

    public double getHeuristic() {
        return heuristic;
    }

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

    @Override
    public int compareTo(Node o) {
        return (int) ((this.cost + this.heuristic) - (o.cost + o.heuristic));
    }
}
