package com.ezlearning.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    private Usuario usuario;

    private String descripcion_profesor;

    private List<Curso> curso;

}
