package com.ezlearning.platform.controller;

import com.ezlearning.platform.model.Profesor;
import com.ezlearning.platform.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {

    private ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping("/add")
    public String addProfesor(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "profesor-add";
    }

    @PostMapping("/save")
    public String saveProfesor(Profesor profesor,
                               Model model) {
        profesorService.create(profesor);

        List<Profesor> profesores = profesorService.getAll();
        model.addAttribute("profesores", profesores);
        return "redirect:/profesores";
    }

    @GetMapping("/edit/{id_profesor}")
    public String getProfesorForUpdate(@PathVariable Long id_profesor,
                                       Model model) {
        Profesor profesorActual = profesorService.findById(id_profesor);
        model.addAttribute("profesor", profesorActual);
        return "profesor-edit";
    }

    @PostMapping("/update/{id_profesor}")
    public String updateProfesor(@PathVariable Long id_profesor,
                                 Profesor profesor,
                                 Model model){
        profesorService.update(profesor);

        List<Profesor> profesores = profesorService.getAll();
        model.addAttribute("profesores", profesores);
        return "redirect:/profesores";
    }

    @GetMapping
    public String getProfesoresList(Model model) {

        List<Profesor> profesores = profesorService.getAll();
        model.addAttribute("profesores", profesores);
        return "profesores";
    }

    @GetMapping("/delete/{id_profesor}")
    public String deleteProfesor(@PathVariable Long id_profesor,
                                 Model model) {
        Profesor profesorActual = profesorService.findById(id_profesor);
        if (profesorActual != null) {
            profesorService.delete(profesorActual);
        }

        List<Profesor> profesores = profesorService.getAll();
        model.addAttribute("profesores", profesores);
        return "redirect:/profesores";
    }
}
