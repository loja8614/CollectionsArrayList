package com.personal.map.domain;

public class Entry<K extends Comparable<K>, V extends Comparable<V>> {
    private K key;
    private V value;

    public Entry() {
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
