package com.ezlearning.platform.controller;

import com.ezlearning.platform.dto.ProfesotDto;
import com.ezlearning.platform.model.Profesor;
import com.ezlearning.platform.repositories.ProfesorRepository;
import com.ezlearning.platform.services.ProfesorService;
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
@RequestMapping("/profesores")
public class ProfesorController {

    private ProfesorService profesorService;
    private ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorController(ProfesorService profesorService, ProfesorRepository profesorRepository) {
        this.profesorService = profesorService;
        this.profesorRepository = profesorRepository;
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String addProfesor(Model model) {
        model.addAttribute("profesor", new ProfesotDto());
        return "profesor-add";
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String saveProfesor(ProfesotDto profesor) {
        profesorService.create(profesor);

        return "redirect:/profesores";
    }

    @GetMapping("/edit/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getProfesorForUpdate(@PathVariable Long id_profesor,
                                       Model model) {
        Profesor profesorActual = profesorRepository.findById(id_profesor).get();
        model.addAttribute("profesor", profesorActual);
        return "profesor-edit";
    }

    @PostMapping("/update/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateProfesor(@PathVariable Long id_profesor,
                                 Profesor profesor){
        profesorService.update(profesor);

        return "redirect:/profesores";
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getProfesoresList(Model model) {
        List<Profesor> profesores = profesorService.getAll();
        model.addAttribute("profesores", profesores);
        return "profesores";
    }

    @GetMapping("/delete/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteProfesor(@PathVariable Long id_profesor) {
        Profesor profesorActual = profesorRepository.findById(id_profesor).get();
            profesorService.delete(profesorActual);

        return "redirect:/profesores";
    }
}
