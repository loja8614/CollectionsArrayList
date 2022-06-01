package com.personal.map.hahsmap;

import com.personal.Iterator;
import com.personal.arraylist.ArrayList;
import com.personal.map.Map;
import com.personal.map.domain.Entry;

public class HashMap<K extends Comparable<K>,V extends Comparable<V>> implements Map<K,V> {

    private ArrayList<Entry<K,V>>[] buckets;
    private int size;
    private int numBuckets = 3;

    public HashMap(){
        buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++)
            buckets[i] = new ArrayList<>();
    }

    public void put(K key, V value) {
        int index = getIndex(key);

        if (buckets[index].size() >= 10) {
            modifyBuckets();
            index = getIndex(key);

        }
        if (!contains(key)) {
            Entry<K,V> element = new Entry<>();
            element.setKey(key);
            element.setValue(value);
            buckets[index].add(element);
            size++;
        }
    }

    @Override
    public void remove(K elementKey) {
        int index = getIndex(elementKey);
        for (int i = 0; i < buckets[index].size(); i++) {
            Entry<K,V> objElement = buckets[index].getAt(i);
            if (objElement.getKey().equals(elementKey)) {
                buckets[index].remove(i);
                size--;
                break;
            }
        }
    }

    @Override
    public V get(K elementKey) {
        Entry<K,V> objElement=null;

        int index = getIndex(elementKey);
        for (int i = 0; i < buckets[index].size(); i++) {
            objElement = buckets[index].getAt(i);
            if (objElement.getKey().compareTo(elementKey)==0) {
                return objElement.getValue();
            }else{
                System.out.println("The element not exists");
                objElement.setValue(null);
            }
        }
        return objElement.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    public boolean contains(K elementKey) {
        int index = getIndex(elementKey);
        for (int i = 0; i < buckets[index].size(); i++) {
            if ((elementKey.compareTo(buckets[index].getAt(i).getKey()))==0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Entry<K,V>> iterator() {
        return new HashMapIterator();
    }


    private int getIndex(K KeyElement) {
        return ((KeyElement.hashCode() % numBuckets) < 0) ? ((KeyElement.hashCode() % numBuckets) * -1) : (KeyElement.hashCode() % numBuckets);
    }
    private void modifyBuckets() {

        int newNumBuckets = numBuckets * numBuckets;
        ArrayList<Entry<K,V>>[] newBuckets = new ArrayList[newNumBuckets];
        for (int i = 0; i < newNumBuckets; i++) {
            newBuckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                int hashcodeElement = buckets[i].getAt(j).hashCode();
                int newIndex = (hashcodeElement % newNumBuckets) < 0 ? (hashcodeElement % newNumBuckets) * -1 : (hashcodeElement % newNumBuckets);
                newBuckets[newIndex].add(buckets[i].getAt(j));
            }
        }
        numBuckets = newNumBuckets;
        buckets = newBuckets;
    }



    private class HashMapIterator implements Iterator<Entry<K,V>> {
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

        public Entry<K,V> next() {
            Entry<K,V> objElement = buckets[indexBucket].getAt(countElement);
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
