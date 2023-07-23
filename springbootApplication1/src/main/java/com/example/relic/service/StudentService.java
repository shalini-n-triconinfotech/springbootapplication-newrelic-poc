package com.example.relic.service;
import com.example.relic.util.AssignmentData;
import com.example.relic.util.AssignmentUtil;
import com.example.relic.util.CourseData;
import com.example.relic.util.StudentData;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService{
    public List<StudentData> getStudentsData();
    public List<CourseData>getStudentCourseDetails() throws InterruptedException;
    public List<AssignmentUtil> getStudentAssignmentData();

    public String insertAssignmentDetailService(AssignmentUtil assignmentUtil);
}
