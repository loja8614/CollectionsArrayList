package com.personal.hashmap;

import com.personal.Iterator;
import com.personal.map.Map;
import com.personal.map.domain.Entry;
import com.personal.map.hahsmap.HashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestHashMap {
    @Test
    void givenNewHashMap_whenSize_thenZero() {

        //Given:
        Map<Integer, String> hashMap = new HashMap<>();

        //When:
        int size = hashMap.size();

        //Then:
        assertEquals(0, size);
    }

    @Test
     void givenNewHashMap_whenPutElement_thenSizeOne() {

        //Given:
        Map<String, String> hashMap = new HashMap<>();

        //When:
        hashMap.put("1", "Element01");

        //Then:
        int size = hashMap.size();
        assertEquals(1, size);
    }

    @Test
     void givenAnElementInHashMap_whenPutEqualElement_thenSizeOne() {

        //Given:
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "Element01");

        //When:
        hashMap.put("1", "Element01");

        //Then:
        int size = hashMap.size();
        assertEquals(1, size);
    }

    @Test
     void givenTwoElementsInHashMap_whenRemoveOne_thenSizeOne() {

        //Given:
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Element01");
        hashMap.put(2, "Element02");

        //When:
        hashMap.remove(1);

        //Then:
        int size = hashMap.size();
        assertEquals(1, size);
    }

    @Test
     void givenFourElementsInHashMap_whenRemoveTow_thenSizeTwo() {

        //Given:
        Map<Integer, String> hashMap = new HashMap<>();
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
     void givenFourElementsInHashMap_whenGet4_thenElement04() {

        //Given:
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Element01");
        hashMap.put(2, "Element02");
        hashMap.put(3, "Element03");
        hashMap.put(4, "Element04");

        //When:
        String element=hashMap.get(4);


        //Then:
        assertEquals("Element04", element);

    }

    @Test
     void givenFourElementsInHashMap_whenGet5_thenNull() {

        //Given:
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Element01");
        hashMap.put(2, "Element02");
        hashMap.put(3, "Element03");
        hashMap.put(4, "Element04");

        //When:
      String  element=hashMap.get(5);


        //Then:
        assertNull(element);
    }

    @Test
     void givenAnElementInHashMap_whenContainsElement1_thenTrue() {

        //Given:
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Element01");

        //When:
        boolean isElementPresent = hashMap.contains(1);

        //Then:
        assertTrue(isElementPresent);
    }

    @Test
     void givenAnElementInHashMap_whenNotContainsElement1_thenFalse() {

        //Given:
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Element01");

        //When:
        boolean isElementPresent = hashMap.contains(2);

        //Then:
        assertFalse(isElementPresent);
    }

    @Test
     void givenElementsInHashMap_whenIterator_thenGetValuesElement1Element2() {

        //Given:
        //Given:
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "Element01");
        hashMap.put("2", "Element02");

        //When:
        Iterator<Entry<String,String>> iteratorHashSet = hashMap.iterator();

        //Then:
        iteratorHashSet.hasNext();
        String strIterator = iteratorHashSet.next().getValue();
        assertEquals("Element01", strIterator);
        iteratorHashSet.hasNext();
        strIterator = iteratorHashSet.next().getValue();
        assertEquals("Element02", strIterator);

    }

    @Test
     void givenFortyElementsInHashMap_whenIterator_thenGetSize40() {

        //Given:
        //Given:
        Map<Integer, String> hashMap = new HashMap<>();

        for (int i = 0; i < 40; i++) {
            hashMap.put(i, "Element " + i);
        }
        int count = 0;

        //When:
        Iterator<Entry<Integer,String>> iteratorHashSet = hashMap.iterator();
        while (iteratorHashSet.hasNext()) {
            iteratorHashSet.next();
            count++;
        }

        //Then:
        int size = hashMap.size();

        assertEquals(count, size);
    }

}
