package com.ezlearning.platform.controller;

import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.auth.UserRepository;
import com.ezlearning.platform.dto.CursoDto;
import com.ezlearning.platform.model.Curso;
import com.ezlearning.platform.model.Profesor;
import com.ezlearning.platform.repositories.CursoRepository;
import com.ezlearning.platform.repositories.MatriculaRepository;
import com.ezlearning.platform.repositories.ProfesorRepository;
import com.ezlearning.platform.services.core.impl.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController{

    private CursoService cursoService;
    private CursoRepository cursoRepository;
    private MatriculaRepository matriculaRepository;
    private UserRepository userRepository;
    private ProfesorRepository profesorRepository;

    @Autowired
    public CursoController(CursoService cursoService, CursoRepository cursoRepository,
                           MatriculaRepository matriculaRepository, UserRepository userRepository, ProfesorRepository profesorRepository) {
        super();
        this.cursoService = cursoService;
        this.cursoRepository = cursoRepository;
        this.matriculaRepository = matriculaRepository;
        this.userRepository = userRepository;
        this.profesorRepository = profesorRepository;
    }

    @GetMapping("/add/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addCurso(@PathVariable Long id_profesor, Model model) {
        try {
            Profesor current = profesorRepository.findById(id_profesor).get();
            model.addAttribute("curso", new CursoDto());
            model.addAttribute("profesor", current);
            return "cursos/curso-add";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/add/{id_profesor}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveCurso(@PathVariable Long id_profesor, CursoDto curso, Model model) {
        try {
            Profesor current = profesorRepository.findById(id_profesor).get();
            curso.setProfesor(current);
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
        try {
            Curso cursoActual = cursoRepository.findById(id_curso).get();
            model.addAttribute("curso", cursoActual);
            return "cursos/curso-edit";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @PostMapping("/edit/{id_profesor}/{id_curso}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCurso(@PathVariable Long id_profesor, @PathVariable Long id_curso, Curso curso, Model model, RedirectAttributes attributes) {

        try {
            Profesor currentProfesor = profesorRepository.findById(id_profesor).get();
            curso.setProfesor(currentProfesor);

            cursoService.update(curso, id_curso);
            attributes.addAttribute("id_curso", id_curso);

            return "redirect:/cursos/{id_curso}";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

    @GetMapping
    public String getCursosList(Model model) {
        List<Curso> cursos = cursoService.getAll();
        model.addAttribute("cursos", cursos);
        return "cursos/cursos";
    }

    @GetMapping("/delete/{id_curso}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCurso(@PathVariable Long id_curso, Model model) {
        try {
            Curso cursoActual = cursoRepository.findById(id_curso).get();
            cursoService.delete(cursoActual);

            return "redirect:/cursos";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
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
