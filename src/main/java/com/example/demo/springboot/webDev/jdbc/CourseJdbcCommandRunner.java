package com.example.demo.springboot.webDev.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.springboot.webDev.Course;

@Component
public class CourseJdbcCommandRunner implements CommandLineRunner{

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "AWS EC2", "Kisaragi Lab"));
        courseJdbcRepository.insert(new Course(2, "AWS Auto scaling and ELB", "Kisaragi Lab"));
        courseJdbcRepository.insert(new Course(3, "AWS Lamda", "Kisaragi Lab"));
        
        courseJdbcRepository.deleteById(1);

        System.out.println(courseJdbcRepository.findById(2));
        System.out.println(courseJdbcRepository.findById(3));
    }

}
