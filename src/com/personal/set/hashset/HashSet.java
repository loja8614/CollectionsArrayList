package com.personal.set.hashset;

import com.personal.list.Iterator;
import com.personal.list.arraylist.ArrayList;
import com.personal.set.Set;

public class HashSet<T> implements Set<T> {

    private ArrayList<T>[] buckets;
    private int size;
    private int numBuckets = 3;

    public HashSet() {
        buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++)
            buckets[i] = new ArrayList<T>();
    }

    public void add(T element) {
        int index = getIndex(element);

        if (buckets[index].size() >= 10) {
            modifyBuckets();
            index = getIndex(element);

        }
        if (!contains(element)) {
            buckets[index].add(element);
            size++;
        }
    }

    public void remove(T element) {
        int index = element.hashCode() % numBuckets;
        for (int i = 0; i < buckets[index].size(); i++) {
            Object objElement = buckets[index].getAt(i);
            if (objElement.equals(element)) {
                buckets[index].remove(i);
                size--;
                break;
            }
        }
    }

    public void removeAll() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    public boolean contains(T element) {
        boolean elementIsPresent = false;
        int index = getIndex(element);

        for (int i = 0; i < buckets[index].size(); i++) {
            Object objElement = buckets[index].getAt(i);
            if (objElement.equals(element)) {
                elementIsPresent = true;
            }
        }
        return elementIsPresent;
    }

    public int size() {
        return this.size;
    }

    public Iterator<T> iterator() {
        return new HasSetIterator();
    }

    private int getIndex(T element) {
        return ((element.hashCode() % numBuckets) < 0) ? ((element.hashCode() % numBuckets) * -1) : (element.hashCode() % numBuckets);
    }

    private void modifyBuckets() {

        int newNumBuckets = numBuckets * numBuckets;
        ArrayList<T>[] newBuckets = new ArrayList[newNumBuckets];
        for (int i = 0; i < newNumBuckets; i++) {
            newBuckets[i] = new ArrayList<T>();
        }

        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                int hashcodeElement = buckets[i].getAt(j).hashCode();
                int newIndex = (hashcodeElement % newNumBuckets) < 0 ? (hashcodeElement % numBuckets) * -1 : (hashcodeElement % newNumBuckets);
                newBuckets[newIndex].add(buckets[i].getAt(j));
            }
        }
        numBuckets = newNumBuckets;
        buckets = new ArrayList[numBuckets];
        buckets = newBuckets;
    }

    private class HasSetIterator implements Iterator<T> {
        int cursor;
        int countElement = 0;
        int indexBucket = 0;

        public boolean hasNext() {
            while ((indexBucket < buckets.length - 1) && ((buckets[indexBucket].size() == 0) || (countElement == buckets[indexBucket].size()))) {
                indexBucket++;
                countElement = 0;
            }
            return cursor != size;

        }

        public T next() {
            T objElement = buckets[indexBucket].getAt(countElement);
            countElement++;
            if (!((buckets[indexBucket].size()) > 1)) {
                indexBucket++;
                countElement = 0;
            }
            cursor++;
            return objElement;
        }
    }
}
