package com.kisaragiLab.demo.springboot.dataManipulation.databaseOperationPractice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<CourseForJpa, Long> {

    List<CourseForJpa> findByCourseName(String courseName);
    List<CourseForJpa> findByAuthor(String author);

}
