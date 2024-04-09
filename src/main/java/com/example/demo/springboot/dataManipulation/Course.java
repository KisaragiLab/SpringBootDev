package com.example.demo.springboot.dataManipulation;

public class Course {

    private long id;
    private String courseName;
    private String author;

    public Course() {
    }

    public Course(long id, String courseName, String author) {
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
