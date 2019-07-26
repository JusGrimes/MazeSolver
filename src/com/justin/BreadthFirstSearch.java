package com.justin;

import java.util.ArrayDeque;
import java.util.Deque;

public class BreadthFirstSearch implements Algorithm {
    private Deque<Node> storage = new ArrayDeque<>();


    @Override
    public void addNewNode(Node parent, Location location) {
        storage.addLast(new Node(parent, location, 0, 0));
    }

    @Override
    public Node poll() {
        return storage.pollFirst();
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }
}
