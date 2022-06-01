package com.personal.treemap;

import com.personal.Iterator;
import com.personal.map.Map;
import com.personal.map.domain.Entry;
import com.personal.map.treemap.TreeMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTreeMap {
    @Test
    public void givenNewTreeMap_whenSize_thenZero() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();

        //When:
        int size = varTreeMap.size();

        //Then:
        assertEquals(size, 0);
    }

    @Test
    public void givenNewTreeMap_whenAddNewElement_thenSizeOne() {

        //Given:
        Map<Integer, String> varTreeMap = new TreeMap<>();

        //When:
        varTreeMap.put(8, "Element08");
        int size = varTreeMap.size();

        //Then:
        assertEquals(size, 1);
    }

    @Test
    public void givenNewTreeMap_whenAddNewTenElement_thenSizeTen() {

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
    public void givenNewTreeMap_whenAddNewTenStringElement_thenSizeTen() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();

        //When:
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");

        int size = varTreeMap.size();

        //Then:
        assertEquals(size, 10);
    }

    @Test
    public void givenTenStringElementsInTreeMap_whenContainsPablo_thenTrue() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");

        //When:
        boolean isPabloPresent = varTreeMap.contains("Pablo");

        //Then:
        assertEquals(isPabloPresent, true);
    }


    @Test
    public void givenTenElementsInTreeMap_whenRemove12_thenSize9() {

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
    public void givenTenStringElementsInTreeMap_whenGetPablo_thenPabloRojas() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");

        //When:
        Entry<String,String > element = varTreeMap.get("Juan");
        String key =element.getKey();
        String value=element.getValue();


        //Then:
        assertEquals(key, "Juan");
        assertEquals(value, "Rojas");
    }
    @Test
    public void givenTenStringElementsInTreeMap_whenGetNull_thenNull() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");

        //When:
        Entry<String,String > element = varTreeMap.get("Laura");


        //Then:
        assertEquals(element, null);
    }
    @Test
    public void givenTenElementsInTreeMap_whenRemove12_thenNotContains12() {

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
        assertEquals(false, isElementPresent);
    }

    @Test
    public void givenTenElementsInTreeMap_whenRemove52_thenSize9() {

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
        assertEquals(false, isElementPresent);
    }

    @Test
    public void givenTenElementsInTreeMap_whenRemove6_thenSize9() {

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
        assertEquals(false, isElementPresent);
    }


    @Test
    public void givenFiveElementsInTreeMap_whenContains13_thenFalse() {

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
        assertEquals(isThereElement, false);
    }

    @Test
    public void givenFiveElementsInTreeMap_whenContains60_thenTrue() {

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
        assertEquals(isThereElement, true);
    }

    @Test
    public void given15ElementsInTreeMap_whenSize_then15() {

        //Given:
        Map<Integer, String> varTreeMap = new TreeMap<Integer, String>();
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
    public void givenTenStringElementsInTreeMap_whenRemoveElement_theElementIsNotPresent() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<String, String>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Juan");

        //Then:
        boolean isPresentElement = varTreeMap.contains("Juan");
        assertEquals(false, isPresentElement);
    }

    @Test
    public void givenTenStringElementsInTreeMap_whenRemoveElement_theSize9() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<String, String>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Hugo");

        //Then:
        int size = varTreeMap.size();
        assertEquals(9, size);
    }

    @Test
    public void givenTenStringElementsInTreeMap_whenNotInsertElementDuplicated_theSize10() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<String, String>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.put("Rosa", "Jimenez1");

        //Then:
        int size = varTreeMap.size();
        assertEquals(10, size);
    }

    @Test
    public void givenTenStringElementsInTreeMap_whenIterate_then10Elements() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<String, String>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");

        int count = 0;

        //When:
        Iterator<String> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        assertEquals(count, size);
    }

    @Test
    public void givenTenStringElementsInTreeMap_whenRemoveElement_thenIterate9Element() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<String, String>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");

        int count = 0;

        //When:
        varTreeMap.remove("Hugo");

        Iterator<String> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        assertEquals(count, size);
    }

    @Test
    public void givenTenStringElementsInTreeMap_whenRemoveElement_theNotContainsElement() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<String, String>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Hugo");
        int count = 0;
        Iterator<String> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Hugo");
        assertEquals(count, size);
        assertEquals(isPresentElement, false);
    }

    @Test
    public void givenTenStringElementsInTreeMap_whenRemoveJuan_theNotContainsJuan() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<String, String>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Juan");
        int count = 0;
        Iterator<String> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Juan");
        assertEquals(count, size);
        assertEquals(isPresentElement, false);
    }

    @Test
    public void givenTenStringElementsInTreeMap_whenRemoveJulieta_theNotContainsJulieta() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<String, String>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Julieta");
        int count = 0;
        Iterator<String> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Julieta");
        assertEquals(count, size);
        assertEquals(isPresentElement, false);
    }

    @Test
    public void givenTenStringElementsInTreeMap_whenRemoveMaria_theNotContainsMaria() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<String, String>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Maria");
        int count = 0;
        Iterator<String> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Maria");
        assertEquals(count, size);
        assertEquals(isPresentElement, false);
    }

    @Test
    public void givenTenStringElementsInTreeMap_whenRemoveAna_theNotContainsAna() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<String, String>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Ana");
        int count = 0;
        Iterator<String> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Ana");
        assertEquals(count, size);
        assertEquals(isPresentElement, false);
    }

    @Test
    public void givenTenStringElementsInTreeMap_whenRemoveRosa_theNotContainsRosa() {

        //Given:
        Map<String, String> varTreeMap = new TreeMap<String, String>();
        varTreeMap.put("Juan", "Rojas");
        varTreeMap.put("Alejandra", "Mejia");
        varTreeMap.put("Maria", "Lopez");
        varTreeMap.put("Ana", "Martinez");
        varTreeMap.put("Julieta", "Alvarez");
        varTreeMap.put("Rosa", "Jimenez");
        varTreeMap.put("Pedro", "Rosas");
        varTreeMap.put("Pablo", "Ramirez");
        varTreeMap.put("Hugo", "Lugo");
        varTreeMap.put("Hector", "Morales");


        //When:
        varTreeMap.remove("Rosa");
        int count = 0;
        Iterator<String> iterator = varTreeMap.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        //Then:
        int size = varTreeMap.size();
        boolean isPresentElement = varTreeMap.contains("Rosa");
        assertEquals(count, size);
        assertEquals(isPresentElement, false);
    }

}
