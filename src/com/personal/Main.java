package com.personal;


import com.personal.list.Iterator;
import com.personal.set.Set;
import com.personal.set.hashset.HashSet;

public class Main {

    public static void main(String[] args) {

        Set<String> arrHashSet = new HashSet<String>();
        arrHashSet.add("Elemento1");
        arrHashSet.add("Elemento2");

        //When:
        Iterator<String> iteratorHashSet= arrHashSet.iterator();


        //Then:

        while (iteratorHashSet.hasNext()){
            String strIterator=iteratorHashSet.next();
            System.out.println("strIterator = " + strIterator);
        }
        
    }
}
