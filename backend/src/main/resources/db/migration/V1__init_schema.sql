-- ===================================================================================
-- EDUCORE SGE - MIGRACIÓN V1: ESQUEMA INICIAL MULTI-TENANT
-- ===================================================================================

-- 1. Tabla maestra de Instituciones (Colegios)
CREATE TABLE tenants (
                       id VARCHAR(36) PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       slug VARCHAR(100) UNIQUE NOT NULL,
                       status VARCHAR(50) NOT NULL DEFAULT 'ACTIVE',
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Tabla de Alumnos
CREATE TABLE students (
                        tenant_id VARCHAR(36) NOT NULL,
                        id VARCHAR(36) NOT NULL,
                        first_name VARCHAR(100) NOT NULL,
                        last_name VARCHAR(100) NOT NULL,
                        document_number VARCHAR(50) NOT NULL,
                        birth_date DATE NOT NULL,

                        PRIMARY KEY (tenant_id, id),
                        FOREIGN KEY (tenant_id) REFERENCES tenants(id)
);
