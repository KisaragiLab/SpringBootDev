package com.example.demo.springboot.dataManipulation.databaseOperationPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.springboot.dataManipulation.Course;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate sprinJdbcTemplate;
    private static String INSERT_QUERY = 
            """
                insert into Course (id, courseName, author)
                values (?, ?, ?);
            """;

    private static String DELETE_QUERY = 
            """
                delete from Course
                where id=?
            """;

    private static String SELECT_QUERY = 
            """
                select * from Course
                where id=?
            """;

    public void insert(Course course) {
        sprinJdbcTemplate.update(INSERT_QUERY,
            course.getId(), course.getCourseName(), course.getAuthor()
        );
    }

    public void deleteById(long id) {
        sprinJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return sprinJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

}
