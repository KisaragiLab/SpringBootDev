package com.kisaragiLab.demo.springboot.dataManipulation.databaseOperationPractice;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
	private EntityManager entityManager;

    public void insert(CourseForJpa course) {
        entityManager.merge(course);
    }

    public void deleteById(long id) {
        CourseForJpa course = entityManager.find(CourseForJpa.class, id);
        entityManager.remove(course);
    }

    public CourseForJpa findById(long id) {
        return entityManager.find(CourseForJpa.class, id);
    }
    
}
