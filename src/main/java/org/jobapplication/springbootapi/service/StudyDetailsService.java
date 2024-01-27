package org.jobapplication.springbootapi.service;

import org.jobapplication.springbootapi.entity.UserInfo;
import org.jobapplication.springbootapi.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo addStudyDetails(double tenthBoardPercent, double twelfthBoardPercent, double collegeCgpa, String collegeName, Long id) {
        UserInfo userInfo = userInfoRepository.findById(id).orElse(null);
        if(userInfo!=null) {
            userInfo.setTenthBoardPercent(tenthBoardPercent);
            userInfo.setTwelfthBoardPercent(twelfthBoardPercent);
            userInfo.setCollegeCgpa(collegeCgpa);
            userInfo.setCollegeName(collegeName);
            return userInfoRepository.save(userInfo);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }
}
