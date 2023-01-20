package com.example.homeworkmavenswaggerpostman.controller;

import com.example.homeworkmavenswaggerpostman.model.Student;
import com.example.homeworkmavenswaggerpostman.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent (@PathVariable Long id){
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent (@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Long id, @RequestBody Student student) {
        Student foundStudent = studentService.editStudent(id, student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public void deleteStudent (@PathVariable Long id){
         studentService.deleteStudent(id);
    }
}
