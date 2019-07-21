package com.justin;

public class Node {

    private Node parent;
    private State state;
    private double cost;
    private double heuristic;

    public Node(Node parent, State state, double cost, double heuristic) {
        this.parent = parent;
        this.state = state;
        this.cost = cost;
        this.heuristic = heuristic;
    }

    public State getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }
}
