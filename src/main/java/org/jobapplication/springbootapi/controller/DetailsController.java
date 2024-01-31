package org.jobapplication.springbootapi.controller;

import lombok.Data;
import org.jobapplication.springbootapi.entity.UserInfo;
import org.jobapplication.springbootapi.service.DetailsUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class DetailsController {
    @Autowired
    private DetailsUploadService detailsUploadService;

    @Data
    static class Details {
        private String name;
        private Date dob;
        private String gender;
        private String phone;
        private double tenthBoardPercent;
        private double twelfthBoardPercent;
        private double collegeCgpa;
        private String collegeName;
    }

    @PostMapping("/addDetails/{email}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> addDetails(@RequestBody Details request, @PathVariable String email) {
        try {
            UserInfo updatedUser = detailsUploadService.addDetails(request.getName(), request.getDob(), request.getGender(), request.getPhone(), request.getTenthBoardPercent(), request.getTwelfthBoardPercent(), request.getCollegeCgpa(), request.getCollegeName(), email);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error updating personal details: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
