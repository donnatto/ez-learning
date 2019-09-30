package com.ezlearning.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private Long id_usuario;

    private String nom_usuario;

    private String ape_profesor;

    private String correo_usuario;

    private String clave_usuario;
}
