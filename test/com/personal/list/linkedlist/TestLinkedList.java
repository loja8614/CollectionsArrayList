package com.personal.list.linkedlist;

import com.personal.list.Iterator;
import com.personal.list.ReverseIterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLinkedList  {

    @Test
    public void givenNewLinkedList_whenSize_thenZero() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();

        //When:
        int size = lnkList.size();

        //Then:
        assertEquals(0, size);
    }
    @Test
    public void givenNewLinkedList_whenAddNewElement_thenSizeOne() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();

        //When:
        lnkList.add("NewElement0");
        int size = lnkList.size();

        //Then:
        assertEquals(1, size);
    }
    @Test
    public void givenNewLinkedList_whenAddNewElement_thenGetValueNewElement0() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();

        //When:
        lnkList.add("NewElement0");

        //Then:
        String strValueElement = lnkList.getAt(0);
        assertEquals(strValueElement, "NewElement0");
    }
    @Test
    public void givenElementInLinkedList_whenAddNewElement_thenGetValueElement() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("Element");

        //When:
        String strElement=lnkList.getAt(0);

        //Then:
        assertEquals(strElement, "Element");
    }
    @Test
    public void givenLinkedList_whenAddNextElement_thenSizeTwo() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();


        //When:
        lnkList.add("NewElement0");
        lnkList.add("NextElement2");

        //Then:
        int size=lnkList.size();
        assertEquals(size, 2);
    }
    @Test
    public void givenLinkedList_whenInsertNewElement_thenSizeOne() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();

        //When:
        lnkList.insert(0,"NewElement0");

        //Then:
        int size=lnkList.size();
        assertEquals(size, 1);
    }
    @Test
    public void givenLinkedList_whenInsertNewElement_thenGetValueIndexZeroNewElement0() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();

        //When:
        lnkList.insert(0,"NewElement0");

        //Then:
        String strElement=lnkList.getAt(0);
        assertEquals(strElement, "NewElement0");
    }
    @Test
    public void givenElementsInLinkedList_whenInsertNewElementIndexOne_thenGetValueIndexOneCopyElement01() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement0");
        lnkList.add("NewElement1");

        //When:
        lnkList.insert(1,"CopyElement01");

        //Then:
        String strElement=lnkList.getAt(1);
        assertEquals(strElement, "CopyElement01");
    }
    @Test
    public void givenElementsInLinkedList_whenInsertNewElementIndexOne_thenGetValueNextIndexNewElement1() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement0");
        lnkList.add("NewElement1");

        //When:
        lnkList.insert(1,"CopyElement01");

        //Then:
        String strElement=lnkList.getAt(lnkList.size());
        assertEquals(strElement, "NewElement1");
    }
    @Test
    public void givenLinkedList_whenInsertNewLastElement_thenGetValueLastIndexLastElement() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement");

        //When:
        lnkList.insert(0,"LastElement");

        //Then:
        String strElement=lnkList.getAt(0);
        assertEquals(strElement, "LastElement");
    }
    @Test
    public void givenElementsInLinkedList_whenSetNewValueIndexZero_thenGetValueIndexZeroElementWithChanges() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement0");
        lnkList.add("NewElement1");

        //When:
        lnkList.setAt(0,"ElementWithChanges");

        //Then:
        String strElement=lnkList.getAt(0);
        assertEquals(strElement, "ElementWithChanges");
    }

    @Test
    public void givenOneElementInLinkedList_whenRemoveElement_thenSizeZero() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement");

        //When:
        lnkList.remove(0);

        //Then:
        int size = lnkList.size();
        assertEquals(size, 0);
    }
    @Test
    public void givenTwoElementsInLinkedList_whenRemoveElementIndex1_thenSizeOne() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement0");
        lnkList.add("NewElement1");

        //When:
        lnkList.remove(1);

        //Then:
        int size = lnkList.size();
        assertEquals(size, 1);
    }
    @Test
    public void givenFourElementsInLinkedList_whenRemoveElementIndex2_thenGetValueNewElement3() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement0");
        lnkList.add("NewElement1");
        lnkList.add("NewElement2");
        lnkList.add("NewElement3");

        //When:
        lnkList.remove(2);

        //Then:
        String elementIndex2=lnkList.getAt(3);
        assertEquals(elementIndex2, "NewElement3");
    }

    @Test
    public void givenFourElementsInLinkedList_whenRemoveElementIndex0_thenGetValueIndex0NewElement1() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement0");
        lnkList.add("NewElement1");
        lnkList.add("NewElement2");
        lnkList.add("NewElement3");

        //When:
        lnkList.remove(0);

        //Then:
        String elementIndex0=lnkList.getAt(0);
        assertEquals(elementIndex0, "NewElement1");
    }

    @Test
    public void givenFourElementsInLinkedList_whenRemoveLastElement_thenGetValueLastNewElement2() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement0");
        lnkList.add("NewElement1");
        lnkList.add("NewElement2");
        lnkList.add("NewElement3");

        //When:
        lnkList.remove(3);

        //Then:
        String elementIndex2=lnkList.getAt(2);
        assertEquals(elementIndex2, "NewElement2");
    }
    @Test
    public void givenFourElementsInLinkedList_whenRemoveIndex2Element_thenGetValueIndex2NewElement3() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement0");
        lnkList.add("NewElement1");
        lnkList.add("NewElement2");
        lnkList.add("NewElement3");

        //When:
        lnkList.remove(2);

        //Then:
        String elementIndex2=lnkList.getAt(2);
        assertEquals(elementIndex2, "NewElement3");
    }

    @Test
    public void givenFourElementsInLinkedList_whenRemoveAll_thenSizeZero() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement0");
        lnkList.add("NewElement1");
        lnkList.add("NewElement2");
        lnkList.add("NewElement3");

        //When:
        lnkList.removeAll();

        //Then:
        int size =lnkList.size();
        assertEquals(size, 0);
    }
    @Test
    public void givenTwoElementsInLinked_whenIterate_thenGetValuesNewElement0NewElement1() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement0");
        lnkList.add("NewElement1");


        //When:
        Iterator<String> varIterator = lnkList.iterator();

        //Then:
        varIterator.hasNext();
        assertEquals(varIterator.next(), "NewElement0");

        varIterator.hasNext();
        assertEquals(varIterator.next(), "NewElement1");

    }
    @Test
    public void givenTwoElementsInLinked_whenReverseIterate_thenGetValuesNewElement1NewElement0() {

        //Given:
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("NewElement0");
        lnkList.add("NewElement1");


        //When:
        ReverseIterator<String> varRevIterator = (ReverseIterator) lnkList.iterator();

        //Then:
        varRevIterator.hasPrev();
        assertEquals(varRevIterator.previous(), "NewElement1");

        varRevIterator.hasPrev();
        assertEquals(varRevIterator.previous(), "NewElement0");

    }
}
