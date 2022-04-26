package com.personal.list.linkedlist;

class Node {
    String item;
    Node next;
    Node prev;

     Node(Node prev, String element, Node next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
