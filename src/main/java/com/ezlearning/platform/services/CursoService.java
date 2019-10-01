package com.ezlearning.platform.services;

import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.model.Profesor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CursoService implements GenericService<Curso, Long>{

    List<Curso> cursos = new ArrayList<>(
            Arrays.asList(new Curso(1L, "Essential Java", "Curso de Java para beginners", new Profesor()),
                    new Curso(2L, "UX Principles", "Curso de Experiencia de Usuario", new Profesor()))
    );

    @Override
    public void create(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public void update(Curso curso) {
        Curso currentCurso = findById(curso.getId_curso());
        if (currentCurso != null) {
            int index = cursos.indexOf(currentCurso);
            curso.setId_curso(currentCurso.getId_curso());
            cursos.set(index, curso);
        }
    }

    @Override
    public void delete(Curso curso) { cursos.remove(curso); }

    @Override
    public List<Curso> getAll() {
        return cursos;
    }

    @Override
    public Curso findById(Long id_curso) {
        Curso curso = cursos.stream()
                .filter(p -> p.getId_curso() == id_curso).findFirst().orElse(null);
        return curso;
    }
}
