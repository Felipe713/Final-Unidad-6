package com.agrodev.frontend.model;

import lombok.Data;
import java.util.Set;

@Data
public class Alumno {
    private Long id;
    private String nombre;
    private String rut;
    private Set<Materia> materias;
}
