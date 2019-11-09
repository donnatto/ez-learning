package com.ezlearning.platform.controller;

import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.auth.UserRepository;
import com.ezlearning.platform.model.Matricula;
import com.ezlearning.platform.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
public class SecurityController {

    private UserRepository userRepository;
    private MatriculaRepository matriculaRepository;

    @Autowired
    public SecurityController(UserRepository userRepository, MatriculaRepository matriculaRepository) {
        this.userRepository = userRepository;
        this.matriculaRepository = matriculaRepository;
    }

    @GetMapping("/profile")
    public String getUserProfile(Authentication authentication, Model model) {
        try {
            String currentUsername = authentication.getName();
            User user = userRepository.findByUsername(currentUsername);
            List<Matricula> matriculas = matriculaRepository.findAllByUsuario(user);
            int numCursos = matriculas.size();
            model.addAttribute("user", user);
            model.addAttribute("matriculas", matriculas);
            model.addAttribute("numCursos", numCursos);
            return "profile";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }
}
