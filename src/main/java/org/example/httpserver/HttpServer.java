package org.example.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpServer {
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

                System.out.println(content);

                //полученную стрингу положил в коллекцию лист
                //для листа преобразовал данные в объект
                ArrayList<String> users = new ArrayList<>();
                users.add(String.valueOf(content));
                System.out.println("Content add to ArrayList...");

                System.out.println(users);
            }
        }
    }
}