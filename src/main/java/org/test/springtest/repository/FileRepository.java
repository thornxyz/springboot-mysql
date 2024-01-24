package org.test.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.springtest.entity.Files;

public interface FileRepository extends JpaRepository<Files, Long> {
}
