package com.example.relic2.serviceImpl;
import com.example.relic2.service.StudentCallService;
import com.example.relic2.util.AssignmentData;
import com.example.relic2.util.CourseData;
import com.example.relic2.util.StudentData;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class StudentCallServiceImpl implements StudentCallService {
    RestTemplate restTemplate = new RestTemplate();
    private static final Logger logger = LoggerFactory.getLogger(StudentCallServiceImpl.class);
    public StudentData[] getStudentsData(){
        String url = "http://studentapplication:8081/students";
        logger.info("RestCallApplication[]->getStudentsData()Method");
        ResponseEntity<StudentData[]> response = restTemplate.getForEntity(url, StudentData[].class);
        StudentData[] students = response.getBody();
        return students;
    }
    public CourseData[] getStudentCourseDetails(){
        String url = "http://studentapplication:8081/studentCourseDetails";
        logger.info("RestCallApplication[]->getStudentCourseDetails()Method");
        ResponseEntity<CourseData[]> response = restTemplate.getForEntity(url, CourseData[].class);
        CourseData[] courses=response.getBody();
        return courses;
    }
    public AssignmentData[] getStudentAssignmentData(){
    logger.debug("Started collecting the data of student assignment list");
    String url = "http://studentapplication:8081/getAssignmentDetails";
    logger.info("RestCallApplication[]->getStudentAssignmentData()Method");
    ResponseEntity<AssignmentData[]> response = restTemplate.getForEntity(url,AssignmentData[].class);
    AssignmentData[] students = response.getBody();
    logger.info("studentDetails->{}",students.toString());
    NewRelic.getAgent().getTracedMethod().addCustomAttribute("studentDetails",students.toString());
    return students;
    }
    public String InsertStudentAssignmentData(AssignmentData assignmentData){
        String url = "http://studentapplication:8081/insertAssignmentDetails";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<AssignmentData> entity = new HttpEntity<AssignmentData>(assignmentData,headers);
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
    }
}