package org.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.springtest.entity.PersonalDetails;
import org.test.springtest.service.PersonalDetailsService;

@RestController
public class PersonalDetailsController {
    private final PersonalDetailsService personalDetailsService;

    @Autowired
    public PersonalDetailsController(PersonalDetailsService personalDetailsService) {
        this.personalDetailsService = personalDetailsService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/applyPerson")
    public PersonalDetails applyPerson(@RequestBody PersonalDetails personalDetails) {
        return personalDetailsService.registerPerson(personalDetails);
    }
}
