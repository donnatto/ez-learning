package com.ezlearning.platform.controller;

import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.model.Profesor;
import com.ezlearning.platform.services.core.impl.CursoService;
import com.ezlearning.platform.services.core.impl.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    private ProfesorService profesorService;
    private CursoService cursoService;

    @Autowired
    public APIController(ProfesorService profesorService, CursoService cursoService) {
        super();
        this.profesorService = profesorService;
        this.cursoService = cursoService;
    }

    @GetMapping("/profesores")
    public List<Profesor> getAllProf() {
        return this.profesorService.getAll();
    }

    @GetMapping("/cursos")
    public List<Curso> getAllCurso() {
        return this.cursoService.getAll();
    }
}
