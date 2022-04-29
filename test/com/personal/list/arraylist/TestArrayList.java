package com.personal.list.arraylist;

import com.personal.list.Iterator;
import com.personal.list.ReverseIterator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Element0");

        //When:
        String StrElement = arrayList.getAt(0);

        //Then:
        assertEquals("Element0", StrElement);

    }
    @Test
    public void givenTwoElementInArrayList_whenInsertinIndex0_thenGetIndex0Element00() {

        //Given:
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Element0");
        arrayList.add("Element1");

        //When:
        arrayList.insert(0,"Element00");
        String StrElement = arrayList.getAt(0);

        //Then:
        assertEquals("Element00", StrElement);

    }

    @Test
    public void givenSetElementInArrayList_whenIndex0_thenSetElement0WithChanges() {

        //Given:
        ArrayList<String> arrayList = new ArrayList<String>();
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
        ArrayList<String> arrayList = new ArrayList<String>();
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
        ArrayList<String> arrayList = new ArrayList<String>();
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
        ArrayList<String> arrayList = new ArrayList<String>();
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
        ArrayList<String> arrayList = new ArrayList<String>();
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
        ArrayList<String> arrayList = new ArrayList<String>();
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
        ArrayList<String> arrayList = new ArrayList<String>();
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
    public void givenFourElementsInArrayList_whenRemoveLastIndex_thenGetValueIndexLAstElement3() {

        //Given:
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Element0");
        arrayList.add("Element2");
        arrayList.add("Element3");
        arrayList.add("Element4");

        //When:
        arrayList.remove(3);
        String strElementIndex0 = arrayList.getAt(2);


        //Then:
        assertEquals("Element3", "Element3");
    }
    @Test
    public void givenTwoElementsInArrayList_whenIterate_thenGetValuesIndex1Element01() {

        //Given:
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Element00");
        arrayList.add("Element01");

        //When:
        Iterator varIterator = arrayList.iterator();

        //Then:
        String strElement1=arrayList.getAt(0);
        varIterator.hasNext();
        assertEquals( strElement1,"Element00");

        String strElement2=arrayList.getAt(1);
        varIterator.hasNext();
        assertEquals( strElement2,"Element01");
    }

    @Test
    public void givenTwoElementsInArrayList_whenIterateNext_thenGetValuesIndex1Element00() {

        //Given:
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Element00");


        //When:
        Iterator<String> varIterator = arrayList.iterator();

        //Then:
        varIterator.hasNext();
        String strElement= varIterator.next();
        assertEquals(strElement,"Element00");
    }

    @Test
    public void givenNewElementsInArrayList_whenIndexOutSize_thenSizeZero() {

        //Given:
        ArrayList<String> arrayList = new ArrayList<String>();

        //When:
        arrayList.insert(10,"Elemento0");

        //Then:
        int size=arrayList.size();
        assertEquals( size,0);
    }

    @Test
    public void givenTwoElementsInArrayList_whenIteratePrevious_thenGetValuesIndex1Element01() {

        //Given:
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Element00");
        arrayList.add("Element01");


        //When:
        ReverseIterator<String> varIterator = (ReverseIterator) arrayList.iterator();

        //Then:
        varIterator.hasPrev();
        String strElement= varIterator.previous();
        assertEquals(strElement,"Element01");
    }
}
