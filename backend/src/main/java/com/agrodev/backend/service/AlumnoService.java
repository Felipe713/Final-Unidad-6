package com.agrodev.backend.service;

import com.agrodev.backend.model.Alumno;
import com.agrodev.backend.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    public void grabarAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }
}
