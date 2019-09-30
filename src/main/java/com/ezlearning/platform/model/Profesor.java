package com.ezlearning.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    private Long id_profesor;

    private String nom_profesor;

    private String ape_profesor;

    private String correo_profesor;

    private String clave_profesor;

    private String descripcion_profesor;

    private List<Curso> curso;
}
