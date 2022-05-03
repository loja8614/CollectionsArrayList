package com.personal.set.hashset;

import com.personal.list.Iterator;
import com.personal.set.Set;

public class HashSet<T> implements Set<T> {

    private Map<T, T>[] elementsData;
    private int size;


    public HashSet() {
    }

    public void add(Object element) {

    }

    public void remove(Object element) {

    }

    public boolean removeAll() {
        return false;
    }

    public boolean contains(Object element) {
        return false;
    }

    public void clear() {

    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isEquals(Object element) {
        return false;
    }

    public int getHashCode(Map<T, T> element) {
        int hash = 0;
        int length = element.value.toString().length();
        for (int i = 0; i < length; i++) {
            hash = 31 * hash + (int) getChar(element.value.toString(), i);
        }
        return hash;
    }

    public Iterator<T> iterator() {
        return null;
    }
    
    private char getChar(String strElement, int index){
        char var[] = new char[strElement.length()-1];
        for (int i =0;i< strElement.length();i++){
            var[i]=strElement.charAt(i);
        }
        return var[index];
    }
}
