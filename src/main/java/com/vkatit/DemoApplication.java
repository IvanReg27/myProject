package com.vkatit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {


        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

//        byte[] bytes = Files.readAllBytes(new File("C:\\keke.jpeg").toPath());
//
//        try (FileOutputStream stream = new FileOutputStream("C:\\test.jpeg")) {
//            stream.write(context.getBean("ftpService", FtpService.class).readFile( "keke.jpeg"));
//        }

    }

    ///*
//   String server = "185.106.92.99";
//        int port = 21;
//        String user = "root";
//        String pass = "password123";
//
//        File file = new File("C:\\keke.jpeg");
//
//        String ftpUrl = String.format(
//                "ftp://root:password123@185.106.92.99:%d/test/kek.txt", 21);
//
//        URLConnection urlConnection = new URL(ftpUrl).openConnection();
//
//        InputStream inputStream = urlConnection.getInputStream();
//
//
//        Files.copy(inputStream, new File("kek.txt").toPath());
//        inputStream.close();*/



}
