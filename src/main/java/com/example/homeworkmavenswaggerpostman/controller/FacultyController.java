package com.example.homeworkmavenswaggerpostman.controller;

import com.example.homeworkmavenswaggerpostman.model.Faculty;
import com.example.homeworkmavenswaggerpostman.model.Student;
import com.example.homeworkmavenswaggerpostman.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable Long id){
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @PutMapping
    public  ResponseEntity <Faculty> editFaculty (@RequestBody Long id, Faculty faculty){
        Faculty findFaculty = facultyService.editFaculty(id, faculty);
        if (findFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(findFaculty);
    }

    @DeleteMapping("{id}")
    public Faculty deleteFaculty (@PathVariable Long id){
        return facultyService.deleteFaculty(id);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> findFaculties(@RequestParam(required = false) String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findByColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
}
