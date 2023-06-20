package com.example.relic2.controller;
import com.example.relic2.service.StudentCallService;
import com.example.relic2.util.CourseData;
import com.example.relic2.util.StudentData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentCallController {

    @Autowired
    StudentCallService studentCallService;

    private static final Logger logger = LoggerFactory.getLogger(StudentCallController.class);
    @GetMapping(value = "/getStudents")
    public StudentData[] getStudents(){
        logger.info("[StudentCallController_getStudents]- Invoked getStudents method");
        return studentCallService.getStudentsData();
    }
    @GetMapping(value = "/getStudentCourseDetails")
    public CourseData[] getStudentCourseDetails() throws InterruptedException {
        logger.info("[StudentCallController_getStudentCourseDetails]- Invoked getStudentCourseDetails method");
        return studentCallService.getStudentCourseDetails();
    }

}
