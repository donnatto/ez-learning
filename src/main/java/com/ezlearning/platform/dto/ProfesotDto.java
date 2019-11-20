package com.ezlearning.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesotDto {
    private String nombre;
    private String apellido;
    private String correo;
    private String descripcion;
    private String imgurl;
}
