package com.hacatac.spring.data.jpa.relations.repository;

import com.hacatac.spring.data.jpa.relations.entity.Course;
import com.hacatac.spring.data.jpa.relations.entity.CourseMaterial;
import com.hacatac.spring.data.jpa.relations.entity.Student;
import com.hacatac.spring.data.jpa.relations.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void SaveCourseMaterial(){
        Course courseOne = Course.builder()
                .title("Java")
                .credit(7)
                .build();

        Student studentOne = Student.builder()
                .firstName("Jordan")
                .lastName("Hackworth")
                .emailId("chiefy123123@chiefy.com")
                .build();

        Course courseTwo = Course.builder()
                .title("Python")
                .credit(10)
                .build();

        Student studentTwo = Student.builder()
                .firstName("Jessie")
                .lastName("Hackworth")
                .emailId("jesssasdsd@hack.com")
                .build();

        Teacher teacher = Teacher.builder()
                        .firstName("Tiffany")
                        .lastName("Hudgens")
                        //.courses(List.of(courseOne, courseTwo))
                        //.student(List.of(studentOne, studentTwo))
                                .build();
        teacherRepository.save(teacher);
    }
}