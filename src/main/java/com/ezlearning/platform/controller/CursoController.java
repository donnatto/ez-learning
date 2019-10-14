package com.ezlearning.platform.controller;

import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CursoController{

    private CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        super();
        this.cursoService = cursoService;
    }

    @GetMapping("/cursos/add")
    public String addCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "curso-add";
    }

    @PostMapping("/cursos/save")
    public String saveCurso(Curso curso, Model model) {
        cursoService.create(curso);

        List<Curso> cursos = cursoService.getAll();
        model.addAttribute("cursos", cursos);
        return "redirect:/cursos";
    }

    @GetMapping("/cursos/edit/{id_curso}")
    public String getCursoForUpdate(@PathVariable Long id_curso, Model model) {
        Curso cursoActual = cursoService.findById(id_curso);
        model.addAttribute("curso", cursoActual);
        return "curso-edit";
    }

    @PostMapping("/cursos/update/{id_curso}")
    public String updateCurso(@PathVariable Long id_curso, Curso curso, Model model) {
        cursoService.update(curso);

        List<Curso> cursos = cursoService.getAll();
        model.addAttribute("cursos", cursos);
        return "redirect:/cursos";
    }

    @GetMapping("/cursos")
    public String getCursosList(Model model) {
        List<Curso> cursos = cursoService.getAll();
        model.addAttribute("cursos", cursos);
        return "cursos";
    }
    @GetMapping("/cursos/delete/{id_curso}")
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
