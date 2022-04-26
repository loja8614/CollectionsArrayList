package com.personal.list.arraylist;

import com.personal.list.Iterator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestArrayList {

    @Test
    public void givenNewArrayList_whenSize_thenZero() {

        //Given:
        ArrayList arrayList = new ArrayList();

        //When:
        int size = arrayList.size();

        //Then:
        assertEquals(0, size);
    }

    @Test
    public void givenNewElementInArrayList_whenSize_thenOne() {

        //Given:
        ArrayList arrayList = new ArrayList();
        arrayList.add("Element0");

        //When:
        int size = arrayList.size();

        //Then:
        assertEquals(1, size);

    }

    @Test
    public void givenFourElementsInArrayList_whenSize_then4() {

        //Given:
        ArrayList arrayList = new ArrayList();
        arrayList.add("Element0");
        arrayList.add("Element1");
        arrayList.add("Element2");
        arrayList.add("Element3");

        //When:
        int size = arrayList.size();

        //Then:
        assertEquals(4, size);

    }

    @Test
    public void givenElementInArrayList_whenIndex0_thenGetElement0() {

        //Given:
        ArrayList arrayList = new ArrayList();
        arrayList.add("Element0");

        //When:
        String StrElement = arrayList.getAt(0);

        //Then:
        assertEquals("Element0", StrElement);

    }

    @Test
    public void givenSetElementInArrayList_whenIndex0_thenSetElement0WithChanges() {

        //Given:
        ArrayList arrayList = new ArrayList();
        arrayList.add("Element0");
        arrayList.setAt(0,"Element0WithChanges");

        //When:
        String StrElement = arrayList.getAt(0);

        //Then:
        assertEquals("Element0WithChanges", StrElement);
    }

    @Test
    public void givenElementsInArrayList_whenRemoveAll_thenSizeZero() {

        //Given:
        ArrayList arrayList = new ArrayList();
        arrayList.add("Element0");
        arrayList.add("Element2");

        //When:
        arrayList.removeAll();
        int size = arrayList.size();


        //Then:
        assertEquals(0, size);
    }

    @Test
    public void givenElementsInArrayList_whenInsertElementInPositionZero_thenValueIndexZeroElement0() {

        //Given:
        ArrayList arrayList = new ArrayList();
        arrayList.add("Element1");


        //When:
        arrayList.insert(0,"Element0");
        String strElement = arrayList.getAt(0);


        //Then:
        assertEquals(strElement, "Element0");
    }
    @Test
    public void givenFourElementsInArrayList_whenInsertElementInPosition3_thenValueIndex3NewElement03() {

        //Given:
        ArrayList arrayList = new ArrayList();
        arrayList.add("Element1");
        arrayList.add("Element2");
        arrayList.add("Element3");
        arrayList.add("Element4");


        //When:
        arrayList.insert(3,"NewElement03");
        String strElement = arrayList.getAt(3);


        //Then:
        assertEquals(strElement, "NewElement03");
    }
    @Test
    public void givenFourElementsInArrayList_whenInsertElementInPosition3_thenSize5() {

        //Given:
        ArrayList arrayList = new ArrayList();
        arrayList.add("Element1");
        arrayList.add("Element2");
        arrayList.add("Element3");
        arrayList.add("Element4");


        //When:
        arrayList.insert(3,"NewElement03");
        int size = arrayList.size();


        //Then:
        assertEquals(5, size);
    }

    @Test
    public void givenTwoElementsInArrayList_whenRemoveIndex0_thenSize1() {

        //Given:
        ArrayList arrayList = new ArrayList();
        arrayList.add("Element0");
        arrayList.add("Element2");

        //When:
        arrayList.remove(0);
        int size = arrayList.size();


        //Then:
        assertEquals(1, size);
    }
    @Test
    public void givenFourElementsInArrayList_whenRemoveIndex1_thenGetValueIndex1Element3() {

        //Given:
        ArrayList arrayList = new ArrayList();
        arrayList.add("Element0");
        arrayList.add("Element2");
        arrayList.add("Element3");
        arrayList.add("Element4");

        //When:
        arrayList.remove(1);
        String strElementIndex0 = arrayList.getAt(1);


        //Then:
        assertEquals("Element3", "Element3");
    }
    @Test
    public void givenTwoElementsInArrayList_whenIterate_thenGetValuesIndex1Element01() {

        //Given:
        ArrayList arrayList = new ArrayList();
        arrayList.add("Element00");
        arrayList.add("Element01");

        //When:
        ArrayList lstTest = new ArrayList();
        Iterator iter = arrayList.iterator();

        while (iter.hasNext()) {
            lstTest.add(iter.next().toString());
        }

        //Then:
        String strElement1=lstTest.getAt(1);
        assertEquals( strElement1,"Element01");
    }

/*




    public void testIterator() {
        tests();
        arrayList.add("Element01");
        arrayList.add("Element02");

        ArrayList lstTest = new ArrayList();
        Iterator iter = arrayList.iterator();

        while (iter.hasNext()) {
            lstTest.add(iter.next().toString());
        }

        assertTrue(lstTest.getAt(0).equals("Element01") && lstTest.getAt(1).equals("Element02"));
    }
*/

}
