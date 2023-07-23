package com.example.relic2.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseData {
    @JsonProperty("StudentId")
    public  Integer id;
    @JsonProperty("StudentName")
    public String studentname;
    @JsonProperty("Age")
    public Integer age;
    @JsonProperty("Address")
    public String address;
    @JsonProperty("CourseId")
    public Integer course_id;
    @JsonProperty("Course")
    public String course_name;

}
