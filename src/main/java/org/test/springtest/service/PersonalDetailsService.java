package org.test.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.springtest.entity.PersonalDetails;
import org.test.springtest.repository.PersonalDetailsRepository;

@Service
public class PersonalDetailsService {
    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;

    public PersonalDetails registerPerson(PersonalDetails personalDetails) {
        return personalDetailsRepository.save(personalDetails);
    }
}
