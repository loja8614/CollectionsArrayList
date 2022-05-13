package com.personal;

public interface ReverseIterator<T> {
    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #previous} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    boolean hasPrev();

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    T previous();
}
