package com.example.relic.util;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("students")
public class Students {
    @Id
    public  int id;
    public String studentname;
    public int age;
    public String address;
    public int course_id;
}
