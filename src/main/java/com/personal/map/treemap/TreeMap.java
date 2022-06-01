package com.personal.map.treemap;

import com.personal.Iterator;
import com.personal.map.Map;
import com.personal.map.domain.Entry;

public class TreeMap<K extends Comparable<K>, V extends Comparable<V>> implements Map<K, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;


    private Node<K, V> root;
    private int size;
    private boolean ll = false; // Flag left left
    private boolean rr = false; // Flag Right Right
    private boolean lr = false; // Flag left Right
    private boolean rl = false; // Flag Right left

    public TreeMap() {
        root = null;
        size = 0;
    }

    public void put(K key, V value) {
        if (root == null) {
            root = new Node<K, V>(key, value);
            root.colour = false;
            size++;
        } else {
            if (!contains(key)) {
                this.root = addHelp(root, key, value);
                size++;
            }

        }
    }

    public void remove(K key) {
        if (getNode(root, key) != null) {
            root = removeHelp(root, key);
        }
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node<K, V> node = getNode(root, key);
        Entry<K, V> element = new Entry<>();
        if (node == null)
            return null;

        element.setKey(node.key);
        element.setValue(node.value);
        return element.getValue();
    }

    public int size() {
        return size;
    }

    public Iterator<Entry<K,V>> iterator() {
        return new TreeMapIterator(root);
    }

    private Node<K, V> addHelp(Node<K, V> root, K key, V value) {
        boolean flagRed = false;

        if (root == null)
            return (new Node<>(key, value));
        else if (key.compareTo(root.key) < 0) {
            root.left = addHelp(root.left, key, value);
            root.left.parent = root;
            if (root != this.root) {
                if (root.colour && root.left.colour)
                    flagRed = true;
            }
        } else if (key.compareTo(root.key) > 0) {
            root.right = addHelp(root.right, key, value);
            root.right.parent = root;
            if (root != this.root) {
                if (root.colour && root.right.colour)
                    flagRed = true;
            }
        }

        if (this.ll) {
            root = rotateLeft(root);
            root.colour = false;
            root.left.colour = true;
            this.ll = false;
        } else if (this.rr) {
            root = rotateRight(root);
            root.colour = false;
            root.right.colour = true;
            this.rr = false;
        } else if (this.rl) {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.colour = false;
            root.left.colour = true;

            this.rl = false;
        } else if (this.lr) {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.colour = false;
            root.right.colour = true;
            this.lr = false;
        }

        if (flagRed) {
            if (root.parent.right == root) {
                if (root.parent.left == null || !root.parent.left.colour) {
                    if (root.left != null && root.left.colour)
                        this.rl = true;
                    else
                        this.ll = true;
                } else {
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

    private Node<K, V> rotateLeft(Node<K, V> node) {
        Node<K, V> x = node.right;
        Node<K, V> y = x.left;
        x.left = node;
        node.right = y;
        node.parent = x; // parent resetting.
        if (y != null)
            y.parent = node;
        return (x);
    }

    private Node<K, V> rotateRight(Node<K, V> node) {
        Node<K, V> x = node.left;
        Node<K, V> y = x.right;
        x.right = node;
        node.left = y;
        node.parent = x;
        if (y != null)
            y.parent = node;
        return (x);
    }

    private Node<K, V> getNode(Node<K, V> node, K element) {
        if (node == null)
            return null;

        if (element.equals(node.key))
            return node;
        else if (element.compareTo(node.key) < 0)
            return getNode(node.left, element);
        else
            return getNode(node.right, element);
    }

    private Node<K, V> removeHelp(Node<K, V> node, K element) {
        if (element.compareTo(node.key) < 0) {
            node.left = removeHelp(node.left, element);
            if (node.left.key == element && node.left.left == null && node.left.right == null) {
                node.left = null;
                size--;
                return node;
            }
        } else if (element.compareTo(node.key) > 0) {
            node.right = removeHelp(node.right, element);
            if (node.right.key == element && node.right.left == null && node.right.right == null) {
                node.right = null;
                size--;
                return node;
            } else if (node.right.key == element && node.right.left != null) {
                node.right.key = node.right.left.key;
                node.right.left = null;
                size--;
                return node;
            }
        } else {
            if ((node.key.compareTo(element) == 0) && node.left == null && node.right == null) {
                node.left = null;
                return node;
            } else if (node.key == element && node.left != null && node.right == null) {
                return node;
            } else if (node.key == element && node.left != null) {


                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.parent = node.parent;
                successor.right = node.right;
                successor.right.parent = successor;
                successor.left = node.left;
                successor.left.parent = successor;
                return successor;

            }
        }

        return (node);
    }

    private Node<K, V> minimum(Node<K, V> node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node<K, V> removeMin(Node<K, V> node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private class TreeMapIterator implements Iterator<Entry<K,V>> {
        private Node<K,V> next;

        TreeMapIterator(Node root) {
            next = root;

            while (next.left != null)
                next = next.left;
        }


        public boolean hasNext() {
            return next != null;
        }

        public Entry<K,V> next() {
            Node<K,V> r = next;
            if (next.right != null) {
                next = next.right;
                while (next.left != null)
                    next = next.left;
                return new Entry<>(r.key,r.value);
            }

            while (true) {
                if (next.parent == null) {
                    next = null;
                    return new Entry<>(r.key,r.value);
                }
                if (next.parent.left == next) {
                    next = next.parent;
                    return new Entry<>(r.key,r.value);
                }

                next = next.parent;
            }
        }

    }
}
