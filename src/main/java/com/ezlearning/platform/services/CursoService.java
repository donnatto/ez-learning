package com.ezlearning.platform.services;

import com.ezlearning.platform.dto.CursoDto;
import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService{

    private CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public void create(CursoDto cursoDto) throws Exception{
        if (null != cursoRepository.findByNomCurso(cursoDto.getNomCurso())) {
            throw new Exception("Ya existe un curso con el nombre " + cursoDto.getNomCurso());
        }
        String nomCurso = cursoDto.getNomCurso();
        String descCurso = cursoDto.getDescCurso();
        Curso curso = new Curso(nomCurso, descCurso);

        cursoRepository.save(curso);
    }

    public void update(Curso curso) {
        Curso currentCurso = cursoRepository.findById(curso.getId_curso()).get();

            currentCurso.setNomCurso(curso.getNomCurso());
            currentCurso.setDescripcionCurso(curso.getDescripcionCurso());

            cursoRepository.save(currentCurso);

    }

    public void delete(Curso curso) { cursoRepository.delete(curso); }


    public List<Curso> getAll() {
        return cursoRepository.findAll();
    }

}
