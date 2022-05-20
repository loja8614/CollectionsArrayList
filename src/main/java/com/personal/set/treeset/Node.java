package com.personal.set.treeset;

class Node {

    private static final boolean RED = true;

    Integer item;
    Node left;
    Node right;
    boolean colour;
    Node parent;


    public Node(Integer item) {
        this.item = item;
        left = null;
        right = null;
        colour = RED;
        parent=null;

    }

}
