package com.xiaotong.sprintBootRestAPI.controller;

import com.xiaotong.sprintBootRestAPI.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1, "Xiaotong","Wang"
        );
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Xiaotong", "Wang"));
        students.add(new Student(2, "Yuchen", "Zheng"));
        students.add(new Student(3, "Dawang", "Zheng"));
        students.add(new Student(4, "Balala", "Nengliang"));
        return students;
    }

    //spring boot REST API with path variable
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") Integer studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }
}
