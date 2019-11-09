package com.ezlearning.platform.controller;

import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.auth.UserRepository;
import com.ezlearning.platform.dto.CursoDto;
import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.repositories.CursoRepository;
import com.ezlearning.platform.repositories.MatriculaRepository;
import com.ezlearning.platform.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
    private CursoRepository cursoRepository;
    private MatriculaRepository matriculaRepository;
    private UserRepository userRepository;

    @Autowired
    public CursoController(CursoService cursoService, CursoRepository cursoRepository,
                           MatriculaRepository matriculaRepository, UserRepository userRepository) {
        super();
        this.cursoService = cursoService;
        this.cursoRepository = cursoRepository;
        this.matriculaRepository = matriculaRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String addCurso(Model model) {
        model.addAttribute("curso", new CursoDto());
        return "cursos/curso-add";
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String saveCurso(CursoDto curso, Model model) {
        try {
            cursoService.create(curso);
            return "redirect:/cursos";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }

    }

    @GetMapping("/edit/{id_curso}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getCursoForUpdate(@PathVariable Long id_curso, Model model) {
        Curso cursoActual = cursoRepository.findById(id_curso).get();
        model.addAttribute("curso", cursoActual);
        return "cursos/curso-edit";
    }

    @PostMapping("/update/{id_curso}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCurso(@PathVariable Long id_curso, Curso curso) {
        cursoService.update(curso);

        return "redirect:/cursos";
    }

    @GetMapping
    public String getCursosList(Model model) {
        List<Curso> cursos = cursoService.getAll();
        model.addAttribute("cursos", cursos);
        return "cursos/cursos";
    }
    @GetMapping("/delete/{id_curso}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCurso(@PathVariable Long id_curso) {
        Curso cursoActual = cursoRepository.findById(id_curso).get();
        cursoService.delete(cursoActual);

        return "redirect:/cursos";
    }

    @GetMapping("/{id_curso}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getCursoDetail(@PathVariable Long id_curso, Authentication authentication, Model model) {
        String username = authentication.getName();
        Boolean matriculado = false;
        try {
            Curso curso = cursoRepository.findById(id_curso).get();
            User user = userRepository.findByUsername(username);
            if (null != matriculaRepository.findByCursoAndUsuario(curso, user)) {
                matriculado = true;
            }
            model.addAttribute("curso", curso);
            model.addAttribute("matriculado", matriculado);
            return "cursos/curso-detail";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }
}
