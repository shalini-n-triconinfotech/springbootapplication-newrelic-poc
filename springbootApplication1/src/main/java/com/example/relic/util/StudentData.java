package com.example.relic.util;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class StudentData {
    @JsonProperty("Id")
    public  int id;
    @JsonProperty("StudentName")
    public String studentname;
    @JsonProperty("Age")
    public int age;
    @JsonProperty("Address")
    public String address;
    @JsonProperty("CourseId")
    public int course_id;

    public StudentData(Students students) {
        this.id = students.getId();
        this.studentname = students.getStudentname();
        this.age = students.getAge();
        this.address = students.getAddress();
        this.course_id = students.getCourse_id();
    }
}
