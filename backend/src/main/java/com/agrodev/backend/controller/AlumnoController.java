package com.agrodev.backend.controller;

import com.agrodev.backend.model.Alumno;
import com.agrodev.backend.model.Materia;
import com.agrodev.backend.service.AlumnoService;
import com.agrodev.backend.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AlumnoController {

    @Autowired
    private AlumnoService alumno;

    @Autowired
    private MateriaService materia;

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        return ResponseEntity.ok(alumno.listarAlumnos());
    }

    @PostMapping("/alumnos/grabar")
    public ResponseEntity<String> saveAlumno(@RequestBody Alumno a) {
        try {
            alumno.grabarAlumno(a); // Método corregido
            return ResponseEntity.ok("Alumno creado con éxito");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear alumno", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/materias/grabar")
    public ResponseEntity<String> saveMateria(@RequestBody Materia m) {
        try {
            materia.grabarMateria(m); // Método corregido
            return ResponseEntity.ok("Materia agregada con éxito");
        } catch (Exception e) {
            return new ResponseEntity<>("Error al agregar materia", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
