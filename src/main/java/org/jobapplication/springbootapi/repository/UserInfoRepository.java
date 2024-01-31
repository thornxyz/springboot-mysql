package org.jobapplication.springbootapi.repository;

import org.jobapplication.springbootapi.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    UserInfo findByEmail(String email);
}
