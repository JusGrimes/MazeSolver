package com.justin;

public interface Algorithm {
    void addNewNode(Node parent, Location location, double cost, Location goal);
    Node poll();
    boolean isEmpty();
}
