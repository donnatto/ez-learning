package com.ezlearning.platform.dto;

import com.ezlearning.platform.model.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CursoDto {
    private String nomCurso;
    private String descCurso;
    private String dificultad;
    private String detalle;
    private String url;
    private String imgurl;
    private Profesor profesor;
}
