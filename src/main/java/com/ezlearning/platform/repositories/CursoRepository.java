package com.ezlearning.platform.repositories;

import com.ezlearning.platform.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNomCurso(String nombre);
}
