package com.ezlearning.platform.services.core.impl;

import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.auth.UserRepository;
import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.model.Matricula;
import com.ezlearning.platform.repositories.CursoRepository;
import com.ezlearning.platform.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MatriculaService {

    private MatriculaRepository matriculaRepository;
    private CursoRepository cursoRepository;
    private UserRepository userRepository;

    @Autowired
    public MatriculaService(MatriculaRepository matriculaRepository, CursoRepository cursoRepository, UserRepository userRepository) {
        this.matriculaRepository = matriculaRepository;
        this.cursoRepository = cursoRepository;
        this.userRepository = userRepository;
    }

    public void createMatricula(Long id_curso, String username) throws Exception {
        Curso curso = cursoRepository.findById(id_curso).get();
        User user = userRepository.findByUsername(username);

        if (null != matriculaRepository.findByCursoAndUsuario(curso, user)) {
            throw new Exception("Ya se encuentra matriculado en este curso");
        }
        LocalDate date = LocalDate.now();
        Matricula matricula = new Matricula(date, user, curso);
        matriculaRepository.save(matricula);
    }
}
