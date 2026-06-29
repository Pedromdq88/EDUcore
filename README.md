# EduCore SGE

Sistema de Gestión Escolar SaaS multi-tenant para instituciones educativas.

## Arquitectura objetivo

Monolito modular con arquitectura hexagonal y DDD táctico.

## Stack objetivo

- Backend: Java 25 LTS y Spring Boot 4.x estable.
- Frontend: Angular 22.
- Base de datos: PostgreSQL 18.
- Infraestructura: Docker, GitHub Actions y AWS.

## Multi-tenancy

Base de datos y esquema compartidos, con `tenant_id` obligatorio y Row Level Security de PostgreSQL como defensa en profundidad.

## Forma de trabajo

Cada ticket se implementa en una branch y un PR pequeño, se valida y se integra en `develop`.

El MVP inicial está enfocado en Nivel Inicial (Kindergarten-first), manteniendo un modelo genérico preparado para múltiples niveles educativos.

## Documentos fuente

- `V3_1_PRODUCT_BLUEPRINT.md`
- `V3_1_CODEX_IMPLEMENTATION_ROADMAP.md`
- `V3_1_AGENTS.md`
- `V3_1_ARB_AUDIT_AND_DECISIONS.md`
- `V3_1_ADR_0003_java25_springboot4_angular22_stack.md`
- `V3_1_ADR_0006_auth_rs256_refresh_rotation.md`
- `Foundation Solo Bootstrap - EduCore SGE.md`
- `MVP Kindergarten-First Scope — EduCore SGE.md`

Estos documentos forman parte del paquete documental del proyecto y no se copian al repositorio en este ticket.
