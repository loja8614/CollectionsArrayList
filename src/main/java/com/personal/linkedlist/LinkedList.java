package com.personal.linkedlist;

import com.personal.Iterator;
import com.personal.List;

public class LinkedList<T> implements List<T> {

    private int size = 0;
    private Node first;
    private Node last;


    public void add(T element)    {
        linkLast(element);

    }

    public void insert(int index, T element) {
        if (index >= 0 && index <= size + 1) {
            if (index == size) {
                linkLast(element);
            } else {
                Node nodeInsert = getNode(index);
                linkBefore(element, nodeInsert);
            }
        }
    }

    public T getAt(int index) {
        return (T)getNode(index).item;
    }

    public void setAt(int index, T element) {
        Node nodeSetAt = getNode(index);
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

    public Iterator<T> iterator() {
        return new ListIterator();
    }
    public Iterator<T> reverseIterator() {
        return new ListReverseIterator();
    }

    private class ListIterator implements Iterator {
        private Node next;
        private int nextIndex;
        int index = 0;

        ListIterator() {
            this.next = getNode(index);
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public T next() {
            T varReturned = null;
            if (hasNext()) {
                varReturned = (T) next.item;
                next = next.next;

                nextIndex++;
            }
            return varReturned;
        }


    }

    private class ListReverseIterator implements Iterator {
        private Node previous;
        private int previousIndex=size-1;
        int index = 0;

        ListReverseIterator() {
            this.previous=getNode(size-1);
        }

        public boolean hasNext() {
            return previousIndex >=0;
        }

        public T next() {
            T varReturned = null;
            if (hasNext()) {
                varReturned = (T) previous.item;
                previous = previous.prev;
                previousIndex--;
            }
            return varReturned;
        }

    }

    private void linkLast(T element) {
        Node nodeLast = last;
        Node newNode = new Node(nodeLast, element, null);
        last = newNode;
        if (nodeLast == null)
            first = newNode;
        else
            nodeLast.next = newNode;
        size++;
    }

    private void linkBefore(T element, Node nodeSuccessor) {
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
