package com.agrodev.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rut;
    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
    private Set<Materia> materiaList;
}
