package org.example.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//FileNotFoundException
public class CheckedExceptions extends Exception {
    public static void main(String[] args) throws IOException {

            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Username\\Desktop\\test.txt"));
            String firstString = reader.readLine();

            System.out.println(firstString);
        }
    }