package com.ezlearning.platform.repositories;

import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNomCurso(String nombre);
    List<Curso> findAllByProfesor(Profesor profesor);
}
