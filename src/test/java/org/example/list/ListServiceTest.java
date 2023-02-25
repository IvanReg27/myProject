package org.example.list;

import org.example.DefaultTest;
import org.example.lists.ListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ListServiceTest extends DefaultTest {

    ListService<String> arrayBasedService;
    ListService<String> linkedListBasedService;

    @BeforeEach
    public void populateArrays() {
        System.out.println("Initializing array and linked list by put 1M records inside");
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 5000; i++) {
            String uuid = UUID.randomUUID().toString();
            arrayList.add(uuid);
            linkedList.add(uuid);
        }
        System.out.println("Initialization complete");
        arrayBasedService = new ListService<>(arrayList);
        linkedListBasedService = new ListService<>(linkedList);
    }

    @Test
    public void compareGetElementFroTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GetElementFroTheMiddle 5K times-----------");
        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFroTheMiddle(arrayBasedService.getSize() / 2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFroTheMiddle(arrayBasedService.getSize() / 2);

        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareGetElementFroTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GetElementFroTheEnd 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheEnd(arrayBasedService.getSize());
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheEnd(arrayBasedService.getSize());
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }

    @Test
    public void compareGetElementFromTheBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------GetElementFromTheBegging 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.getElementFromTheBegging(1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.getElementFromTheBegging(1);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }

    @Test
    public void compareСheckContainsElement() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        String uuid ="";
        System.out.println("-----------СheckContainsElement 1K times-----------");

        for (int i = 0; i < 1000; i++) {
            uuid = UUID.randomUUID().toString();
            totalTimeArray = totalTimeArray + arrayBasedService.checkContainsElement(uuid);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.checkContainsElement(uuid);
        }
        System.out.println("ARRAYLIST: " + totalTimeArray / 1000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1000f);
    }

    @Test
    public void compareAddElementFromBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------AddElementFromBegging 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementFromBegging("yes",1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementFromBegging("yes",1);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }

    @Test
    public void compareAddElementToTheMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------AddElementToTheMiddle 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheMiddle("yes",arrayBasedService.getSize()/2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheMiddle("yes",arrayBasedService.getSize()/2);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareAddElementToTheEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------AddElementToTheEnd 1M times-----------");

        for (int i = 0; i < 1_000_000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.addElementToTheEnd("yes",arrayBasedService.getSize()-1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.addElementToTheEnd("yes",arrayBasedService.getSize()-1);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 1_000_000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 1_000_000f);
    }

    @Test
    public void compareDeleteElementFromBegging() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------AddElementToTheEnd 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromBegging(1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromBegging(1);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareDeleteElementFromMiddle() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DeleteElementFromMiddle 5К times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromMiddle(arrayBasedService.getSize()/2);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromMiddle(arrayBasedService.getSize()/2);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareDeleteElementFromEnd() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        System.out.println("-----------DeleteElementFromEnd 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromEnd(arrayBasedService.getSize()-1);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromEnd(linkedListBasedService.getSize()-1);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }

    @Test
    public void compareDeleteElementFromList() {
        long totalTimeArray = 0;
        long totalTimeLinked = 0;
        String uuid= "";
        System.out.println("-----------DeleteElementFromList 5K times-----------");

        for (int i = 0; i < 5000; i++) {
            uuid = UUID.randomUUID().toString();
            totalTimeArray = totalTimeArray + arrayBasedService.deleteElementFromList(uuid);
            totalTimeLinked = totalTimeLinked + linkedListBasedService.deleteElementFromList(uuid);
        }

        System.out.println("ARRAYLIST: " + totalTimeArray / 5000f);
        System.out.println("LINKEDLIST: " + totalTimeLinked / 5000f);
    }
}