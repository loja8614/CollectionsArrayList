package com.personal.hashmap;

import com.personal.Iterator;
import com.personal.map.Map;
import com.personal.map.hahsmap.HashMap;
import com.personal.set.hashset.HashSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHashMap {
    @Test
    public void givenNewHashMap_whenSize_thenZero() {

        //Given:
        HashMap<Integer, String> hashMap = new HashMap<>();

        //When:
        int size = hashMap.size();

        //Then:
        assertEquals(0, size);
    }

    @Test
    public void givenNewHashMap_whenPutElement_thenSizeOne() {

        //Given:
        HashMap<String, String> hashMap = new HashMap<>();

        //When:
        hashMap.put("1", "Element01");

        //Then:
        int size = hashMap.size();
        assertEquals(1, size);
    }

    @Test
    public void givenAnElementInHashMap_whenPutEqualElement_thenSizeOne() {

        //Given:
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "Element01");

        //When:
        hashMap.put("1", "Element01");

        //Then:
        int size = hashMap.size();
        assertEquals(1, size);
    }

    @Test
    public void givenTwoElementsInHashMap_whenRemoveOne_thenSizeOne() {

        //Given:
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Element01");
        hashMap.put(2, "Element02");

        //When:
        hashMap.remove(1);

        //Then:
        int size = hashMap.size();
        assertEquals(1, size);
    }

    @Test
    public void givenFourElementsInHashMap_whenRemoveTow_thenSizeTwo() {

        //Given:
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Element01");
        hashMap.put(2, "Element02");
        hashMap.put(3, "Element03");
        hashMap.put(4, "Element04");

        //When:
        hashMap.remove(1);
        hashMap.remove(4);

        //Then:
        int size = hashMap.size();
        assertEquals(2, size);
    }

    @Test
    public void givenAnElementInHashMapwhenContainsElement1_thenTrue() {

        //Given:
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Element01");

        //When:
        boolean isElementPresent = hashMap.contains(1);

        //Then:
        assertEquals(true, isElementPresent);
    }

    @Test
    public void givenAnElementInHashMap_whenNotContainsElement1_thenFalse() {

        //Given:
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Element01");

        //When:
        boolean isElementPresent = hashMap.contains(2);

        //Then:
        assertEquals(false, isElementPresent);
    }

    @Test
    public void givenElementsInHashMap_whenIterator_thenGetValuesElement1Element2() {

        //Given:
        //Given:
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "Element01");
        hashMap.put("2", "Element02");

        //When:
        Iterator<String> iteratorHashSet = hashMap.iterator();

        //Then:
        iteratorHashSet.hasNext();
        String strIterator = iteratorHashSet.next();
        assertEquals("Element01", strIterator);
        iteratorHashSet.hasNext();
        strIterator = iteratorHashSet.next();
        assertEquals("Element02", strIterator);

    }

    @Test
    public void givenFortyElementsInHashMap_whenIterator_thenGetSize40() {

        //Given:
        //Given:
        HashMap<Integer, String> hashMap = new HashMap<>();

        for (int i = 0; i < 40; i++) {
            hashMap.put(i, "Element " + i);
        }
        int count = 0;

        //When:
        Iterator<String> iteratorHashSet = hashMap.iterator();
        while (iteratorHashSet.hasNext()) {
            iteratorHashSet.next();
            count++;
        }

        //Then:
        int size = hashMap.size();

        assertEquals(count, size);
    }

}
