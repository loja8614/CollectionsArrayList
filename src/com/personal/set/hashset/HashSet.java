package com.personal.set.hashset;

import com.personal.list.Iterator;
import com.personal.list.arraylist.ArrayList;
import com.personal.set.Set;

public class HashSet<T> implements Set<T> {

    private ArrayList<T>[] buckets;
    private int size;
    private int numBuckets=3;

    public HashSet() {
        buckets=new ArrayList[numBuckets];
        buckets[0]=new ArrayList<T>();
        buckets[1]=new ArrayList<T>();
        buckets[2]=new ArrayList<T>();
    }

    public void add(T element) {
        int index = element.hashCode() % numBuckets;
        if(!contains(element)){
            buckets[index].add(element);
            size++;
        }
    }

    public void remove(T element) {
        int index = element.hashCode() % numBuckets;
        for(int i =0;i<buckets[index].size();i++){
            Object objElement = buckets[index].getAt(i);
            if(objElement.equals(element)){
                buckets[index].remove(i);
                size--;
                break;
            }
        }
    }

    public void removeAll() {
        for(int i =0; i<buckets.length;i++){
            buckets[i]=null;
        }
        size=0;
    }

    public boolean contains(T element) {
        boolean elementIsPresent=false;
        int index = element.hashCode() % numBuckets;

        for(int i =0;i<buckets[index].size();i++){
            Object objElement = buckets[index].getAt(i);
            if(objElement.equals(element)){
                elementIsPresent=true;
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

    private class HasSetIterator implements Iterator{
        int cursor ;
        int indexBucket= buckets.length-1;
        int countElement =0;

        public boolean hasNext() {
            return cursor!=size;
        }

        public Object next() {
            Object objElement=null;
                if(buckets[indexBucket].size()>0 && countElement!=buckets[indexBucket].size()){
                    for(int j=0;j<buckets[indexBucket].size();j++){
                        objElement = buckets[indexBucket].getAt(j);
                        countElement++;
                        break;
                    }
                    cursor++;
                }else{
                    indexBucket--;
                    countElement=0;
                }
            return objElement;
        }
    }
}
