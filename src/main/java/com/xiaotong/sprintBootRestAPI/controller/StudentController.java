package com.xiaotong.sprintBootRestAPI.controller;

import com.xiaotong.sprintBootRestAPI.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1, "Xiaotong","Wang"
        );
//        return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom_header","xiaotong").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>>getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Xiaotong", "Wang"));
        students.add(new Student(2, "Yuchen", "Zheng"));
        students.add(new Student(3, "Dawang", "Zheng"));
        students.add(new Student(4, "Balala", "Nengliang"));
        return ResponseEntity.ok(students);
    }

    //spring boot REST API with path variable
    @GetMapping("{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") Integer studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

    //spring boot REST API with request param
    //http://localhost:8080/students/query?id=1&firstName=Xiaotong&lastName=Wang
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    //Post request
    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //PUT request
    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //DELETE request
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentID){
        return "Student is deleted successfully";
    }
}
