package org.jobapplication.springbootapi.controller;

import org.jobapplication.springbootapi.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload/{email}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> uploadFile(@RequestPart MultipartFile file, @PathVariable String email) {
        try {
            String fileUrl = fileUploadService.uploadFile(file, email);
            return new ResponseEntity<>(fileUrl, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error uploading file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
