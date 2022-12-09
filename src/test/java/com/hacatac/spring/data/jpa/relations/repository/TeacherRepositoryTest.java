package com.hacatac.spring.data.jpa.relations.repository;

import com.hacatac.spring.data.jpa.relations.entity.Course;
import com.hacatac.spring.data.jpa.relations.entity.CourseMaterial;
import com.hacatac.spring.data.jpa.relations.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void SaveCourseMaterial(){
        Teacher teacher = Teacher.builder()
                        .name("Tiffany")
                                .build();
        teacherRepository.save(teacher);
    }
}