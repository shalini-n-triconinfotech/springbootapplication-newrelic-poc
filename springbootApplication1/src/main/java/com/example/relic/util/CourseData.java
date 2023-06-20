package com.example.relic.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CourseData {
    @JsonProperty("StudentId")
    public  int id;
    @JsonProperty("StudentName")
    public String studentname;

    @JsonProperty("Course")
    public String course_name;
    @JsonProperty("Address")
    public String address;
}
