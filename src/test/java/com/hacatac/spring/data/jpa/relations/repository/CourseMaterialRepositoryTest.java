package com.hacatac.spring.data.jpa.relations.repository;

import com.hacatac.spring.data.jpa.relations.entity.Course;
import com.hacatac.spring.data.jpa.relations.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){
        Course course =
                Course.builder()
                        .title(".net")
                        .credit(6)
                        .build();

            CourseMaterial courseMaterial = CourseMaterial.builder()
                    .url("www.youtube.com")
                    .course(course)
                    .build();

            repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList =
                repository.findAll();
        System.out.println(courseMaterialList);
    }

}