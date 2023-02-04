package com.vkatit.service.ftp;

import java.util.HashMap;
import java.util.Map;

public class FtpServiceMock implements FtpService{
    private Map<String, byte[]> mockData = new HashMap<>();

    @Override
    public byte[] readFile(String fileName) {
        return mockData.get(fileName);
    }

    @Override
    public void saveFile(byte[] bytes, String fileName) {
        mockData.put(fileName, bytes);
    }
}
