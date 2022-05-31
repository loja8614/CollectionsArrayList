package com.personal.hashset;

import com.personal.Iterator;
import com.personal.set.Set;
import com.personal.set.hashset.HashSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestHashSet {
    @Test
    public void givenNewHashSet_whenSize_thenZero() {

        //Given:
        Set<String> arrHashSet = new HashSet<String>();

        //When:
        int size = arrHashSet.size();

        //Then:
        assertEquals(0,size);
    }
    @Test
    public void givenNewHashSet_whenAdd_thenSizeOne() {

        //Given:
        Set<String> arrHashSet = new HashSet<String>();

        //When:
        arrHashSet.add("Elemento1");

        //Then:
        int size = arrHashSet.size();
        assertEquals(1,size);
    }
    @Test
    public void givenAnElementInHashSet_whenAddEqualElement_thenSizeOne() {

        //Given:
        Set<String> arrHashSet = new HashSet<String>();
        arrHashSet.add("Elemento1");

        //When:
        arrHashSet.add("Elemento1");

        //Then:
        int size = arrHashSet.size();
        assertEquals(1,size);
    }
    @Test
    public void givenTwoElementsInHashSet_whenRemoveOne_thenSizeOne() {

        //Given:
        Set<String> arrHashSet = new HashSet<String>();
        arrHashSet.add("Elemento1");
        arrHashSet.add("Elemento2");

        //When:
        arrHashSet.remove("Elemento1");

        //Then:
        int size = arrHashSet.size();
        assertEquals(1,size);
    }
    @Test
    public void givenFourElementsInHashSet_whenRemoveTow_thenSizeTwo() {

        //Given:
        Set<String> arrHashSet = new HashSet<String>();
        arrHashSet.add("Elemento1");
        arrHashSet.add("Elemento2");
        arrHashSet.add("Elemento3");
        arrHashSet.add("Elemento4");

        //When:
        arrHashSet.remove("Elemento1");
        arrHashSet.remove("Elemento2");

        //Then:
        int size = arrHashSet.size();
        assertEquals(2,size);
    }
    @Test
    public void givenFourElementsInHashSet_whenRemoveAll_thenSizeZero() {

        //Given:
        Set<String> arrHashSet = new HashSet<String>();
        arrHashSet.add("Elemento1");
        arrHashSet.add("Elemento2");
        arrHashSet.add("Elemento3");
        arrHashSet.add("Elemento4");

        //When:
        arrHashSet.removeAll();

        //Then:
        int size = arrHashSet.size();
        assertEquals(0,size);
    }
    @Test
    public void givenFortyElementsInHashSet_whenSize_thenSizeForty() {

        //Given:
        Set<String> arrHashSet = new HashSet<String>();
        for (int i = 0; i < 40; i++) {
            arrHashSet.add("Element " + i);
        }

        //When:
        int size = arrHashSet.size();

        //Then:
        for (int i = 0; i < 40; i++) {
            boolean isPresent= arrHashSet.contains("Element " + i);
            assertEquals(isPresent,true);
        }
        assertEquals(40,size);
    }
    @Test
    public void givenAnElementInHashSet_whenContainsElement1_thenTrue() {

        //Given:
        Set<String> arrHashSet = new HashSet<String>();
        arrHashSet.add("Element1");

        //When:
        boolean isElementPresent = arrHashSet.contains("Element1");

        //Then:
        assertEquals(true,isElementPresent);
    }
    @Test
    public void givenAnElementInHashSet_whenNotContainsElement1_thenFalse() {

        //Given:
        Set<String> arrHashSet = new HashSet<String>();
        arrHashSet.add("Element1");

        //When:
        boolean isElementPresent = arrHashSet.contains("Elemento1");

        //Then:
        assertEquals(false,isElementPresent);
    }
    @Test
    public void givenElementsInHashSet_whenIterator_thenGetValuesElement1Element2() {

        //Given:
        Set<String> arrHashSet = new HashSet<String>();
        arrHashSet.add("Elemento1");
        arrHashSet.add("Elemento2");

        //When:
        Iterator<String> iteratorHashSet= arrHashSet.iterator();

        //Then:
        iteratorHashSet.hasNext();
        String strIterator=iteratorHashSet.next();
        assertEquals("Elemento1",strIterator);
        iteratorHashSet.hasNext();
        strIterator=iteratorHashSet.next();
        assertEquals("Elemento2",strIterator);

    }
    @Test
    public void givenFortyElementsInHashSet_whenIterator_thenGetSize40() {

        //Given:
        Set<String> arrHashSet = new HashSet<String>();
        for (int i = 0; i < 40; i++) {
            arrHashSet.add("Elemento " + i);
        }
        int count=0;

        //When:
        Iterator<String> iteratorHashSet= arrHashSet.iterator();
        while (iteratorHashSet.hasNext()){
            iteratorHashSet.next();
            count++;
        }

        //Then:
        int size =arrHashSet.size();

        assertEquals(count,size);


    }

}
