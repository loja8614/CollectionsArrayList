package com.personal.list.linkedlist;

class Node {
    Object item;
    Node next;
    Node prev;

     Node(Node prev, Object element, Node next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
