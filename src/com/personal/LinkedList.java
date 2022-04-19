package com.personal;

import java.util.Collection;

public class LinkedList<String> implements List<String> {

    transient int size = 0;
    transient Node<String> first;
    transient Node<String> last;
    protected transient int modCount = 0;

    public LinkedList() {    }
   /*public LinkedList(Collection<? extends String> c) {
        this();
        //addAll(c);
    }*/

    public void add(String element) {
        final Node<String> l = last;
        final Node<String> newNode = new Node<String>(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    public void insert(int index, String element) {
        if(index >= 0 && index <= size+1){
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
        Node<String> x = node(index);
        String oldVal = x.item;
        x.item = element;
    }


    public void remove(int index) {
        unlink(node(index));

    }

    public void removeAll() {
        for (Node<String> x = first; x != null; ) {
            Node<String> next = x.next;
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
        return null;
    }

    private class ListItr implements Iterator<String> {
        private Node<String> lastReturned;
        private Node<String> next;
        private int nextIndex;
        private int expectedModCount = modCount;
        ListItr(){}

        ListItr(int index) {
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public String next() {
            if (!hasNext())
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }
        public int nextIndex() {
            return nextIndex;
        }

    }

    private static class Node<String> {
        String item;
        Node<String> next;
        Node<String> prev;

        Node(Node<String> prev, String element, Node<String> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<String> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<String> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<String> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    void linkLast(String e) {
        final Node<String> l = last;
        final Node<String> newNode = new Node<String>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
    void linkBefore(String e, Node<String> succ) {
        // assert succ != null;
        final Node<String> pred = succ.prev;
        final Node<String> newNode = new Node<String>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }
    void unlink(Node<String> x) {
        final String element = x.item;
        final Node<String> next = x.next;
        final Node<String> prev = x.prev;

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
