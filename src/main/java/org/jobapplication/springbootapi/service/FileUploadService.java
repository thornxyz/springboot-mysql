package org.jobapplication.springbootapi.service;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.jobapplication.springbootapi.entity.UserInfo;
import org.jobapplication.springbootapi.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileUploadService {
    private final Cloudinary cloudinary;

    @Autowired
    private UserInfoRepository userInfoRepository;
    public String uploadFile(MultipartFile multipartFile, Long id) throws IOException {
        try {
            String cloudinaryFolder = "pdfs";
            Map<?, ?> result = cloudinary.uploader()
                    .upload(multipartFile.getBytes(),
                            Map.of("public_id", UUID.randomUUID().toString(),
                                    "folder", cloudinaryFolder));

            String fileUrl = result.get("url").toString();

            saveUrlToDatabase(fileUrl, id);

            return fileUrl;
        } catch (IOException e) {
            throw new IOException("Error uploading file to Cloudinary", e);
        }
    }

    private void saveUrlToDatabase(String fileUrl, Long id) {
        UserInfo userInfo = userInfoRepository.findById(id).orElse(null);
        if(userInfo!=null) {
            userInfo.setResumeUrl(fileUrl);
            userInfoRepository.save(userInfo);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

}
