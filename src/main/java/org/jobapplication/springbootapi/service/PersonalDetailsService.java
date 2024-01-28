package org.jobapplication.springbootapi.service;

import org.jobapplication.springbootapi.entity.UserInfo;
import org.jobapplication.springbootapi.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonalDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo addPersonalDetails(Date dob, String gender, Long phone, Long id) {
        UserInfo userInfo = userInfoRepository.findById(id).orElse(null);
        if(userInfo!=null) {
            userInfo.setDob(dob);
            userInfo.setGender(gender);
            userInfo.setPhone(phone);
            return userInfoRepository.save(userInfo);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

}
