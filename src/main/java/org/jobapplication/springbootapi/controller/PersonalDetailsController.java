package org.jobapplication.springbootapi.controller;

import lombok.Data;
import org.jobapplication.springbootapi.entity.UserInfo;
import org.jobapplication.springbootapi.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class PersonalDetailsController {
    @Autowired
    private PersonalDetailsService personalDetailsService;

    @Data
    static class PersonalDetails {
        private Date dob;
        private String gender;
        private Long phone;
    }

    @PostMapping("/addPersonal/{id}")
    public ResponseEntity<?> addPersonalDetails(@RequestBody PersonalDetails request, @PathVariable Long id) {
        try {
            UserInfo updatedUser = personalDetailsService.addPersonalDetails(request.getDob(), request.getGender(), request.getPhone(), id);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error updating personal details: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
