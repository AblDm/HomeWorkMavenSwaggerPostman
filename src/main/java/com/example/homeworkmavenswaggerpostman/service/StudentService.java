package com.example.homeworkmavenswaggerpostman.service;

import com.example.homeworkmavenswaggerpostman.model.Student;
import com.example.homeworkmavenswaggerpostman.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService  {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
       return studentRepository.save(student);
    }


    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }


    public Student editStudent(long id, Student student) {
        if (!studentRepository.findAll().contains(id)) {
            return null;
        }
        studentRepository.updateById(id, student.getName(), student.getAge());
        return student;
    }


    public void deleteStudent(long id) {
       studentRepository.deleteById(id);
    }
}
