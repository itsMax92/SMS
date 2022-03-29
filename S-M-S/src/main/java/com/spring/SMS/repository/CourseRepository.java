package com.spring.SMS.repository;

import com.spring.SMS.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Subject, Long> {
}
