package com.personal;


//import java.util.Set;
//import java.util.TreeSet;

import com.personal.set.Set;
import com.personal.set.treeset.TreeSet;

public class Main {

    public static void main(String[] args) {
/*
        Set<String> treeset = new TreeSet<String>();
        treeset.add("Algo");
        treeset.add("Alg2");

        boolean flag = treeset.contains("Algo");
        Iterator<String> iter = treeset.iterator();
        while (iter.hasNext())
            System.out.println(iter.next()
                    + ", ");

    }
*/

        //System.out.println("TEST");
        //Set<String> arr = new TreeSet<String>();

/*
        ejemplo test= new ejemplo();
        test.insert(47);
        test.insert(60);
        test.insert(22);
        test.insert(12);
        test.insert(6);
        test.insert(13);
        test.insert(41);
        test.insert(20);
        test.insert(52);
        test.insert(16);
*/

        Set<Integer> item = new TreeSet<Integer>();
        item.add(47);
        item.add(60);
        item.add(22);
        item.add(12);
        item.add(6);
        item.add(13);
        item.add(41);
        item.add(20);
        item.add(52);
        item.add(16);
        item.remove(12);


        boolean existe = item.contains(12);
        boolean existe2 = item.contains(22);

        Iterator<Integer> iter = item.iterator();
        while (iter.hasNext()){
            Integer i = iter.next();
            System.out.println("i = " + i);
    }

        item.size();


/*
        Set<String> elemento = new TreeSet<String>();
        elemento.add("1");
        elemento.add("2");
        elemento.add("0");
        elemento.add("3");
        elemento.add("6");
        elemento.add("4");
        elemento.add("4");
        elemento.add("9");
        elemento.size();
        elemento.remove("3");
        String node = String.valueOf(elemento.contains("9"));

        TreeSet<String>  ejemplp= new TreeSet<String>();
        for(int i=0;i<40;i++){
            ejemplp.add("Element" + i);
        }

        ejemplp.printTree();

*/

    }

}
