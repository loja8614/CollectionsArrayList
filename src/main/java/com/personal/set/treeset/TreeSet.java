package com.personal.set.treeset;

import com.personal.Iterator;
import com.personal.arraylist.ArrayList;
import com.personal.set.Set;

public class TreeSet<T> implements Set<T> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int size;
    boolean ll = false; // Flag left left
    boolean rr = false; // Flag Right Right
    boolean lr = false; // Flag left Right
    boolean rl = false; // Flag Right left

    public TreeSet() {
        root = null;
        size = 0;
    }

    public void add(T gElement) {
        Integer element = (Integer) gElement;
        if (this.root == null) {
            this.root = new Node(element);
            this.root.colour = false;
            size++;
        } else {
            this.root = addHelp(root, element);
            size++;
        }
    }

    public void remove(T item) {
        Node node = getNode(root, item);
        if (node != null) {
            root = remove(root, item);
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
        return new TreeSetIterator();
    }


    private Node rotateLeft(Node node) {
        Node x = node.right;
        Node y = x.left;
        x.left = node;
        node.right = y;
        node.parent = x; // parent resetting.
        if (y != null)
            y.parent = node;
        return (x);
    }


    private Node rotateRight(Node node) {
        Node x = node.left;
        Node y = x.right;
        x.right = node;
        node.left = y;
        node.parent = x;
        if (y != null)
            y.parent = node;
        return (x);
    }

    private Node getNode(Node node, T element) {
        int intElement = (int) element;
        if (node == null)
            return null;

        if (element.equals(node.item))
            return node;
        else if (intElement < node.item)
            return getNode(node.left, element);
        else
            return getNode(node.right, element);
    }


    // Returns the node where the minimum value is found
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // Removes the smallest node
    // Returns the new root after remove the node
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node remove(Node node, T item) {
        int intElement = (int) item;

        if (intElement< node.item) {
            node.left = remove(node.left, item);
            return node;
        } else if (intElement > node.item) {
            node.right = remove(node.right, item);
            return node;
        } else {

            // left subtree of the node to delete is empty
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // Right subtree of the node to delete is empty
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // Look for the smallest node larger than the node to remove and use this node to replace the position of the node to be removed
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    private Node addHelp(Node root, Integer element) {
        // f is true when RED RED conflict is there.
        boolean flagRed = false;

        //recursive calls to insert at proper position according to BST properties.
        if (root == null)
            return (new Node(element));
        else if (element.compareTo(root.item) < 0) {
            root.left = addHelp(root.left, element);
            root.left.parent = root;
            if (root != this.root) {
                if (root.colour == true && root.left.colour == true)
                    flagRed = true;
            }
        } else {
            root.right = addHelp(root.right, element);
            root.right.parent = root;
            if (root != this.root) {
                if (root.colour == true && root.right.colour == true)
                    flagRed = true;
            }
            // at the same time of insertion, assigning parent nodes
            //Review  RED RED conflicts
        }

        // rotate in different directions.
        if (this.ll) // for left rotate.
        {
            root = rotateLeft(root);
            root.colour = false;
            root.left.colour = true;
            this.ll = false;
        } else if (this.rr) // right rotate
        {
            root = rotateRight(root);
            root.colour = false;
            root.right.colour = true;
            this.rr = false;
        } else if (this.rl)  // right and then left
        {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.colour = false;
            root.left.colour = true;

            this.rl = false;
        } else if (this.lr)  // left and then right.
        {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.colour = false;
            root.right.colour = true;
            this.lr = false;
        }

        // Change if there are RED RED conflicts
        if (flagRed) {
            if (root.parent.right == root)  // to check which child is the current node of its parent
            {
                if (root.parent.left == null || !root.parent.left.colour)  // case when parent's sibling is black
                {// perform certaing rotation and recolouring. This will be done while backtracking. Hence setting up respective flags.
                    if (root.left != null && root.left.colour)
                        this.rl = true;
                    else if (root.right != null && root.right.colour)
                        this.ll = true;
                } else // case when parent's sibling is red
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
                    else if (root.right != null && root.right.colour)
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
        ArrayList<T> elements = new ArrayList<T>();
        int cursor;
        public TreeSetIterator(){
            inOrden(root);
        }

        public boolean hasNext() {
            return size != cursor && root != null;
        }

        public T next() {
            cursor++;
            return elements.getAt(cursor-1);
        }

        private void inOrden(Node node) {
            if (node != null) {
                inOrden(node.left);
                elements.add((T) node.item);
                inOrden(node.right);
            }

        }
    }
}
