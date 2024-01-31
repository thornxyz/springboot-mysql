package org.jobapplication.springbootapi.service;

import org.jobapplication.springbootapi.entity.UserInfo;
import org.jobapplication.springbootapi.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo registerUser(String email) {
        Optional<UserInfo> existingUser = userInfoRepository.findById(email);
        if (existingUser.isPresent()) {
            return null;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(email);
        userInfo.setTenthBoardPercent(null);
        userInfo.setTwelfthBoardPercent(null);
        userInfo.setCollegeCgpa(null);
        return userInfoRepository.save(userInfo);
    }

    public List<UserInfo> getAllUsers() {
        return userInfoRepository.findAll();
    }

    public UserInfo getUserInfo(String email) {
        return userInfoRepository.findByEmail(email);
    }
}
