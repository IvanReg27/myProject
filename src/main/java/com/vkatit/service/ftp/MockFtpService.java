package com.vkatit.service.ftp;

import java.util.HashMap;
import java.util.Map;

public class MockFtpService implements FtpService {

    Map<String, byte[]> files = new HashMap<>();

    @Override
    public byte[] readFile(String fileName) {
        return files.get(fileName);
    }

    @Override
    public void saveFile(byte[] bytes, String fileName) {
        files.put(fileName, bytes);
    }
}
