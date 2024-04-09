package com.example.demo.springboot.dataManipulation.simpleRestApi;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.dataManipulation.Course;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
            new Course(1, "Learn AWS EC2", "KisaragiLab"),
            new Course(2, "Learn AWS Auto scaling and ELB", "KisaragiLab"),
            new Course(3, "Learn AWS Lamda", "KisaragiLab")
        );
    }

}
