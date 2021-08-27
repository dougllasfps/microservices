package io.github.dougllasfps.microservices.course;

import io.github.dougllasfps.microservices.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("io.github.dougllasfps.microservices.model")
@EnableJpaRepositories(("io.github.dougllasfps.microservices.model.repository"))
public class CourseApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseApiApplication.class, args);
    }
}
