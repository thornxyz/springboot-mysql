package org.test.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.springtest.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
