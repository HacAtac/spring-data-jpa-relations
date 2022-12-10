package com.hacatac.spring.data.jpa.relations.repository;

import com.hacatac.spring.data.jpa.relations.entity.Course;
import com.hacatac.spring.data.jpa.relations.entity.Student;
import com.hacatac.spring.data.jpa.relations.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getContent();

        long totalELements =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalElements();

        long totalPages =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalPages();


        System.out.println("totalELements = " + totalELements);
        System.out.println("totalPages = " + totalPages);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc =
                PageRequest.of(0,2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0,2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses =
                courseRepository.findAll(sortByTitle)
                        .getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageWithTenRecords =
                PageRequest.of(0,10);
        List<Course> courses =
                courseRepository.findByTitleContaining("C", firstPageWithTenRecords)
                        .getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher
                .builder()
                .firstName("asdfdsf")
                .lastName("asdfsdf")
                .build();

        Student student = Student
                .builder()
                .firstName("He123123llo")
                .lastName("The123123re")
                .emailId("111restapi@cool.com")
                .build();

        Course course = Course
                .builder()
                .title("C123#")
                .credit(11230)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);

    }

}