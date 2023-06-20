package com.example.relic2.util;
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
}
