package com.example.relic.serviceImpl;
import com.example.relic.Repository.AssignmentRepository;
import com.example.relic.Repository.StudentRepository;
import com.example.relic.lib.NewRelicAttributes;
import com.example.relic.service.StudentService;
import com.example.relic.util.*;
import com.newrelic.api.agent.NewRelic;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    EntityManager entityManager;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    NewRelicAttributes newRelicAttributes;
    public List<StudentData> getStudentsData(){
        logger.info("[StudentServiceImpl_getStudentsData]- Invoked getStudentsData method");
        List<Students> studentsList=(List<Students>) studentRepository.findAll();
        List<StudentData> studentData = new ArrayList<StudentData>();
        studentsList.stream().forEach(students ->{
        if(students.getId()==4) {
            NewRelic.addCustomParameter("studentUniRollId", students.getId());
            logger.info("studentUniRollId->{}",students.getId());
            NewRelic.addCustomParameter("studentCourseId", students.getCourse_id());
            logger.info("studentCourseId->{}",students.getCourse_id());
            newRelicAttributes.generateCustomParameter("studentName",students.getStudentname());
            logger.info("studentName->{}",students.getStudentname());
            }
            studentData.add(new StudentData(students));
        }
        );
        logger.info("The response received by getStudentsData");
        return studentData;
    }

    public List<CourseData> getStudentCourseDetails() throws InterruptedException {
        try {
            Thread.sleep(6000);
            logger.info("[StudentServiceImpl_getStudentCourseDetails]- Invoked getStudentCourseDetails method");
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CourseData> criteriaQuery = criteriaBuilder.createQuery(CourseData.class);
            Root<Students> studentsRoot = criteriaQuery.from(Students.class);
            Join<Students, Courses> coursesJoin = studentsRoot.join("courses", JoinType.INNER);
            criteriaQuery.multiselect(studentsRoot.get("id"), studentsRoot.get("studentname"),
                    studentsRoot.get("age"), studentsRoot.get("address"), studentsRoot.get("course_id"),
                    coursesJoin.get("course_name"));
            List<CourseData> studentCourseList = entityManager.createQuery(criteriaQuery).getResultList();
            return studentCourseList;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<AssignmentUtil> getStudentAssignmentData(){
        logger.info("[StudentServiceImpl_getStudentAssignmentData]- Invoked getStudentAssignmentData method");
        logger.debug("Started collecting the data of student assignment list");
        List<AssignmentData> studentsAssesmentList=(List<AssignmentData>) assignmentRepository.findAll();
        List<AssignmentUtil> assignmentUtilsData = new ArrayList<AssignmentUtil>();
        studentsAssesmentList.stream().forEach(studentsAssignment ->{
            if(studentsAssignment.getUniversity_id()==101)
            {
                NewRelic.addCustomParameter("universityNumber",studentsAssignment.getUniversity_id());
                NewRelic.addCustomParameter("studentId",studentsAssignment.getStudent_id());
                NewRelic.addCustomParameter("questionId",studentsAssignment.getQuestion_id());
                logger.error("University 101 ERROR!!!!... ");
                logger.error("universityNumber->{}",studentsAssignment.getUniversity_id().toString());
                logger.info("studentId->{}",studentsAssignment.getStudent_id().toString());
                logger.info("questionId->{}"+studentsAssignment.getStudent_id().toString());
            }
            if(studentsAssignment.getUniversity_id()==103)
            {
                logger.info("University 103 INFO!!!!... ");
                NewRelic.addCustomParameter("customAttributeUniversityId",studentsAssignment.getUniversity_id());
                NewRelic.addCustomParameter("customAttributeStudentId",studentsAssignment.getStudent_id());
                NewRelic.addCustomParameter("customAttributeQuestionId",studentsAssignment.getQuestion_id());
                logger.info("customAttributeUniversityId->{}",studentsAssignment.getUniversity_id().toString());
                logger.info("customAttributeStudentId->{}",studentsAssignment.getUniversity_id().toString());
                logger.info("customAttributeQuestionId->{}"+studentsAssignment.getStudent_id().toString());
            }
            assignmentUtilsData.add(new AssignmentUtil(studentsAssignment));
                }
        );
        if(assignmentUtilsData.isEmpty()){
            logger.warn("Student AssignmentList is Empty");
        }
        logger.info("The response received by getStudentsData");
        return assignmentUtilsData;
    }

    public String insertAssignmentDetailService(AssignmentUtil assignmentUtil) {
        logger.info("insertAssignmentDetailService  - insert Assignment Details");
        AssignmentData assignmentData=new AssignmentData();
            assignmentData.setId(assignmentUtil.getId());
            assignmentData.setStudent_id(assignmentUtil.getStudent_id());
            assignmentData.setQuestion_id(assignmentUtil.getQuestion_id());
            assignmentData.setQuestion_name(assignmentUtil.getQuestion_name());
            assignmentData.setAttempt_no(assignmentUtil.getAttempt_no());
            assignmentData.setUniversity_id(assignmentUtil.getUniversity_id());
        assignmentRepository.save(assignmentData);
        newRelicAttributes.generateCustomParameter("userId",assignmentData.getStudent_id().toString());
        logger.info("userId->{}",assignmentData.getStudent_id().toString());
        return "Student Assignment Created Successfully";
    }
}
