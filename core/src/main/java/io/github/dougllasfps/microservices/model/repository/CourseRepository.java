package io.github.dougllasfps.microservices.model.repository;

import io.github.dougllasfps.microservices.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
