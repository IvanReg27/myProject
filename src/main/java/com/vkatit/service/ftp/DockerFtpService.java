package com.vkatit.service.ftp;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DockerFtpService implements FtpService{

    @Value("${ftp.host}")
    String ip;
    @Value("${ftp.port}")
    int port;
    @Value("${ftp.password}")
    String password;
    @Value("${ftp.user}")
    String user;

    public URL getCurrentFtpUrl(String fileName) {
        try {
            return new URL("ftp://" + user + ":" + password + "@" + ip + ":" + port + "/" + fileName);
        } catch (Exception e) {
            return null;
        }
    }

    public byte[] readFile(String fileName) {
        URLConnection urlConnection;
        try {
            urlConnection = getCurrentFtpUrl(fileName).openConnection();
        } catch (Exception e) {
            return null;
        }
        try (InputStream inputStream = urlConnection.getInputStream()) {
            return inputStream.readAllBytes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void saveFile(byte[] bytes, String fileName) {
        URLConnection urlConnection;
        try {
            urlConnection = getCurrentFtpUrl(fileName).openConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

        try (OutputStream outputStream = urlConnection.getOutputStream();) {
            outputStream.write(bytes);
            outputStream.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
