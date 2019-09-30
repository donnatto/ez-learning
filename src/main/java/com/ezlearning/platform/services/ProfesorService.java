package com.ezlearning.platform.services;

import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.model.Profesor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProfesorService implements GenericService<Profesor, Long> {

    List<Profesor> profesores = new ArrayList<>(
            Arrays.asList(new Profesor(1l, "Nombre Prueba", "Apellido Prueba", "Correo Prueba",
                    "1234", "Profesor de prueba", new ArrayList<Curso>()))
    );

    @Override
    public void create(Profesor profesor) {
        profesores.add(profesor);
    }

    @Override
    public void update(Profesor profesor) {

    }

    @Override
    public void delete(Profesor profesor) {

    }

    @Override
    public List<Profesor> findAll() {
        return null;
    }

    @Override
    public Profesor findById(Long aLong) {
        return null;
    }
}
