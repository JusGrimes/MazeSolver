package com.justin;

public class Node {

    private Node parent;
    private State state;
    private boolean visited;

    public Node(Node parent, State state) {
        this.parent = parent;
        this.state = state;
    }

    public boolean isVisited() {
        return visited;
    }

    public State getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }
}
