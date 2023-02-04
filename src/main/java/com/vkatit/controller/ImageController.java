package com.vkatit.controller;

import com.vkatit.service.ftp.FtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

    @Qualifier("dockerFtpService")
    @Autowired
    FtpService ftpService;

    @GetMapping("/images/{fileName}")
    public ResponseEntity<Object> getImage(@PathVariable("fileName") String fileName) {
        try {
            byte[] bytes = ftpService.readFile(fileName);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-type", "image/" + fileName.split("\\.")[1]);
            headers.set("Content-Disposition", "attachment; filename=" + fileName);
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bytes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/images")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            ftpService.saveFile(file.getBytes(), file.getOriginalFilename());
            return ResponseEntity.status(HttpStatus.CREATED).body("Image was created");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


}
