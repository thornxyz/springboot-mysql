package org.test.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.springtest.entity.PersonalDetails;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
}
