package Test;

import com.personal.ArrayList;
import com.personal.Iterator;
import junit.framework.TestCase;

public class TestArrayList extends TestCase {
    private ArrayList<String> arrayList ;
    private Iterator iterator;

    public void tests (){
        arrayList=new ArrayList();
    }
    public void testAdd(){
        tests();
        arrayList.add("Element01");
        arrayList.add("Element02");
        assertTrue(arrayList.size()==2);
    }
    public void  testInsert(){
        tests();
        arrayList.insert(0,"Element00");
        assertTrue(arrayList.size()==1 && arrayList.getAt(0).equals("Element00"));

    }
    public void testGetAt(){
        tests();
        arrayList.add("Element01");
        assertTrue(arrayList.getAt(0).equals("Element01"));
    }

    public void testSetAt(){
        tests();
        arrayList.add("Element01");
        arrayList.setAt(0,"Element01WithChange");
        assertTrue(arrayList.getAt(0).equals("Element01WithChange"));
    }

    public void testRemove(){
        tests();
        arrayList.add("Element01");
        arrayList.add("Element02");
        arrayList.remove(0);
        assertTrue(arrayList.size()==1 && arrayList.getAt(0).equals("Element02"));

    }
    public void testRemoveAll(){
        tests();
        arrayList.add("Element01");
        arrayList.add("Element02");
        arrayList.removeAll();
        assertTrue(arrayList.size()==0);

    }

    public void testSize(){
        tests();
        arrayList.add("Element01");
        arrayList.add("Element02");
        assertTrue(arrayList.size()==2);

    }

    public void testIterator(){
        tests();
        arrayList.add("Element01");

        boolean isDifferent=false;
        Iterator iter = arrayList.iterator();

        while (iter.hasNext()){
            if(!iter.next().equals("Element01"))
                isDifferent=true;
        }
        assertTrue(!isDifferent);
    }






}
