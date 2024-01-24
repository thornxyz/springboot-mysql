package org.test.springtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.test.springtest.service.FileUpload;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileUploadController {
    private final FileUpload fileUpload;

    @PostMapping("/upload")
    public String uploadFile(@RequestPart  MultipartFile file) {
        try {
            String fileURL = fileUpload.uploadFile(file);
            return fileURL;
        } catch (IOException e) {
            return "Error uploading PDF file";
        }
    }
}
