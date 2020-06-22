package com.ezlearning.platform.services.core.impl;

import com.ezlearning.platform.dto.ProfesotDto;
import com.ezlearning.platform.model.Profesor;
import com.ezlearning.platform.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    private ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public void create(ProfesotDto profesotDto) {
        String nombre = profesotDto.getNombre();
        String apellido = profesotDto.getApellido();
        String correo = profesotDto.getCorreo();
        String descripcion = profesotDto.getDescripcion();
        String imgurl = profesotDto.getImgurl();
        Profesor profesor = new Profesor(nombre, apellido, correo, descripcion, imgurl);

        profesorRepository.save(profesor);
    }

    public List<Profesor> getAll() {
        return profesorRepository.findAll();
    }

    public void update(Profesor profesor) {
        Profesor currentProfesor = profesorRepository.findById(profesor.getId_profesor()).get();

        currentProfesor.setNomProfesor(profesor.getNomProfesor());
        currentProfesor.setApeProfesor(profesor.getApeProfesor());
        currentProfesor.setCorreoProfesor(profesor.getCorreoProfesor());
        currentProfesor.setDescProfesor(profesor.getDescProfesor());
        currentProfesor.setImgurl(profesor.getImgurl());

        profesorRepository.save(currentProfesor);
    }

    public void patch(Profesor profesor) {
        Profesor current = profesorRepository.findById(profesor.getId_profesor()).get();

        current.setDetalleProfesor(profesor.getDetalleProfesor());

        profesorRepository.save(current);
    }

    public void delete(Profesor profesor) {
        profesorRepository.delete(profesor);
    }

}
