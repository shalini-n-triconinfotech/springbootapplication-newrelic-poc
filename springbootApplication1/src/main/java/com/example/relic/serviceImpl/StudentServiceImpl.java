package com.example.relic.serviceImpl;
import com.example.relic.Repository.StudentRepository;
import com.example.relic.service.StudentService;
import com.example.relic.util.CourseData;
import com.example.relic.util.StudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    public List<StudentData> getStudentsData(){
        List<StudentData>studentData=studentRepository.getStudentInfo();
        return studentData;
    }
    @Scheduled(initialDelay = 1000*30, fixedDelay=Long.MAX_VALUE)
    public List<CourseData> getStudentCourseDetails() throws InterruptedException {
        try {
        Thread.sleep(6000);
        List<CourseData>studentData=studentRepository.getStudentCourseDetailsInfo();
            System.out.println("task running ..");
        return studentData;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
