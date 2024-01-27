package org.jobapplication.springbootapi.controller;

import lombok.Data;
import org.jobapplication.springbootapi.entity.UserInfo;
import org.jobapplication.springbootapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserService userService;

    @Data
    static class UserInfoRequest {
        private String email;
        private String name;
    }

    @PostMapping("/register")
    public ResponseEntity<UserInfo> registerUser(@RequestBody UserInfoRequest request) {
        UserInfo newUser = userService.registerUser(request.getEmail(), request.getName());
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        List<UserInfo> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

}
