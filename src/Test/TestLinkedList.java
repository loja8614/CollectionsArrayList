package Test;

import com.personal.Iterator;
import com.personal.LinkedList;
import junit.framework.TestCase;

public class TestLinkedList extends TestCase {
    private LinkedList<String> lnkList;
    private Iterator<String> iterator;

    public void tests (){
        lnkList=new LinkedList<String>();
    }
    public void testAdd(){
        tests();
        lnkList.add("Element01");
        lnkList.add("Element02");
        assertTrue(lnkList.size()==2);
    }
    public void  testInsert(){
        tests();
        lnkList.insert(0,"Element00");
        assertTrue(lnkList.size()==1 && lnkList.getAt(0).equals("Element00"));

    }
    public void testGetAt(){
        tests();
        lnkList.add("Element01");
        assertTrue(lnkList.getAt(0).equals("Element01"));
    }

    public void testSetAt(){
        tests();
        lnkList.add("Element01");
        lnkList.setAt(0,"Element01WithChange");
        assertTrue(lnkList.getAt(0).equals("Element01WithChange"));
    }

    public void testRemove(){
        tests();
        lnkList.add("Element01");
        lnkList.add("Element02");
        lnkList.remove(0);
        assertTrue(lnkList.size()==1 && lnkList.getAt(0).equals("Element02"));

    }
    public void testRemoveAll(){
        tests();
        lnkList.add("Element01");
        lnkList.add("Element02");
        lnkList.removeAll();
        assertTrue(lnkList.size()==0);

    }

    public void testSize(){
        tests();
        lnkList.add("Element01");
        lnkList.add("Element02");
        assertTrue(lnkList.size()==2);

    }

    public void testIterator(){
        tests();
        lnkList.add("Element01");
        lnkList.add("Element02");

        LinkedList<String> lnkListTest = new LinkedList<String>();


        Iterator iter = lnkList.iterator();

        while (iter.hasNext()){
            lnkListTest.add(iter.next().toString());
        }
        assertTrue(lnkListTest.getAt(0).equals("Element01") && lnkListTest.getAt(1).equals("Element02"));
    }



}
