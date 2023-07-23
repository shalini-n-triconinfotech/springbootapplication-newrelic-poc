package com.example.relic.controller;
import com.example.relic.service.StudentService;
import com.example.relic.util.AssignmentData;
import com.example.relic.util.AssignmentUtil;
import com.example.relic.util.CourseData;
import com.example.relic.util.StudentData;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
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
    @GetMapping(value = "/getAssignmentDetails")
    public List<AssignmentUtil> getAssignmentDetails(){
        logger.info("[StudentCallController_getAssignmentDetails]- Invoked getAssignmentDetails method");
        return studentService.getStudentAssignmentData();
    }

    @PostMapping("/insertAssignmentDetails")
    public ResponseEntity<String> insertStudentAssignmentDetails(@RequestBody AssignmentUtil assignmentUtil) {
        String message=studentService.insertAssignmentDetailService(assignmentUtil);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
