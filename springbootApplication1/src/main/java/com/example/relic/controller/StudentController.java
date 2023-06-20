package com.example.relic.controller;

import com.example.relic.service.StudentService;
import com.example.relic.util.CourseData;
import com.example.relic.util.StudentData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @GetMapping(value = "/students")
    public List<StudentData> getStudents(){
        logger.info("[StudentController_getStudents]- Invoked getStudents method");
        return studentService.getStudentsData();
    }
    @GetMapping(value = "/studentCourseDetails")
    public List<CourseData> getStudentCourseDetails() throws InterruptedException {
        logger.info("[StudentController_getStudentCourseDetails]- Invoked getStudentCourseDetails method");
        return studentService.getStudentCourseDetails();
    }
}
