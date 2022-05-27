package com.personal.set.treeset;

import com.personal.Iterator;
import com.personal.arraylist.ArrayList;
import com.personal.set.Set;

public class TreeSet<T extends Comparable<T>> implements Set<T> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node<T> root;
    private int size;
    private boolean ll = false; // Flag left left
    private boolean rr = false; // Flag Right Right
    private boolean lr = false; // Flag left Right
    private boolean rl = false; // Flag Right left

    public TreeSet() {
        root = null;
        size = 0;
    }

    public void add(T element) {
        if (root == null) {
            root = new Node<>(element);
            root.colour = false;
            size++;
        } else {
            if (!contains(element)) {
                this.root = addHelp(root, element);
                size++;
            }

        }
    }

    public void remove(T item) {
        if (getNode(root, item) != null) {
            root = removeHelp(root, item);
        }
    }

    public void removeAll() {
        root = null;
        size = 0;
    }

    public boolean contains(T element) {
        return getNode(root, element) != null;
    }

    public int size() {
        return size;
    }


    public Iterator<T> iterator() {
        return new TreeSetIterator(root);
    }


    private Node<T> rotateLeft(Node<T> node) {
        Node<T> x = node.right;
        Node<T> y = x.left;
        x.left = node;
        node.right = y;
        node.parent = x; // parent resetting.
        if (y != null)
            y.parent = node;
        return (x);
    }


    private Node<T> rotateRight(Node<T> node) {
        Node<T> x = node.left;
        Node<T> y = x.right;
        x.right = node;
        node.left = y;
        node.parent = x;
        if (y != null)
            y.parent = node;
        return (x);
    }

    private Node<T> getNode(Node<T> node, T element) {
        if (node == null)
            return null;

        if (element.equals(node.item))
            return node;
        else if (element.compareTo(node.item) < 0)
            return getNode(node.left, element);
        else
            return getNode(node.right, element);
    }

    private Node<T> removeHelp(Node<T> node, T element) {
        if (element.compareTo(node.item) < 0) {
            node.left = removeHelp(node.left, element);
            if(node.left.item == element && node.left.left==null && node.left.right==null){
                node.left=null;
                size--;
                return node;
            }
        } else if(element.compareTo(node.item)>0){
            node.right=removeHelp(node.right,element);
            if(node.right.item == element && node.right.left==null && node.right.right==null){
                node.right=null;
                size--;
                return node;
            }
            else if(node.right.item == element && node.right.left!=null ){
                node.right.item=node.right.left.item;
                node.right.left=null;
                size--;
                return node;
            }
        }else {
            if((node.item.compareTo(element)==0) && node.left==null && node.right==null){
                node.left=null;
                return node;
            }else if(node.item == element && node.left!=null && node.right==null ){
                return node;
            }else if (node.item == element && node.left!=null){


                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.parent=node.parent;
                successor.right=node.right;
                successor.right.parent=successor;
                successor.left = node.left;
                successor.left.parent=successor;
                return successor;

            }
        }

       return (node);
    }

    private Node<T> minimum(Node<T> node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node<T> removeMin(Node<T> node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node<T> addHelp(Node<T> root, T element) {
        boolean flagRed = false;

        if (root == null)
            return (new Node<>(element));
        else if (element.compareTo(root.item) < 0) {
            root.left = addHelp(root.left, element);
            root.left.parent = root;
            if (root != this.root) {
                if (root.colour && root.left.colour)
                    flagRed = true;
            }
        } else if (element.compareTo(root.item) > 0) {
            root.right = addHelp(root.right, element);
            root.right.parent = root;
            if (root != this.root) {
                if (root.colour && root.right.colour)
                    flagRed = true;
            }
        }

        if (this.ll)
        {
            root = rotateLeft(root);
            root.colour = false;
            root.left.colour = true;
            this.ll = false;
        } else if (this.rr)
        {
            root = rotateRight(root);
            root.colour = false;
            root.right.colour = true;
            this.rr = false;
        } else if (this.rl)
        {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.colour = false;
            root.left.colour = true;

            this.rl = false;
        } else if (this.lr)
        {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.colour = false;
            root.right.colour = true;
            this.lr = false;
        }

        if (flagRed) {
            if (root.parent.right == root)
            {
                if (root.parent.left == null || !root.parent.left.colour)
                {
                    if (root.left != null && root.left.colour)
                        this.rl = true;
                    else
                        this.ll = true;
                } else
                {
                    root.parent.left.colour = false;
                    root.colour = false;
                    if (root.parent != this.root)
                        root.parent.colour = true;
                }
            } else {
                if (root.parent.right == null || !root.parent.right.colour) {
                    if (root.left != null && root.left.colour)
                        this.rr = true;
                    else
                        this.lr = true;
                } else {
                    root.parent.right.colour = false;
                    root.colour = false;
                    if (root.parent != this.root)
                        root.parent.colour = true;
                }
            }
            flagRed = false;
        }
        return (root);
    }

    private class TreeSetIterator implements Iterator<T> {
        private Node<T> next;

        public TreeSetIterator(Node root) {
            next = root;

            while (next.left != null)
                next = next.left;
        }


        public boolean hasNext() {
            return next != null;
        }

        public T next() {
            Node<T> r = next;
            if (next.right != null) {
                next = next.right;
                while (next.left != null)
                    next = next.left;
                return r.item;
            }

            while (true) {
                if (next.parent == null) {
                    next = null;
                    return r.item;
                }
                if (next.parent.left == next) {
                    next = next.parent;
                    return r.item;
                }

                next = next.parent;
            }
        }

    }
}
