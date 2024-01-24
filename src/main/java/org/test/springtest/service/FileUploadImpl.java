package org.test.springtest.service;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.test.springtest.entity.Files;
import org.test.springtest.repository.FileRepository;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadImpl implements FileUpload {
    private final Cloudinary cloudinary;
    private final String cloudinaryFolder = "pdfs";

    @Autowired
    private FileRepository fileRepository;

    @Override
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        try {
            Map<?, ?> result = cloudinary.uploader()
                    .upload(multipartFile.getBytes(),
                            Map.of("public_id", UUID.randomUUID().toString(),
                                    "folder", cloudinaryFolder));

            String fileUrl = result.get("url").toString();

            saveUrlToDatabase(fileUrl);

            return fileUrl;
        } catch (IOException e) {
            throw new IOException("Error uploading file to Cloudinary", e);
        }
    }

    private void saveUrlToDatabase(String fileUrl) {
        Files file = new Files();
        file.setFileUrl(fileUrl);
        fileRepository.save(file);
    }
}
