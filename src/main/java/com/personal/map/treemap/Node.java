package com.personal.map.treemap;

import com.personal.map.domain.Entry;

class Node<K extends Comparable<K>, V extends Comparable<V>> {

    private static final boolean RED = true;

    K key;
    V value;
    Node left;
    Node right;
    boolean colour;
    Node parent;


    public Node(K key, V value) {
        this.key = key;
        this.value=value;
        left = null;
        right = null;
        colour = RED;
        parent=null;

    }
}
