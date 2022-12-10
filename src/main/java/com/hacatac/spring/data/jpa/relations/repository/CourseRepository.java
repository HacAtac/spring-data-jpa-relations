package com.hacatac.spring.data.jpa.relations.repository;

import com.hacatac.spring.data.jpa.relations.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByTitleContaining(String title, Pageable firstPageWithTenRecords);

    Page<Course> findByCreditGreaterThanEqual(Integer credit, Pageable firstPageWithTenRecords);

    Page<Course> findByTitleContainingAndCreditGreaterThanEqual(String title, Integer credit, Pageable firstPageWithTenRecords);


}
