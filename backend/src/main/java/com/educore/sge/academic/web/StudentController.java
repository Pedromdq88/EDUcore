package com.educore.sge.academic.web;

import com.educore.sge.academic.application.StudentTutorService;
import com.educore.sge.academic.infrastructure.entity.StudentJpaEntity;
import com.educore.sge.academic.infrastructure.repository.StudentJpaRepository;
import org.springframework.security.access.prepost.PreAuthorize; // Importante
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentJpaRepository repository;
    private final StudentTutorService studentTutorService;

    public StudentController(StudentJpaRepository repository, StudentTutorService studentTutorService) {
        this.repository = repository;
        this.studentTutorService = studentTutorService;
    }

    // SOLO Directora y Profesora pueden crear alumnos
    @PreAuthorize("hasRole('TEACHER')")
    @PostMapping
    public StudentJpaEntity createStudent(@RequestBody StudentJpaEntity student) {
        student.setId(UUID.randomUUID().toString());
        return repository.save(student);
    }

    // Al poner 'TEACHER', permites automáticamente a: TEACHER, ADMINISTRATIVE, DIRECTOR y OWNER
    @PreAuthorize("hasRole('TEACHER')")
    @PostMapping("/{studentId}/tutors/{tutorId}")
    public void linkTutor(@PathVariable String studentId, @PathVariable String tutorId) {
        studentTutorService.linkTutorToStudent(studentId, tutorId);
    }
}
