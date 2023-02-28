package org.example.exceptions;

import java.util.LinkedList;
import java.util.List;

public class Errors extends Throwable {
    public void outOfMemoryError() throws Errors {

        final List<Object[]> arrays = new LinkedList<>();
        for (; ; ) {
            arrays.add(new Object[100]);
        }
    }
        public void StackOverflowError() throws Errors {
            calculateFactorial(3);
        }
        private int calculateFactorial(int number) {
            return number * calculateFactorial(number - 1);
        }
    }