package com.vkatit.service.ftp;

public interface FtpService {

    byte[] readFile(String fileName) ;

    void saveFile(byte[] bytes, String fileName);

}
