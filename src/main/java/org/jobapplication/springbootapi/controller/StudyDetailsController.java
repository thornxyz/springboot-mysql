package org.jobapplication.springbootapi.controller;

import lombok.Data;
import org.jobapplication.springbootapi.entity.UserInfo;
import org.jobapplication.springbootapi.service.StudyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class StudyDetailsController {
    @Autowired
    private StudyDetailsService studyDetailsService;

    @Data
    static class StudyDetails {
        private double tenthBoardPercent;
        private double twelfthBoardPercent;
        private double collegeCgpa;
        private String collegeName;
    }

    @PostMapping("/addStudy/{id}")
    public ResponseEntity<?> addStudyDetails(@RequestBody StudyDetails request, @PathVariable Long id) {
        try {
            UserInfo updatedUser = studyDetailsService.addStudyDetails(request.getTenthBoardPercent(), request.getTwelfthBoardPercent(), request.getCollegeCgpa(), request.getCollegeName(), id);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error updating study details: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
