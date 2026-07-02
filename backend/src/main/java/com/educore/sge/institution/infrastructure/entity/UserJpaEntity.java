package com.educore.sge.institution.infrastructure.entity;

import com.educore.sge.shared.BaseInstitutionEntity;
import com.educore.sge.shared.Rol;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserJpaEntity extends BaseInstitutionEntity {
    @Id
    private String id;
    private String email;
    @Enumerated(EnumType.STRING)
    private Rol role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRole() {
        return role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }
}
