package com.personal;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class ArrayList<S> implements List<String>{

    private static final String[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    String [] elementData;
    private int size;
    private int modCount = 0;

    public ArrayList(){
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public void add(String element) {
        modCount++;
        if (size == elementData.length) {
            elementData = grow(size + 1);
        }
        elementData[size] = element;
        size = size + 1;
    }
    public void insert(int index, String element) {

        if (index > size || index < 0)
            System.out.println("IndexOutOfBoundsException --> Index: "+index+", Size: "+size);
        modCount++;
        final int s;
        String[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow(size + 1);
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = element;
        size = s + 1;
    }
    public String getAt(int index) {
        return elementData[index];
    }
    public void setAt(int index, String element) {
        elementData[index] = element;
    }
    public void remove(int index) {
        modCount++;
        int newSize;
        if ((newSize = size - 1) > index)
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        elementData[size = newSize] = null;

    }
    public void removeAll() {
        modCount++;
        for (int to = size, i = size = 0; i < to; i++)
            elementData[i] = null;
    }
    public int size() {
        return size;
    }
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private String[] grow(int newsize) {
        int currentCapacity = elementData.length;
        if (currentCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = elementData.length+1;
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new String[newsize];
        }
    }

    private class ArrayListIterator implements Iterator<String> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        ArrayListIterator() {}

        public boolean hasNext() {
            return cursor != size;
        }

        public String next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            String[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (String) elementData[lastRet = i];
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
