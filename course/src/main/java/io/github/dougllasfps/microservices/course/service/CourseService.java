package io.github.dougllasfps.microservices.course.service;

import io.github.dougllasfps.microservices.model.Course;
import io.github.dougllasfps.microservices.model.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public Iterable<Course> findAll(){
        return repository.findAll(Pageable.unpaged());
    }
}
