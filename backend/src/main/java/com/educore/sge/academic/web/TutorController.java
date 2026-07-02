package com.educore.sge.academic.web;

import com.educore.sge.academic.infrastructure.entity.TutorJpaEntity;
import com.educore.sge.academic.infrastructure.repository.TutorJpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/tutors")
public class TutorController {

    private final TutorJpaRepository repository;

    public TutorController(TutorJpaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public TutorJpaEntity createTutor(@RequestBody TutorJpaEntity tutor) {
        tutor.setId(UUID.randomUUID().toString());
        return repository.save(tutor);
    }
}
