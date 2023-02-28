package org.example.exceptions;

import java.util.LinkedList;
import java.util.List;

//OutOfMemoryError
public class Errors extends Throwable {
    public static void main(String[] args) throws Error {

        final List<Object[]> arrays = new LinkedList<>();
        for (; ; ) {
            arrays.add(new Object[100]);
        }
    }
}
//StackOverflowError
class Errors2 extends Throwable {
    public static void main(String[] args) throws Error {
        calculateFactorial(3);
}
    private static int calculateFactorial(int number) {
        return number * calculateFactorial(number - 1);
    }
}