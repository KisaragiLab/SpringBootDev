package com.kisaragiLab.demo.springboot.dataManipulation.databaseOperationPractice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CourseForJpa {

    @Id private long id;
    private String courseName;
    private String author;

    public CourseForJpa() {
    }

    public CourseForJpa(long id, String courseName, String author) {
        super();
        this.id = id;
        this.courseName = courseName;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName + ", author=" + author + "]";
    }

}
