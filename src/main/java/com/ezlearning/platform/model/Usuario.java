package com.ezlearning.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Usuario {

    private Long id_usuario;

    private String nom_usuario;

    private String ape_usuario;

    private String correo_usuario;

    private String clave_usuario;
}
