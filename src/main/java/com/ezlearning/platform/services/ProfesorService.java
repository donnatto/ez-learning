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
        Profesor profesorActual = findById(profesor.getId_profesor());
        if (profesorActual != null) {
            int index = profesores.indexOf(profesorActual);
            profesor.setId_profesor(profesorActual.getId_profesor());
            profesores.set(index, profesor);
        }
    }

    @Override
    public void delete(Profesor profesor) {
        profesores.remove(profesor);
    }

    @Override
    public List<Profesor> findAll() {
        return profesores;
    }

    @Override
    public Profesor findById(Long id_profesor) {
        Profesor profesor = profesores.stream()
                .filter(p -> p.getId_profesor() == id_profesor).findFirst().orElse(null);
        return profesor;
    }
}
