package com.ezlearning.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {

    private Long id_matricula;

    private ArrayList<Float> notas;

    private Float nota_final;

    private Usuario usuario;

    private Curso curso;
}
