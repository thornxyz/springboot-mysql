package org.jobapplication.springbootapi.service;

import lombok.RequiredArgsConstructor;
import org.jobapplication.springbootapi.entity.UserInfo;
import org.jobapplication.springbootapi.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class DetailsUploadService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo addDetails(String name, Date dob, String gender, Long phone, double tenthBoardPercent, double twelfthBoardPercent, double collegeCgpa, String collegeName, String email) {
        UserInfo userInfo = userInfoRepository.findByEmail(email);
        if(userInfo!=null) {
            userInfo.setName(name);
            userInfo.setTenthBoardPercent(tenthBoardPercent);
            userInfo.setTwelfthBoardPercent(twelfthBoardPercent);
            userInfo.setCollegeCgpa(collegeCgpa);
            userInfo.setCollegeName(collegeName);
            userInfo.setDob(dob);
            userInfo.setGender(gender);
            userInfo.setPhone(phone);
            return userInfoRepository.save(userInfo);
        }
        throw new RuntimeException("User not found with email: " + email);
    }
}
