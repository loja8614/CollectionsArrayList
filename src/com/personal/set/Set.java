package com.personal.set;

import com.personal.list.Iterator;

public interface Set<T> {

    /**
     * Adds the specified element to this set if it is not already present
     * *@param element to be added to this set
     */
    void add(T element);

    /**
     * Removes the specified element from this set if it is present
     * *@param element  to be removed from this set, if present
     */
    void remove(T element);

    /**
     * Removes from this set all of its elements that are contained in the specified collection
     */
    void removeAll();

    /**
     * Returns {@code true} if this set contains the specified element.
     * More formally, returns {@code true} if and only if this set
     * contains an element {@code e} such that

     * *@param  element whose presence in this set is to be tested
     * @return {@code true} if this set contains the specified element
     */
    boolean contains(T element);

    /**
     * Returns the number of elements in this set
     * @return the number of elements in this set
     */
    int size();

    /**
     * Returns an iterator over the elements in this set.  The elements are
     * returned in no particular order (unless this set is an instance of some
     * class that provides a guarantee).
     *
     * @return an iterator over the elements in this set
     */
    Iterator<T> iterator();
}
