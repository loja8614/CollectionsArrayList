package com.personal.list.linkedlist;

import com.personal.list.Iterator;
import com.personal.list.List;

public class LinkedList implements List {

    private int size = 0;
    private Node first;
    private Node last;
    public LinkedList() {

    }

    public void add(String element) {
        linkLast(element);
    }

    public void insert(int index, String element) {
        if (index >= 0 && index <= size + 1) {
            if (index == size) {
                linkLast(element);
            } else {
                Node nodeInsert = getNode(index);
                linkBefore(element, nodeInsert);
            }
        }
    }

    public String getAt(int index) {
        return getNode(index).item;
    }

    public void setAt(int index, String element) {
        Node nodeSetAt = getNode(index);
        String oldVal = nodeSetAt.item;
        nodeSetAt.item = element;
    }

    public void remove(int index) {
        Node nodeRemove = getNode(index);
        unlink(nodeRemove);
    }

    public void removeAll() {

        Node startNode = first;
        while (startNode != null) {
            Node next = startNode.next;
            startNode.item = null;
            startNode.next = null;
            startNode.prev = null;
            startNode = next;
        }
        last = null;
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator {
        private Node lastReturned;
        private Node next;
        private int nextIndex;
        int index = 0;

        ListIterator() {
            this.next = getNode(index);
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public String next() {
            String strReturned = null;
            if (hasNext()) {
                strReturned = next.item;
                next = next.next;
                lastReturned = next;
                nextIndex++;
            }
            return strReturned;
        }
    }

    private void linkLast(String element) {
        Node nodeLast = last;
        Node newNode = new Node(nodeLast, element, null);
        last = newNode;
        if (nodeLast == null)
            first = newNode;
        else
            nodeLast.next = newNode;
        size++;
    }

    private void linkBefore(String element, Node nodeSuccessor) {
        Node nodePredecessor = nodeSuccessor.prev;
        Node newNode = new Node(nodePredecessor, element, nodeSuccessor);
        nodeSuccessor.prev = newNode;
        if (nodePredecessor == null)
            first = newNode;
        else
            nodePredecessor.next = newNode;
        size++;
    }

    private void unlink(Node nodeUnlink) {
        Node next = nodeUnlink.next;
        Node prev = nodeUnlink.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            nodeUnlink.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            nodeUnlink.next = null;
        }

        nodeUnlink.item = null;
        size--;
    }

    Node getNode(int index) {
        if (index < 1) {
            Node newNode = first;
            for (int i = 0; i < index; i++)
                newNode = newNode.next;
            return newNode;
        } else {
            Node newNode = last;
            int tmpSize = size - 1;
            for (int i = tmpSize; i > index; i--)
                newNode = newNode.prev;
            return newNode;
        }
    }
}
