package com.personal.arraylist;

import com.personal.Iterator;
import com.personal.List;
import com.personal.ReverseIterator;


public class ArrayList<T> implements List<T> {

    private T[] elementData;
    private int size;

    public ArrayList() {

        this.elementData = (T[]) new Object[2];
    }

    public void add(T element) {

        if (this.size == this.elementData.length) {
            grow(size * 2);
        }
        this.elementData[size] = element;
        this.size = this.size + 1;
    }

    public void insert(int index, T element) {
        if (index > size || index < 0) {
            System.out.println("IndexOutOfBoundsException --> Index: " + index + ", Size: " + size);
        } else {

            if (this.size == this.elementData.length)
                grow(this.size * 2);

            int newSize = this.size + 1;
            T[] arrElements = (T[]) new Object[newSize];

            for (int i = 0; i < newSize; i++) {
                if (i != index && i < index)
                    arrElements[i] = this.elementData[i];
                else if (i == index)
                    arrElements[i] = element;
                else
                    arrElements[i] = this.elementData[i - 1];
            }
            this.elementData = arrElements;
            this.size++;
        }
    }

    public T getAt(int index) {
        return this.elementData[index];
    }

    public void setAt(int index, T element) {
        this.elementData[index] = element;
    }

    public void remove(int index) {

        for (int i =index; i < size-1; i++) {
            this.elementData[i]=this.elementData[i+1];
        }
        this.elementData[size-1]=null;
        this.size--;
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
        T[] arrElements = (T[]) new Object[newSize];
        ;

        for (int i = 0; i < this.size; i++) {
            arrElements[i] = this.elementData[i];
        }
        this.elementData = arrElements;
    }

    private class ArrayListIterator implements Iterator, ReverseIterator {
        int cursor;
        int reverserCursor = size - 1;

        ArrayListIterator() {
        }

        public boolean hasNext() {
            return this.cursor != size;
        }

        public T next() {
            T strElement = elementData[this.cursor];
            this.cursor++;
            return strElement;
        }

        public boolean hasPrev() {
            return reverserCursor >= 0;
        }

        public T previous() {
            T strElement = elementData[this.reverserCursor];
            reverserCursor--;
            return strElement;
        }
    }
}
