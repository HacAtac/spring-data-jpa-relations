package com.hacatac.spring.data.jpa.relations.repository;

import com.hacatac.spring.data.jpa.relations.entity.Guardian;
import com.hacatac.spring.data.jpa.relations.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("jhack00@icloud.com")
                .firstName("Jordan")
                .lastName("Hackworth")
                //.guardianName("Dan")
                //.guardianEmail("Hackworth")
                //.guardianMobile("5555555555")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("1111111111")
                .build();
        Student student = Student.builder()
                .firstName("Shivam")
                .lastName("Kumar")
                .emailId("test@test.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println(studentList);
    }


    @Test
    public void printStudentByFirstName(){
        List<Student> studentList =
                studentRepository.findByFirstName("Jordan");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList =
                studentRepository.findByFirstNameContaining("an");
        System.out.println(studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList =
                studentRepository.findByGuardianName("");

        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstAndLastName(){
        Student student =
                studentRepository.findByFirstNameAndLastName("test", "mcgee");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmail(){
       Student student =
       studentRepository.getStudentByEmailAddress("jhack00@icloud.com");
        System.out.println(student);
    }

    @Test
    public void pritnGetStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "test@test.com"
                );

        System.out.println(firstName);
    }
}

