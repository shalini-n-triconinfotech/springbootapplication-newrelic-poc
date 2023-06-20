package com.example.relic.Repository;
import com.example.relic.util.CourseData;
import com.example.relic.util.StudentData;
import com.example.relic.util.Students;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Students, Integer> {
    @Query("SELECT * FROM  students")
    List<StudentData> getStudentInfo();

    @Query("SELECT students.id,students.studentname,courses.course_name,students.address FROM students\n" +
            "INNER JOIN courses ON students.course_id=courses.course_id;")
    List<CourseData>getStudentCourseDetailsInfo();
}
