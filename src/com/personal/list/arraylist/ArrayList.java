package com.personal.list.arraylist;

import com.personal.list.Iterator;
import com.personal.list.List;


public class ArrayList implements List {

    private String[] elementData;
    private int size;

    public ArrayList() {
        this.elementData = new String[2];
    }

    public void add(String element) {

        if (this.size == this.elementData.length) {
            grow(size * 2);
        }
        this.elementData[size] = element;
        this.size = this.size + 1;
    }

    public void insert(int index, String element) {
        if (index > size || index < 0) {
            System.out.println("IndexOutOfBoundsException --> Index: " + index + ", Size: " + size);
        } else {

            if (this.size == this.elementData.length)
                grow(this.size * 2);

            int newSize = this.size + 1;
            String[] arrElements = new String[newSize];
            //Opc1
        /*
        for (int i = 0; i < newSize; i++) {
            if (i != index && i < index)
                arrElements[i] = this.elementData[i];
            else if (i == index)
                arrElements[i] = element;
            else
                arrElements[i] = this.elementData[i - 1];
        }
        */
            //Opc2
            int remainingElements = size - index;
            System.arraycopy(this.elementData, 0, arrElements, 0, index);
            arrElements[index] = element;
            System.arraycopy(this.elementData, index, arrElements, index + 1, remainingElements);

            this.elementData = arrElements;
            this.size++;
        }
    }

    public String getAt(int index) {
        return this.elementData[index];
    }

    public void setAt(int index, String element) {
        this.elementData[index] = element;
    }

    public void remove(int index) {

        int newSize = this.size - 1;
        String[] arrElements = new String[newSize];
        //Opc1
        /*
        int k = index == 0 ? 1 : 0;
        int j = 0;

        for (int i = k; i < this.size; i++) {
            if (index != i) {
                arrElements[j] = this.elementData[i];
                j++;
            }else
                arrElements[j] = this.elementData[i-1];
        }
        */
        //Opc2
        int remainingElements = size - (index + 1);
        System.arraycopy(this.elementData, 0, arrElements, 0, index);
        System.arraycopy(this.elementData, index + 1, arrElements, index, remainingElements);

        this.elementData = arrElements;
        this.size = newSize;
    }

    public void removeAll() {
        for (int i = 0; i < this.size; i++)
            this.elementData[i] = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public Iterator iterator() {
        return new ArrayListIterator();
    }

    private void grow(int newSize) {
        String[] arrElements = new String[newSize];

        for (int i = 0; i < this.size; i++) {
            arrElements[i] = this.elementData[i];
        }
        this.elementData = arrElements;
    }

    private class ArrayListIterator implements Iterator {
        int cursor;

        ArrayListIterator() {
        }

        public boolean hasNext() {
            boolean isHasNext = this.cursor != size;
            return isHasNext;
        }

        public String next() {
            String[] elementData = ArrayList.this.elementData;
            String strElement = elementData[this.cursor];
            this.cursor++;
            return strElement;
        }
    }
}
