package com.educore.sge.academic.application;

import com.educore.sge.academic.infrastructure.entity.StudentJpaEntity;
import com.educore.sge.academic.infrastructure.entity.StudentStatus;
import com.educore.sge.academic.infrastructure.repository.StudentJpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BajaService {
    private final StudentJpaRepository studentRepository;

    public BajaService(StudentJpaRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void requestBaja(String studentId) {
        StudentJpaEntity student = studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        // El tutor solicita la baja
        student.setStatus(StudentStatus.PENDING_WITHDRAWAL);
        studentRepository.save(student);
    }

    @Transactional
    @PreAuthorize("hasAnyRole('DIRECTOR')")
    public void approveWithdrawal(String studentId) {
        StudentJpaEntity student = studentRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        // La directora aprueba la baja definitiva
        student.setStatus(StudentStatus.WITHDRAWN);
        studentRepository.save(student);
    }
}
