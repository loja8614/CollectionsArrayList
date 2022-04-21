package com.personal.list.linkedlist;

import com.personal.list.Iterator;
import com.personal.list.List;

public class LinkedList implements List {

    transient int size = 0;
    transient Node first;
    transient Node last;
    protected transient int modCount = 0;

    public LinkedList() {
    }

    public void add(String element) {
        final Node l = last;
        final Node newNode = new Node(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    public void insert(int index, String element) {
        if (index >= 0 && index <= size + 1) {
            if (index == size)
                linkLast(element);
            else
                linkBefore(element, node(index));
        }
    }

    public String getAt(int index) {
        return node(index).item;
    }


    public void setAt(int index, String element) {
        Node x = node(index);
        String oldVal = x.item;
        x.item = element;
    }


    public void remove(int index) {
        unlink(node(index));
    }

    public void removeAll() {
        for (Node x = first; x != null; ) {
            Node next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
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
        private int expectedModCount = modCount;
        int index = 0;

        ListIterator() {
            this.expectedModCount = LinkedList.this.modCount;
            this.next = index == LinkedList.this.size ? null : LinkedList.this.nodelnklist(index);
            this.nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public String next() {
            String strlastReturned = null;
            if (hasNext()) {
                strlastReturned = next.item;
                lastReturned = next;
                next = next.next;
                nextIndex++;
            }
            return strlastReturned;
        }
    }

    private static class Node {
        String item;
        Node next;
        Node prev;

        Node(Node prev, String element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    Node node(int index) {

        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    Node nodelnklist(int index) {
        LinkedList.Node x;
        int i;
        if (index < this.size >> 1) {
            x = this.first;

            for (i = 0; i < index; ++i) {
                x = x.next;
            }

            return x;
        } else {
            x = this.last;

            for (i = this.size - 1; i > index; --i) {
                x = x.prev;
            }

            return x;
        }
    }

    void linkLast(String e) {
        final Node l = last;
        final Node newNode = new Node(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    void linkBefore(String e, Node succ) {
        // assert succ != null;
        final Node pred = succ.prev;
        final Node newNode = new Node(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }

    void unlink(Node x) {
        final String element = x.item;
        final Node next = x.next;
        final Node prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
    }
}
