package com.ezlearning.platform.controller;

import com.ezlearning.platform.model.Profesor;
import com.ezlearning.platform.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping("/profesores")
    public String getProfesoresList(Model model) {

        List<Profesor> profesores = profesorService.findAll();
        model.addAttribute("profesores", profesores);
        return "profesores";
    }
}
