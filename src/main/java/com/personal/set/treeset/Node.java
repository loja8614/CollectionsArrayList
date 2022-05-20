package com.personal.set.treeset;

class Node<T extends Comparable<T>> {

    private static final boolean RED = true;

    T item;
    Node left;
    Node right;
    boolean colour;
    Node parent;


    public Node(T item) {
        this.item = item;
        left = null;
        right = null;
        colour = RED;
        parent=null;

    }

}
