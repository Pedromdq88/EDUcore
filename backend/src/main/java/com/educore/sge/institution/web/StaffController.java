package com.educore.sge.institution.web;

import com.educore.sge.institution.infrastructure.entity.UserJpaEntity;
import com.educore.sge.institution.infrastructure.repository.UserJpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/institution/staff")
public class StaffController {

    private final UserJpaRepository userRepository;

    public StaffController(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Al poner 'DIRECTOR', permites automáticamente a: DIRECTOR y OWNER.
    // Los roles de ADMINISTRATIVE y TEACHER quedarán bloqueados (403 Forbidden).
    @PreAuthorize("hasRole('DIRECTOR')")
    @PostMapping
    public UserJpaEntity addStaff(@RequestBody UserJpaEntity user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }
}

