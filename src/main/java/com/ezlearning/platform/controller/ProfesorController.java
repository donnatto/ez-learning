package com.ezlearning.platform.controller;

import com.ezlearning.platform.dto.ProfesotDto;
import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.model.Profesor;
import com.ezlearning.platform.repositories.CursoRepository;
import com.ezlearning.platform.repositories.ProfesorRepository;
import com.ezlearning.platform.services.core.impl.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {

    private ProfesorService profesorService;
    private ProfesorRepository profesorRepository;
    private CursoRepository cursoRepository;

    @Autowired
    public ProfesorController(ProfesorService profesorService, ProfesorRepository profesorRepository,
                              CursoRepository cursoRepository) {
        this.profesorService = profesorService;
        this.profesorRepository = profesorRepository;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String addProfesor(Model model) {
        model.addAttribute("profesor", new ProfesotDto());
        return "profesores/profesor-add";
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
        try {
            Profesor profesorActual = profesorRepository.findById(id_profesor).get();
            model.addAttribute("profesor", profesorActual);
            return "profesores/profesor-edit";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/update/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateProfesor(@PathVariable Long id_profesor,
                                 Profesor profesor, RedirectAttributes attributes, Model model){

        try {
            Profesor currentProfesor = profesorRepository.findById(id_profesor).get();
            currentProfesor.setNomProfesor(profesor.getNomProfesor());
            currentProfesor.setApeProfesor(profesor.getApeProfesor());
            currentProfesor.setCorreoProfesor(profesor.getCorreoProfesor());
            currentProfesor.setDescProfesor(profesor.getDescProfesor());
            currentProfesor.setImgurl(profesor.getImgurl());

            profesorService.update(profesor);
            attributes.addAttribute("id_profesor", id_profesor);

            return "redirect:/profesores/{id_profesor}";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/patch/{id_profesor}")
    public String patchProfesor(@PathVariable Long id_profesor, Profesor profesor, RedirectAttributes attributes, Model model) {

        try {
            Profesor current = profesorRepository.findById(id_profesor).get();
            current.setDetalleProfesor(profesor.getDetalleProfesor());
            profesorService.patch(current);

            attributes.addAttribute("id_profesor", id_profesor);
            return "redirect:/profesores/{id_profesor}";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getProfesoresList(Model model) {
        List<Profesor> profesores = profesorService.getAll();
        model.addAttribute("profesores", profesores);
        return "profesores/profesores";
    }

    @GetMapping("/delete/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteProfesor(@PathVariable Long id_profesor, Model model) {
        try {
            Profesor profesorActual = profesorRepository.findById(id_profesor).get();
            profesorService.delete(profesorActual);

            return "redirect:/profesores";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @GetMapping("/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getProfesorDetail(@PathVariable Long id_profesor, Model model) {
        try {
            Profesor profesor = profesorRepository.findById(id_profesor).get();
            model.addAttribute("profesor", profesor);
            List<Curso> cursos = cursoRepository.findAllByProfesor(profesor);
            model.addAttribute("cursos", cursos);
            return "profesores/profesor-detail";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }
}
