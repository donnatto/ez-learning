package com.ezlearning.platform.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @Column(name = "curso_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nomCurso;

    @Column(name = "descripcion")
    private String descripcionCurso;

    @Column(name = "detalle")
    private String detalleCurso;

    @Column(name = "dificultad")
    private String dificultadCurso;

    @Column(name = "url")
    private String urlCurso;

    private String imgurl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profesor_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Profesor profesor;

    public Curso(String nomCurso, String descripcionCurso, String detalleCurso, String dificultadCurso, String urlCurso, String imgurl, Profesor profesor) {
        this.nomCurso = nomCurso;
        this.descripcionCurso = descripcionCurso;
        this.detalleCurso = detalleCurso;
        this.dificultadCurso = dificultadCurso;
        this.urlCurso = urlCurso;
        this.imgurl = imgurl;
        this.profesor = profesor;
    }
}
