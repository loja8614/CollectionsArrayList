package com.personal.set;

import com.personal.list.Iterator;
import com.personal.set.hashset.Map;

public interface Set<T> {

    /**
     * Adds the specified element to this set if it is not already present
     * *@param element to be added to this set
     */
    void add(Object element);

    /**
     * Removes the specified element from this set if it is present
     * *@param element  to be removed from this set, if present
     */
    void remove(Object element);

    /**
     * Removes from this set all of its elements that are contained in the specified collection
     */
    boolean removeAll();

    /**
     * Returns {@code true} if this set contains the specified element.
     * More formally, returns {@code true} if and only if this set
     * contains an element {@code e} such that

     * *@param  element whose presence in this set is to be tested
     * @return {@code true} if this set contains the specified element
     */
    boolean contains(Object element);

    /**
     * Removes all of the elements from this set (optional operation).
     */
    void clear();

    /**
     * Returns the number of elements in this set
     * @return the number of elements in this set
     */
    int size();

    /**
     * Returns {@code true} if this set contains no elements.
     * @return {@code true} if this set contains no elements
     */
    boolean isEmpty();

    /**
     * Compares the specified object with this set for equality.  Returns
     * {@code true} if the specified object is also a set, the two sets
     * have the same size, and every member of the specified set is
     * contained in this set (or equivalently, every member of this set is
     * contained in the specified set).  This definition ensures that the
     * equals method works properly across different implementations of the
     * set interface.
     *
     * *@param element to be compared for equality with this set
     * @return {@code true} if the specified object is equal to this set
     */
    boolean isEquals(Object element);

    /**
     * Returns the hash code value for this set.  The hash code of a set is
     * defined to be the sum of the hash codes of the elements in the set,
     * where the hash code of a {@code null} element is defined to be zero.
     *
     * @return the hash code value for this set
     */
    int getHashCode(Map<T,T> element);

    /**
     * Returns an iterator over the elements in this set.  The elements are
     * returned in no particular order (unless this set is an instance of some
     * class that provides a guarantee).
     *
     * @return an iterator over the elements in this set
     */
    Iterator<T> iterator();

}
