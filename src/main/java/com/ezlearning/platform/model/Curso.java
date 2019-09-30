package com.ezlearning.platform.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    private Long id_curso;

    private String nom_curso;

    private String descripcion_curso;

    private Profesor profesor;
}
