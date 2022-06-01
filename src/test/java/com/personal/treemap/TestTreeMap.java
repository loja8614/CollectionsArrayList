package com.personal.treemap;

import com.personal.Iterator;
import com.personal.map.Map;
import com.personal.map.domain.Entry;
import com.personal.map.treemap.TreeMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTreeMap {
    @Test
    void givenNewTreeMap_whenSize_thenZero() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();

        //When:
        int size = varTreeMap.size();

        //Then:
        assertEquals(size, 0);
    }

    @Test
    void givenNewTreeMap_whenAddNewElement_thenSizeOne() {

        //Given:
        Map<Integer, String> varTreeMap = new TreeMap<>();

        //When:
        varTreeMap.put(8, "Element08");
        int size = varTreeMap.size();

        //Then:
        assertEquals(size, 1);
    }

    @Test
    void givenNewTreeMap_whenAddNewTenElement_thenSizeTen() {

        //Given:
        Map<Integer, String> varTreeMap = new TreeMap<>();

        //When:
        varTreeMap.put(47, "Element A");
        varTreeMap.put(60, "Element B");
        varTreeMap.put(22, "Element C");
        varTreeMap.put(12, "Element D");
        varTreeMap.put(6, "Element E");
        varTreeMap.put(13, "Element F");
        varTreeMap.put(41, "Element G");
        varTreeMap.put(20, "Element H");
        varTreeMap.put(52, "Element I");
        varTreeMap.put(16, "Element J");
        int size = varTreeMap.size();

        //Then:
        assertEquals(size, 10);
    }

    @Test
    void givenNewTreeMap_whenAddNewTenStringElement_thenSizeTen() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();

        //When:
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");

        int size = varTreeMap.size();

        //Then:
        assertEquals(size, 10);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenContainsPablo_thenTrue() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");

        //When:
        boolean isPabloPresent = varTreeMap.contains("Pablo");

        //Then:
        assertTrue(isPabloPresent);
    }


    @Test
    void givenTenElementsInTreeMap_whenRemove12_thenSize9() {

        //Given:
        Map<Integer, String> varTreeMap = new TreeMap<>();
        varTreeMap.put(47, "Element A");
        varTreeMap.put(60, "Element B");
        varTreeMap.put(22, "Element C");
        varTreeMap.put(12, "Element D");
        varTreeMap.put(6, "Element E");
        varTreeMap.put(13, "Element F");
        varTreeMap.put(41, "Element G");
        varTreeMap.put(20, "Element H");
        varTreeMap.put(52, "Element I");
        varTreeMap.put(16, "Element J");

        //When:
        varTreeMap.remove(12);

        //Then:
        int size = varTreeMap.size();
        assertEquals(size, 9);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenGetPablo_thenPabloRojas() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");

        //When:
        String element = varTreeMap.get("Juan");

        //Then:
        assertEquals(element, "Rojas");
    }

    @Test
    void givenTenStringElementsInTreeMap_whenGetNull_thenNull() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");

        //When:
        String element = varTreeMap.get("Laura");


        //Then:
        assertNull(element);
    }

    @Test
    void givenTenElementsInTreeMap_whenRemove12_thenNotContains12() {

        //Given:
        Map<Integer, String> varTreeMap = new TreeMap<>();
        varTreeMap.put(47, "Element A");
        varTreeMap.put(60, "Element B");
        varTreeMap.put(22, "Element C");
        varTreeMap.put(12, "Element D");
        varTreeMap.put(6, "Element E");
        varTreeMap.put(13, "Element F");
        varTreeMap.put(41, "Element G");
        varTreeMap.put(20, "Element H");
        varTreeMap.put(52, "Element I");
        varTreeMap.put(16, "Element J");

        //When:
        varTreeMap.remove(12);
        boolean isElementPresent = varTreeMap.contains(12);

        //Then:
        assertFalse(isElementPresent);
    }

    @Test
    void givenTenElementsInTreeMap_whenRemove52_thenSize9() {

        //Given:
        Map<Integer, String> varTreeMap = new TreeMap<>();
        varTreeMap.put(47, "Element A");
        varTreeMap.put(60, "Element B");
        varTreeMap.put(22, "Element C");
        varTreeMap.put(12, "Element D");
        varTreeMap.put(6, "Element E");
        varTreeMap.put(13, "Element F");
        varTreeMap.put(41, "Element G");
        varTreeMap.put(20, "Element H");
        varTreeMap.put(52, "Element I");
        varTreeMap.put(16, "Element J");

        //When:
        varTreeMap.remove(52);

        //Then:
        int size = varTreeMap.size();
        boolean isElementPresent = varTreeMap.contains(52);
        assertEquals(size, 9);
        assertFalse(isElementPresent);
    }

    @Test
    void givenTenElementsInTreeMap_whenRemove6_thenSize9() {

        //Given:
        Map<Integer, String> varTreeMap = new TreeMap<>();
        varTreeMap.put(47, "Element A");
        varTreeMap.put(60, "Element B");
        varTreeMap.put(22, "Element C");
        varTreeMap.put(12, "Element D");
        varTreeMap.put(6, "Element E");
        varTreeMap.put(13, "Element F");
        varTreeMap.put(41, "Element G");
        varTreeMap.put(20, "Element H");
        varTreeMap.put(52, "Element I");
        varTreeMap.put(16, "Element J");

        //When:
        varTreeMap.remove(6);

        //Then:
        int size = varTreeMap.size();
        boolean isElementPresent = varTreeMap.contains(6);
        assertEquals(size, 9);
        assertFalse(isElementPresent);
    }


    @Test
    void givenFiveElementsInTreeMap_whenContains13_thenFalse() {

        //Given:
        Map<Integer, String> varTreeMap = new TreeMap<>();
        varTreeMap.put(47, "Element A");
        varTreeMap.put(60, "Element B");
        varTreeMap.put(22, "Element C");
        varTreeMap.put(12, "Element D");
        varTreeMap.put(6, "Element E");

        //When:
        boolean isThereElement = varTreeMap.contains(13);

        //Then:
        assertFalse(isThereElement);
    }

    @Test
    void givenFiveElementsInTreeMap_whenContains60_thenTrue() {

        //Given:
        Map<Integer, String> varTreeMap = new TreeMap<>();
        varTreeMap.put(47, "Element A");
        varTreeMap.put(60, "Element B");
        varTreeMap.put(22, "Element C");
        varTreeMap.put(12, "Element D");
        varTreeMap.put(6, "Element E");

        //When:
        boolean isThereElement = varTreeMap.contains(60);

        //Then:
        assertTrue(isThereElement);
    }

    @Test
    void given15ElementsInTreeMap_whenSize_then15() {

        //Given:
        Map<Integer, String> varTreeMap = new TreeMap<>();
        varTreeMap.put(47, "Element A");
        varTreeMap.put(60, "Element B");
        varTreeMap.put(22, "Element C");
        varTreeMap.put(12, "Element D");
        varTreeMap.put(6, "Element E");
        varTreeMap.put(13, "Element F");
        varTreeMap.put(41, "Element G");
        varTreeMap.put(20, "Element H");
        varTreeMap.put(52, "Element I");
        varTreeMap.put(16, "Element J");
        varTreeMap.put(38, "Element K");
        varTreeMap.put(48, "Element L");
        varTreeMap.put(35, "Element M");
        varTreeMap.put(68, "Element N");
        varTreeMap.put(90, "Element O");

        //When:
        int size = varTreeMap.size();

        //Then:
        assertEquals(size, 15);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenRemoveElement_theElementIsNotPresent() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Juan");

        //Then:
        boolean isPresentElement = varTreeMap.contains("Juan");
        assertFalse(isPresentElement);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenRemoveElement_theSize9() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Hugo");

        //Then:
        int size = varTreeMap.size();
        assertEquals(9, size);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenNotInsertElementDuplicated_theSize10() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.put("Rosa", "Jimenez1");

        //Then:
        int size = varTreeMap.size();
        assertEquals(10, size);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenIterate_then10Elements() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");

        int count = 0;

        //When:
        Iterator<Entry<String, String>> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        assertEquals(count, size);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenRemoveElement_thenIterate9Element() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");

        int count = 0;

        //When:
        varTreeMap.remove("Hugo");

        Iterator<Entry<String, String>> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        assertEquals(count, size);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenRemoveElement_theNotContainsElement() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Hugo");
        int count = 0;
        Iterator<Entry<String, String>> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Hugo");
        assertEquals(count, size);
        assertFalse(isPresentElement);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenRemoveJuan_theNotContainsJuan() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Juan");
        int count = 0;
        Iterator<Entry<String, String>> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Juan");
        assertEquals(count, size);
        assertFalse(isPresentElement);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenRemoveJulieta_theNotContainsJulieta() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Julieta");
        int count = 0;
        Iterator<Entry<String, String>> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Julieta");
        assertEquals(count, size);
        assertFalse(isPresentElement);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenRemoveMaria_theNotContainsMaria() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Maria");
        int count = 0;
        Iterator<Entry<String, String>> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Maria");
        assertEquals(count, size);
        assertFalse(isPresentElement);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenRemoveAna_theNotContainsAna() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Ana");
        int count = 0;
        Iterator<Entry<String, String>> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Ana");
        assertEquals(count, size);
        assertFalse(isPresentElement);
    }

    @Test
    void givenTenStringElementsInTreeMap_whenRemoveRosa_theNotContainsRosa() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosa");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Luna");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Rosa");
        int count = 0;
        Iterator<Entry<String, String>> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Rosa");
        assertEquals(count, size);
        assertFalse(isPresentElement);
    }

}
