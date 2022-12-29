package com.xiaotong.sprintBootRestAPI.controller;

import com.xiaotong.sprintBootRestAPI.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1, "Xiaotong","Wang"
        );
        return student;
    }
}
