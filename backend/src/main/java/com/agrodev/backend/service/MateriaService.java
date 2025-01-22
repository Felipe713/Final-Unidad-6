package com.agrodev.backend.service;

import com.agrodev.backend.model.Materia;
import com.agrodev.backend.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public void grabarMateria(Materia materia) {
        materiaRepository.save(materia);
    }
}

