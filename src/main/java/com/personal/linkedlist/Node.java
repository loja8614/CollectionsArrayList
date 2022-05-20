package com.personal.linkedlist;

class Node <T>{
    T item;
    Node next;
    Node prev;

     Node(Node prev, T element, Node next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
