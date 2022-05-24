package com.personal.treeset;

import com.personal.Iterator;
import com.personal.set.Set;
import com.personal.set.treeset.TreeSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class TestTreeSet {
    @Test
    public void givenNewTreeSet_whenSize_thenZero() {

        //Given:
        Set<String> varTreeSet = new TreeSet<String>();

        //When:
        int size = varTreeSet.size();

        //Then:
        assertEquals(size, 0);
    }

    @Test
    public void givenNewTreeSet_whenAddNewElement_thenSizeOne() {

        //Given:
        Set<Integer> varTreeSet = new TreeSet<Integer>();

        //When:
        varTreeSet.add(8);
        int size = varTreeSet.size();

        //Then:
        assertEquals(size, 1);
    }

    @Test
    public void givenNewTreeSet_whenAddNewTenElement_thenSizeTen() {

        //Given:
        Set<Integer> varTreeSet = new TreeSet<Integer>();

        //When:
        varTreeSet.add(47);
        varTreeSet.add(60);
        varTreeSet.add(22);
        varTreeSet.add(12);
        varTreeSet.add(6);
        varTreeSet.add(13);
        varTreeSet.add(41);
        varTreeSet.add(20);
        varTreeSet.add(52);
        varTreeSet.add(16);
        int size = varTreeSet.size();

        //Then:
        assertEquals(size, 10);
    }

    @Test
    public void givenNewTreeSet_whenAddNewTenStringElement_thenSizeTen() {

        //Given:
        Set<String> varTreeSet = new TreeSet<String>();

        //When:
        varTreeSet.add("Juan");
        varTreeSet.add("Alejandra");
        varTreeSet.add("Maria");
        varTreeSet.add("Ana");
        varTreeSet.add("Julieta");
        varTreeSet.add("Rosa");
        varTreeSet.add("Pedro");
        varTreeSet.add("Pablo");
        varTreeSet.add("Hugo");
        varTreeSet.add("Hector");

        int size = varTreeSet.size();

        //Then:
        assertEquals(size, 10);
    }

    @Test
    public void givenTenStringElementsInTreeSet_whenContainsPablo_thenTrue() {

        //Given:
        Set<String> varTreeSet = new TreeSet<String>();
        varTreeSet.add("Juan");
        varTreeSet.add("Alejandra");
        varTreeSet.add("Maria");
        varTreeSet.add("Ana");
        varTreeSet.add("Julieta");
        varTreeSet.add("Rosa");
        varTreeSet.add("Pedro");
        varTreeSet.add("Pablo");
        varTreeSet.add("Hugo");
        varTreeSet.add("Hector");

        //When:
        boolean isPabloPresent = varTreeSet.contains("Pablo");

        //Then:
        assertEquals(isPabloPresent, true);
    }


    @Test
    public void givenTenElementsInTreeSet_whenRemove12_thenSize9() {

        //Given:
        Set<Integer> varTreeSet = new TreeSet<Integer>();
        varTreeSet.add(47);
        varTreeSet.add(60);
        varTreeSet.add(22);
        varTreeSet.add(12);
        varTreeSet.add(6);
        varTreeSet.add(13);
        varTreeSet.add(41);
        varTreeSet.add(20);
        varTreeSet.add(52);
        varTreeSet.add(16);

        //When:
        varTreeSet.remove(12);

        //Then:
        int size = varTreeSet.size();
        assertEquals(size, 9);
    }

    @Test
    public void givenTenElementsInTreeSet_whenRemove12_thenNotContains12() {

        //Given:
        Set<Integer> varTreeSet = new TreeSet<Integer>();
        varTreeSet.add(47);
        varTreeSet.add(60);
        varTreeSet.add(22);
        varTreeSet.add(12);
        varTreeSet.add(6);
        varTreeSet.add(13);
        varTreeSet.add(41);
        varTreeSet.add(20);
        varTreeSet.add(52);
        varTreeSet.add(16);

        //When:
        varTreeSet.remove(12);
        boolean isElementPresent = varTreeSet.contains(12);

        //Then:
        assertEquals(false,isElementPresent);
    }

    @Test
    public void givenTenElementsInTreeSet_whenRemove52_thenSize9() {

        //Given:
        Set<Integer> varTreeSet = new TreeSet<Integer>();
        varTreeSet.add(47);
        varTreeSet.add(60);
        varTreeSet.add(22);
        varTreeSet.add(12);
        varTreeSet.add(6);
        varTreeSet.add(13);
        varTreeSet.add(41);
        varTreeSet.add(20);
        varTreeSet.add(52);
        varTreeSet.add(16);

        //When:
        varTreeSet.remove(52);

        //Then:
        int size = varTreeSet.size();
        boolean isElementPresent = varTreeSet.contains(52);
        assertEquals(size, 9);
        assertEquals(false,isElementPresent);
    }

    @Test
    public void givenTenElementsInTreeSet_whenRemove6_thenSize9() {

        //Given:
        Set<Integer> varTreeSet = new TreeSet<Integer>();
        varTreeSet.add(47);
        varTreeSet.add(60);
        varTreeSet.add(22);
        varTreeSet.add(12);
        varTreeSet.add(6);
        varTreeSet.add(13);
        varTreeSet.add(41);
        varTreeSet.add(20);
        varTreeSet.add(52);
        varTreeSet.add(16);

        //When:
        varTreeSet.remove(6);

        //Then:
        int size = varTreeSet.size();
        boolean isElementPresent = varTreeSet.contains(6);
        assertEquals(size, 9);
        assertEquals(false,isElementPresent);
    }

    @Test
    public void givenFiveElementsInTreeSet_whenRemoveAll_thenSizeZero() {

        //Given:
        Set<Integer> varTreeSet = new TreeSet<Integer>();
        varTreeSet.add(47);
        varTreeSet.add(60);
        varTreeSet.add(22);
        varTreeSet.add(12);
        varTreeSet.add(6);

        //When:
        varTreeSet.removeAll();

        //Then:
        int size = varTreeSet.size();
        assertEquals(size, 0);
    }

    @Test
    public void givenFiveElementsInTreeSet_whenContains13_thenFalse() {

        //Given:
        Set<Integer> varTreeSet = new TreeSet<Integer>();
        varTreeSet.add(47);
        varTreeSet.add(60);
        varTreeSet.add(22);
        varTreeSet.add(12);
        varTreeSet.add(6);

        //When:
        boolean isThereElement = varTreeSet.contains(13);

        //Then:
        assertEquals(isThereElement, false);
    }

    @Test
    public void givenFiveElementsInTreeSet_whenContains60_thenTrue() {

        //Given:
        Set<Integer> varTreeSet = new TreeSet<Integer>();
        varTreeSet.add(47);
        varTreeSet.add(60);
        varTreeSet.add(22);
        varTreeSet.add(12);
        varTreeSet.add(6);

        //When:
        boolean isThereElement = varTreeSet.contains(60);

        //Then:
        assertEquals(isThereElement, true);
    }

    @Test
    public void given15ElementsInTreeSet_whenSize_then15() {

        //Given:
        Set<Integer> varTreeSet = new TreeSet<Integer>();
        varTreeSet.add(47);
        varTreeSet.add(60);
        varTreeSet.add(22);
        varTreeSet.add(12);
        varTreeSet.add(6);
        varTreeSet.add(13);
        varTreeSet.add(41);
        varTreeSet.add(20);
        varTreeSet.add(52);
        varTreeSet.add(16);
        varTreeSet.add(38);
        varTreeSet.add(48);
        varTreeSet.add(35);
        varTreeSet.add(68);
        varTreeSet.add(90);

        //When:
        int size = varTreeSet.size();

        //Then:
        assertEquals(size, 15);
    }

    @Test
    public void givenTenStringElementsInTreeSet_whenRemoveElement_theElementIsNotPresent() {

        //Given:
        Set<String> varTreeSet = new TreeSet<String>();
        varTreeSet.add("Juan");
        varTreeSet.add("Alejandra");
        varTreeSet.add("Ana");
        varTreeSet.add("Hugo");
        varTreeSet.add("Hector");


        //When:
        varTreeSet.remove("Juan");

        //Then:
        boolean isPresentElement = varTreeSet.contains("Juan");
        assertEquals(false, isPresentElement);
    }
    @Test
    public void givenTenStringElementsInTreeSet_whenRemoveElement_theSize9() {

        //Given:
        Set<String> varTreeSet = new TreeSet<String>();
        varTreeSet.add("Juan");
        varTreeSet.add("Alejandra");
        varTreeSet.add("Maria");
        varTreeSet.add("Ana");
        varTreeSet.add("Julieta");
        varTreeSet.add("Rosa");
        varTreeSet.add("Pedro");
        varTreeSet.add("Pablo");
        varTreeSet.add("Hugo");
        varTreeSet.add("Hector");


        //When:
        varTreeSet.remove("Hugo");

        //Then:
        int size = varTreeSet.size();
        assertEquals(9, size);
    }

    @Test
    public void givenTenStringElementsInTreeSet_whenNotInsertElementDuplicated_theSize10() {

        //Given:
        Set<String> varTreeSet = new TreeSet<String>();
        varTreeSet.add("Juan");
        varTreeSet.add("Alejandra");
        varTreeSet.add("Maria");
        varTreeSet.add("Ana");
        varTreeSet.add("Julieta");
        varTreeSet.add("Rosa");
        varTreeSet.add("Pedro");
        varTreeSet.add("Pablo");
        varTreeSet.add("Hugo");
        varTreeSet.add("Hector");


        //When:
        varTreeSet.add("Rosa");

        //Then:
        int size = varTreeSet.size();
        assertEquals(10, size);
    }

    @Test
    public void givenTenStringElementsInTreeSet_whenIterate_then10Elements() {

        //Given:
        Set<String> varTreeSet = new TreeSet<String>();
        varTreeSet.add("Juan");
        varTreeSet.add("Alejandra");
        varTreeSet.add("Maria");
        varTreeSet.add("Ana");
        varTreeSet.add("Julieta");
        varTreeSet.add("Rosa");
        varTreeSet.add("Pedro");
        varTreeSet.add("Pablo");
        varTreeSet.add("Hugo");
        varTreeSet.add("Hector");

        int count = 0;

        //When:
        Iterator<String> iterator = varTreeSet.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeSet.size();
        assertEquals(count, size);
    }

}
