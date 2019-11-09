package com.ezlearning.platform.repositories;

import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    List<Matricula> findAllByCurso(Curso curso);
    List<Matricula> findAllByUsuario(User user);
    Matricula findByCursoAndUsuario(Curso curso, User user);
}
