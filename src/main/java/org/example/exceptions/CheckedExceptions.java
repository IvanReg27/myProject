package org.example.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptions extends Exception {
    public void fileNotFoundException() throws IOException {

            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Username\\Desktop\\test.txt"));
            String firstString = reader.readLine();

            System.out.println(firstString);
        }
    }