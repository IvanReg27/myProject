package org.example.httpserver;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpServerConvertToCSV {

    public static void main(String[] args) throws IOException {

            //создал объект URL
            final URL url = new URL("http://185.106.92.99:8080/users");
            System.out.println("Listening for connection on port 8080...");
            //открыл на основании объекта URL соединение
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //создал буфер для данных для дальнейшего чтения данных из него
            try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                final StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);

                    try (final PrintWriter writer = new PrintWriter(new File("C:\\Users\\Ivan\\IdeaProjects\\lesson3_maven\\src\\main\\resources\\CSVDemo.csv"))) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(content);

                        writer.write(sb.toString());
                        writer.close();
                        System.out.println("Done!");
                    }
                    catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }