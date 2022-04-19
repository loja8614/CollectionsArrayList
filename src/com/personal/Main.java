package com.personal;
//import java.util.LinkedList;
public class Main {

    public static void main(String[] args) {

        ArrayList <String> lst= new ArrayList<String>();
        lst.add("Elemento1");
        lst.add("Elemento2");
        lst.add("Elemento3");
        lst.add("Elemento4");
        lst.insert(4,"Elemento5");
        System.out.println("Elemento del indice 0" + lst.getAt(0)) ;
        Iterator iter = lst.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        lst.setAt(1,"Elemento02Corr");
        System.out.println("Elemento del indice 1" + lst.getAt(1)) ;


        lst.remove(0);

        iter = lst.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        lst.removeAll();
        System.out.println("Size: " + lst.size());

/*
        LinkedList<String> lklist= new LinkedList<String>();
        lklist.add("Elemento LnkList01");
        lklist.insert(1,"Elemento LnkList02");
        //String varString = lklist.getAt(0);
        lklist.setAt(2,"Elemento lnklist03");
        //String varString2 = lklist.getAt(2);
        //lklist.remove(2);
        //lklist.removeAll();

        Iterator iter = new lklist.iterator();


        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        lklist.remove(3);
        System.out.println("tamaño de linked list:" + lklist.size);
        iter = lklist.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

*/

    }
}
