package org.example.httpserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpServerConvertToCSV {

    public static void main(String[] args) throws IOException {

        String line = "";
        String splitBy = ",";

        //создал объект URL
        final URL url = new URL("http://185.106.92.99:8080/users");
        System.out.println("Listening for connection on port 8080...");

        //открыл на основании объекта URL соединение
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();

        //создал буфер для данных для дальнейшего чтения данных из него

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                in = new BufferedReader(new FileReader("CSVDemo.csv"));
                while ((line = in.readLine()) != null) {
                    String[] employee = line.split(splitBy);
                    System.out.println(employee);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }