package com.example.homeworkmavenswaggerpostman.service;

import com.example.homeworkmavenswaggerpostman.model.Faculty;
import com.example.homeworkmavenswaggerpostman.repository.FacultyRepository;
import org.springframework.stereotype.Service;


@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }



    public Faculty createFaculty (Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFacultyById(Long id) {
        return facultyRepository.findById(id).get();
    }
    public void deleteFacultyById(Long id) {
        facultyRepository.deleteById(id);
    }

    public Faculty editFaculty (Long id, Faculty faculty) {
        if (!facultyRepository.findAll().contains(id)) {
            return null;
        }
       return facultyRepository.updateById(id, faculty.getName(),faculty.getColor());
    }



    public Faculty findByColor(String color) {
        return facultyRepository.findByColor(color).get(Integer.parseInt(color));
        }
    }

