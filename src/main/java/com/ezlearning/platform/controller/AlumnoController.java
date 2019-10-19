package com.ezlearning.platform.controller;

import com.ezlearning.platform.model.Alumno;
import com.ezlearning.platform.repositories.AlumnoRepository;
import com.ezlearning.platform.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/alumnos")
public class AlumnoController {

    AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }


}
