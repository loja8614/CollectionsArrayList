package com.personal;


public interface List<String> {
    /**
     * Inserts the specified element  in this list
     * @param element element to be inserted
     **/
    void add(String element);
    /**
     * Inserts the specified element at the specified position in this list
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    void insert(int index, String element);
    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    String getAt(int index);
    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     */
    void setAt(int index, String element);
    /**
     * Removes the element at the specified position in this list
     * @param index index of the element to remove
     * */
    void remove(int index);
    /**
     * Removes all elements in this list
     * */
    void removeAll();
    /**
     * Returns the number of elements in this list.  If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this list
     */
    int size();
    Iterator iterator();




}
