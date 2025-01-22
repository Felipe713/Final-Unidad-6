package com.agrodev.backend.repository;

import com.agrodev.backend.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    Alumno findByRut(String rut);
}
