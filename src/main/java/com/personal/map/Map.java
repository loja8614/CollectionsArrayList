package com.personal.map;

import com.personal.Iterator;
import com.personal.map.domain.Entry;

public interface Map<K , V>  {
    /**
     * Adds the specified element to this map if it is not already present
     * *@param element to be put to this map
     */
    void put(K key ,V value);

    /**
     * Removes the specified element from this map if it is present
     * *@param element  to be removed from this map, if present
     */
    void remove(K key);

    boolean contains(K key);

    /**
     * Returns {@code true} if this set contains the specified element.
     * More formally, returns {@code true} if and only if this set
     * contains an element {@code e} such that

     * *@param  element whose presence in this set is to be tested
     * @return {@code true} if this set contains the specified element
     */
    Entry <K,V> get(K key);


    /**
     * Returns the number of elements in this set
     * @return the number of elements in this set
     */
    int size();

    /**
     * Returns an iterator over the elements in this map.
     *
     * @return an iterator over the elements in this map
     */
    Iterator<V>  iterator();
}

