package com.personal;


import com.personal.list.Iterator;
import com.personal.list.arraylist.ArrayList;


public class Main {

    public static void main(String[] args) {
/*
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("Elemento 1");
        lnkList.add("Elemento 2");
        lnkList.add("Elemento 3");

        String strVar = lnkList.getAt(2);
        System.out.println("GET AT strVar = " + strVar);

        lnkList.setAt(0,"Elemento con Cambio");
        strVar = lnkList.getAt(0);
        System.out.println("GET AT strVar = " + strVar);

        lnkList.insert(3,"Elemento 4");
        System.out.println("Tamaño despues de Elemento 4" + lnkList.size);

        strVar = lnkList.getAt(3);
        System.out.println("GET AT strVar = " + strVar);


        Iterator listIter = lnkList.iterator();
        while(listIter.hasNext()){
            System.out.println(listIter.next());
        }
        lnkList.remove(2);
        System.out.println("Tamaño despues de borrar indice 2" + lnkList.size);

        lnkList.add("Elemento 3");
        System.out.println("Tamaño despues agregar elemento" + lnkList.size);

        lnkList.removeAll();
        System.out.println("Tamaño despues eliminar todo" + lnkList.size);
*/

        ArrayList lst = new ArrayList();
        lst.add("Elemento1");
        lst.add("Elemento2");
        lst.add("Elemento3");
        lst.add("Elemento4");
        lst.insert(4,"Elemento5");
        lst.setAt(1,"Elemento02Corr");


        Iterator iter = lst.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        /*
        lst.remove(0);
        lst.remove(3);
        lst.removeAll();
        lst.size();

        */

/*
        lst.setAt(1,"Elemento02Corr");
        System.out.println("Elemento del indice 1" + lst.getAt(1)) ;


        lst.remove(0);

        iter = lst.iterator();

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        lst.removeAll();
        System.out.println("Size: " + lst.size());

*/

    }
}
