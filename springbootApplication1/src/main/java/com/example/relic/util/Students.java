package com.example.relic.util;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    public String studentname;
    public Integer age;
    public String address;
    public Integer course_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",insertable = false,updatable = false)
    private Courses courses;
}
