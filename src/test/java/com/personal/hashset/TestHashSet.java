package com.personal.hashset;

import com.personal.Iterator;
import com.personal.set.Set;
import com.personal.set.hashset.HashSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TestHashSet {
    @Test
     void givenNewHashSet_whenSize_thenZero() {

        //Given:
        Set<String> arrHashSet = new HashSet<>();

        //When:
        int size = arrHashSet.size();

        //Then:
        assertEquals(0,size);
    }
    @Test
     void givenNewHashSet_whenAdd_thenSizeOne() {

        //Given:
        Set<String> arrHashSet = new HashSet<>();

        //When:
        arrHashSet.add("Element1");

        //Then:
        int size = arrHashSet.size();
        assertEquals(1,size);
    }
    @Test
     void givenAnElementInHashSet_whenAddEqualElement_thenSizeOne() {

        //Given:
        Set<String> arrHashSet = new HashSet<>();
        arrHashSet.add("Element1");

        //When:
        arrHashSet.add("Element1");

        //Then:
        int size = arrHashSet.size();
        assertEquals(1,size);
    }
    @Test
     void givenTwoElementsInHashSet_whenRemoveOne_thenSizeOne() {

        //Given:
        Set<String> arrHashSet = new HashSet<>();
        arrHashSet.add("Element1");
        arrHashSet.add("Element2");

        //When:
        arrHashSet.remove("Element1");

        //Then:
        int size = arrHashSet.size();
        assertEquals(1,size);
    }
    @Test
     void givenFourElementsInHashSet_whenRemoveTow_thenSizeTwo() {

        //Given:
        Set<String> arrHashSet = new HashSet<>();
        arrHashSet.add("Elements1");
        arrHashSet.add("Elements2");
        arrHashSet.add("Elements3");
        arrHashSet.add("Elements4");

        //When:
        arrHashSet.remove("Elements1");
        arrHashSet.remove("Elements2");

        //Then:
        int size = arrHashSet.size();
        assertEquals(2,size);
    }
    @Test
     void givenFourElementsInHashSet_whenRemoveAll_thenSizeZero() {

        //Given:
        Set<String> arrHashSet = new HashSet<>();
        arrHashSet.add("Elements1");
        arrHashSet.add("Elements2");
        arrHashSet.add("Elements3");
        arrHashSet.add("Elements4");

        //When:
        arrHashSet.removeAll();

        //Then:
        int size = arrHashSet.size();
        assertEquals(0,size);
    }
    @Test
     void givenFortyElementsInHashSet_whenSize_thenSizeForty() {

        //Given:
        Set<String> arrHashSet = new HashSet<>();
        for (int i = 0; i < 40; i++) {
            arrHashSet.add("Element " + i);
        }

        //When:
        int size = arrHashSet.size();

        //Then:
        for (int i = 0; i < 40; i++) {
            boolean isPresent= arrHashSet.contains("Element " + i);
            assertTrue(isPresent);
        }
        assertEquals(40,size);
    }
    @Test
     void givenAnElementInHashSet_whenContainsElement1_thenTrue() {

        //Given:
        Set<String> arrHashSet = new HashSet<>();
        arrHashSet.add("Element1");

        //When:
        boolean isElementPresent = arrHashSet.contains("Element1");

        //Then:
        assertTrue(isElementPresent);
    }
    @Test
     void givenAnElementInHashSet_whenNotContainsElement1_thenFalse() {

        //Given:
        Set<String> arrHashSet = new HashSet<>();
        arrHashSet.add("Element1");

        //When:
        boolean isElementPresent = arrHashSet.contains("Element01");

        //Then:
        assertFalse(isElementPresent);
    }
    @Test
     void givenElementsInHashSet_whenIterator_thenGetValuesElement1Element2() {

        //Given:
        Set<String> arrHashSet = new HashSet<>();
        arrHashSet.add("Element1");
        arrHashSet.add("Element2");

        //When:
        Iterator<String> iteratorHashSet= arrHashSet.iterator();

        //Then:
        iteratorHashSet.hasNext();
        String strIterator=iteratorHashSet.next();
        assertEquals("Element1",strIterator);
        iteratorHashSet.hasNext();
        strIterator=iteratorHashSet.next();
        assertEquals("Element2",strIterator);

    }
    @Test
     void givenFortyElementsInHashSet_whenIterator_thenGetSize40() {

        //Given:
        Set<String> arrHashSet = new HashSet<>();
        for (int i = 0; i < 40; i++) {
            arrHashSet.add("Elements " + i);
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
