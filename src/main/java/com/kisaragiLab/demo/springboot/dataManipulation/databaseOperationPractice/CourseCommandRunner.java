package com.kisaragiLab.demo.springboot.dataManipulation.databaseOperationPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kisaragiLab.demo.springboot.dataManipulation.Course;

@Component
public class CourseCommandRunner implements CommandLineRunner{

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "AWS EC2", "Kisaragi Lab"));
        courseJdbcRepository.insert(new Course(2, "AWS Auto scaling and ELB", "Kisaragi Lab"));
        courseJdbcRepository.insert(new Course(3, "AWS Lamda", "Kisaragi Lab"));
        
        courseJdbcRepository.deleteById(1);

        System.out.println(courseJdbcRepository.findById(2));
        System.out.println(courseJdbcRepository.findById(3));

        courseJpaRepository.insert(new CourseForJpa(4, "AWS Lightsail", "Kisaragi Lab"));
        courseJpaRepository.insert(new CourseForJpa(5, "AWS CloudWatch", "Kisaragi Lab"));
        courseJpaRepository.insert(new CourseForJpa(6, "AWS S3", "Kisaragi Lab"));

        courseJpaRepository.deleteById(4);

        System.out.println(courseJpaRepository.findById(5));
        System.out.println(courseJpaRepository.findById(6));

        repository.save(new CourseForJpa(7, "AWS EC2", "Kisaragi Lab"));
        repository.save(new CourseForJpa(8, "AWS Auto scaling and ELB", "Kisaragi Lab2"));
        repository.save(new CourseForJpa(9, "AWS Lamda", "Kisaragi Lab"));

        repository.deleteById(7l);

        System.out.println(repository.findById(8l));
        System.out.println(repository.findById(9l));

        System.out.println(repository.findByCourseName("AWS Auto scaling and ELB"));
        System.out.println(repository.findByAuthor("Kisaragi Lab"));

    }

}
