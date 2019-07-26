package com.justin;

import java.util.ArrayDeque;
import java.util.Deque;

public class DepthFirstSearch implements Algorithm {

    private Deque<Node> storage = new ArrayDeque<>();

    @Override
    public void addNewNode(Node parent, Location location, double cost, Location goal) {
        storage.addLast(new Node(parent, location, 0,0));
    }

    @Override
    public Node poll() {
        return storage.pollLast();
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }
}
