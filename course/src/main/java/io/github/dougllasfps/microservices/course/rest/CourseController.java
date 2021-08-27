package io.github.dougllasfps.microservices.course.rest;

import io.github.dougllasfps.microservices.course.service.CourseService;
import io.github.dougllasfps.microservices.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/admin/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Course> getAll(){
        return service.findAll();
    }
}
