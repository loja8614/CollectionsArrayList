package com.personal;


import com.personal.list.Iterator;
import com.personal.set.Set;
import com.personal.set.hashset.HashSet;

public class Main {

    public static void main(String[] args) {

        Set<String> arrHashSet = new HashSet<String>();
        for (int i = 0; i < 40; i++) {
            arrHashSet.add("Elemento " + i);
        }



        Iterator<String> iteratorHashSet = arrHashSet.iterator();
        while (iteratorHashSet.hasNext()){
            String strIterator = iteratorHashSet.next();
            System.out.println("strIterator = " + strIterator);
        }
    }

}
