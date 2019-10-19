package com.ezlearning.platform.controller;

import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController{

    private CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        super();
        this.cursoService = cursoService;
    }

    @GetMapping("/add")
    public String addCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "curso-add";
    }

    @PostMapping("/save")
    public String saveCurso(Curso curso, Model model) {
        cursoService.create(curso);

        List<Curso> cursos = cursoService.getAll();
        model.addAttribute("cursos", cursos);
        return "redirect:/cursos";
    }

    @GetMapping("/edit/{id_curso}")
    public String getCursoForUpdate(@PathVariable Long id_curso, Model model) {
        Curso cursoActual = cursoService.findById(id_curso);
        model.addAttribute("curso", cursoActual);
        return "curso-edit";
    }

    @PostMapping("/update/{id_curso}")
    public String updateCurso(@PathVariable Long id_curso, Curso curso, Model model) {
        cursoService.update(curso);

        List<Curso> cursos = cursoService.getAll();
        model.addAttribute("cursos", cursos);
        return "redirect:/cursos";
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getCursosList(Model model) {
        List<Curso> cursos = cursoService.getAll();
        model.addAttribute("cursos", cursos);
        return "cursos";
    }
    @GetMapping("/delete/{id_curso}")
    public String deleteCurso(@PathVariable Long id_curso, Model model) {
        Curso cursoActual = cursoService.findById(id_curso);
        if (cursoActual != null) {
            cursoService.delete(cursoActual);
        }

        List<Curso> cursos = cursoService.getAll();
        model.addAttribute("cursos", cursos);
        return "redirect:/cursos";
    }
}
