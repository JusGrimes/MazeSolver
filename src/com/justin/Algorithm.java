package com.justin;

public interface Algorithm {
    void addNewNode(Node parent, Location location);
    Node poll();
    boolean isEmpty();
}
