package org.example.exceptions;

import java.util.ArrayList;
import java.util.Arrays;

public class RuntimeExceptions extends Throwable {

    public void throwsNullPointerException() throws Exception {
        String myString = null;
        myString.length();
    }

    public void throwsArrayIndexOutOfBoundsException() throws Exception {
        int[] array = new int[]{1, 2};
        System.out.println(array[2]);
    }

    public void throwsNumberFormatException() throws Exception {
        Integer.parseInt(null);
    }

    public void throwsIllegalArgumentException() throws Exception {
        throw new IllegalArgumentException("Illegal argument!");
    }

    public static void throwsClassCastException() throws Exception {
        String[] strArray = new String[] {"Dima", "Ivan"};
        ArrayList<String> strList = (ArrayList<String>) Arrays.asList(strArray);
    }
}