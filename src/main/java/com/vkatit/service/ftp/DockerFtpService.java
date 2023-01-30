package com.vkatit.service.ftp;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

@Log4j2
@Service
public class DockerFtpService implements FtpService {

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
            log.error(e.getMessage());
        }
        return null;
    }

    public void saveFile(byte[] bytes, String fileName) {
        URLConnection urlConnection;
        try {
            urlConnection = getCurrentFtpUrl(fileName).openConnection();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        try (OutputStream outputStream = urlConnection.getOutputStream();) {
            outputStream.write(bytes);
            outputStream.flush();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
