package com.example.relic2.service;

import com.example.relic2.util.CourseData;
import com.example.relic2.util.StudentData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentCallService {
    public StudentData[] getStudentsData();
    public CourseData[] getStudentCourseDetails();
}
