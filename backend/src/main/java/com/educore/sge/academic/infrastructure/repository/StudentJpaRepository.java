package com.educore.sge.academic.infrastructure.repository;

import com.educore.sge.academic.infrastructure.entity.StudentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentJpaEntity, String> {
    // No hace falta escribir código SQL, Spring Data hace la magia (save, findAll, findById)
}
