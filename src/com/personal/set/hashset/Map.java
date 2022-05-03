package com.personal.set.hashset;

public class Map<K,V> {

    final K key;
    V value;

    Map(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public final K getKey()        { return key; }
    public final V getValue()      { return value; }
    public final String toString() { return key + "=" + value; }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
}
