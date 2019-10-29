package com.ezlearning.platform.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CURSO")
public class Curso {

    @Id
    @Column(name = "CURSO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;
    @Column(name = "NOMBRE", nullable = false, unique = true)
    private String nomCurso;
    @Column(name = "DESCRIPCION")
    private String descripcionCurso;

    public Curso(String nomCurso, String descripcionCurso) {
        this.nomCurso = nomCurso;
        this.descripcionCurso = descripcionCurso;
    }
}
