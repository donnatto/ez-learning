package com.ezlearning.platform.controller;

import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.auth.UserRepository;
import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.repositories.CursoRepository;
import com.ezlearning.platform.services.core.impl.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/matricula")
@PreAuthorize("hasRole('ROLE_USER')")
public class MatriculaController {

    private MatriculaService matriculaService;
    private UserRepository userRepository;
    private CursoRepository cursoRepository;

    @Autowired
    public MatriculaController(MatriculaService matriculaService, UserRepository userRepository, CursoRepository cursoRepository) {
        this.matriculaService = matriculaService;
        this.userRepository = userRepository;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("/save/{id_curso}")
    public String saveMatricula(@PathVariable Long id_curso, Authentication authentication, Model model) {
        try {
            String username = authentication.getName();
            matriculaService.createMatricula(id_curso, username);
            User user = userRepository.findByUsername(username);
            Curso curso = cursoRepository.findById(id_curso).get();
            model.addAttribute("curso", curso);
            model.addAttribute("user", user);
            return "matricula-success";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }
}
