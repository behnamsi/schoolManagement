package com.behnam.school.management.student;

import com.behnam.school.management.configuration.SpringContext;
import com.behnam.school.management.repository.CollegeRepository;
import com.behnam.school.management.repository.CourseRepository;
import com.behnam.school.management.repository.StudentRepository;
import com.behnam.school.management.service.StudentService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class MyTest {

    @Test
    void myTst() {
        StudentRepository repository = SpringContext.getBean(StudentRepository.class);
        System.out.println(SpringContext.getContext());
        System.err.println(repository.findById(3L));
    }
}