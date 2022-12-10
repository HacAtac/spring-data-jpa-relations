package com.hacatac.spring.data.jpa.relations.repository;

import com.hacatac.spring.data.jpa.relations.entity.Course;
import com.hacatac.spring.data.jpa.relations.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest

class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void printCourses(){
        List<Course> courses =
                courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacer = Teacher.builder()
                .firstName("Rojer")
                .lastName("Hudgens")
                .build();
        Course course = Course.builder()
                .title("C#")
                .credit(10)
                .teacher(teacer)
                .build();
        courseRepository.save(course);
    }
}