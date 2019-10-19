package com.ezlearning.platform.services;

import com.ezlearning.platform.model.Alumno;
import com.ezlearning.platform.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService {

    private AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        super();
        this.alumnoRepository = alumnoRepository;
    }

    public void create(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    public List<Alumno> getAll() {
        List<Alumno> alumnos = new ArrayList<>();
        alumnoRepository.findAll().forEach(alumnos::add);
        return alumnos;
    }

    public void update(@PathVariable Long id_alumno, Alumno alumno) {
        Alumno current = alumnoRepository.findById(id_alumno).get();
        if (current != null) {
            alumno.setId(id_alumno);
            alumnoRepository.save(alumno);
        }
    }

    public void delete(@PathVariable Long id_alumno) {
        alumnoRepository.deleteById(id_alumno);
    }


}
