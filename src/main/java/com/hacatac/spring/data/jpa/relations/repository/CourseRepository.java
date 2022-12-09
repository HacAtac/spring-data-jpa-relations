package com.hacatac.spring.data.jpa.relations.repository;

import com.hacatac.spring.data.jpa.relations.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
