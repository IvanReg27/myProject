package org.example.httpserver;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CityApi_2 {
    public static List<CityApi_2> cityRondom100;
    
    public static String fileName = "City.txt";
    
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//        cityRondom100 = ReceiveCitiRandom();
//        System.out.println(cityRondom100.size());
//        System.out.println(getAllCity().size());
//        for (int i = 0; i < cityRondom100.size(); ++i) {
//            for (City city : n) {
//            System.out.print("City: " + getAllCity().get(i));
//            System.out.print(" Longitude: " + City.getLongitude());
//            System.out.println(" Latitude: " + City.getLatitude());
//            System.out.println(cityRondom100.get(i));
//        }
//        System.out.println(cityRondom100.get(6));
    }
    public static List<CityApi_2> ReceiveCitiRandom() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI("https://gist.githubusercontent.com/isicju/57f52dc77344eba300d6c6b051b29187/raw/1a2ff4fc5faa1ba58f7c3fcbb0d47dbd15baa340/cities")).build();
        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get(fileName)));
        
        List<CityApi_2> cityList100 = new ArrayList<>(100);
        
        for (int i = 0; i < 100; ++i) {
            String cityTop100 = Files.readAllLines(Paths.get(fileName)).get(getRandomNumber());
            String[] item = cityTop100.split("\t");
            //cityList100.add(new CityApi_2(item[0], Float.parseFloat(item[2]), Float.parseFloat(item[3])));

//            System.out.print("City: " + City.getCityAscii());
//            System.out.print(" Longitude: " + City.getLongitude() );
//            System.out.println(" Latitude: " + City.getLatitude());
        }
        System.out.printf("ArrayList has %d elements \n", cityList100.size());
        
        // System.out.println((new Gson().toJson(city.getCities())).getBytes(StandardCharsets.UTF_8));
        
        return cityList100;
    }
    public static int getRandomNumber() throws IOException {
        return (int) ((Math.random() * (fileLineMeter() - 1)) + 1);
    }
    public static int fileLineMeter() throws IOException {
        int linesInFile = 0;
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                linesInFile = linesInFile + 1;
            }
            return linesInFile;
        }
    }
    
//    public static CityApi getInstance() {
//        return instance;
//    }
    
//    private static List<City_2> getAllCity() {
//        return cityRondom100;
//    }
}