package com.example.relic2.serviceImpl;

import com.example.relic2.service.StudentCallService;
import com.example.relic2.util.CourseData;
import com.example.relic2.util.StudentData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class StudentCallServiceImpl implements StudentCallService {
    RestTemplate restTemplate = new RestTemplate();
    public StudentData[] getStudentsData() {
        String url = "http://studentapplication:8081/students";
        ResponseEntity<StudentData[]> response = restTemplate.getForEntity(url, StudentData[].class);
        StudentData[] students = response.getBody();
        return students;
    }

    public CourseData[] getStudentCourseDetails() {
        String url = "http://studentapplication:8081/studentCourseDetails";
        ResponseEntity<CourseData[]> response = restTemplate.getForEntity(url, CourseData[].class);
        CourseData[] courses=response.getBody();
        return courses;
    }

}
