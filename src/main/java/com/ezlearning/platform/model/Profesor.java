package com.ezlearning.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROFESOR")
public class Profesor {

    @Id
    @Column(name = "PROFESOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profesor;
    @Column(name = "NOMBRE")
    private String nomProfesor;
    @Column(name = "APELLIDO")
    private String apeProfesor;
    @Column(name = "CORREO")
    private String correoProfesor;
    @Column(name = "DESCRIPCION")
    private String descProfesor;


    public Profesor(String nomProfesor, String apeProfesor, String correoProfesor, String descProfesor) {
        this.nomProfesor = nomProfesor;
        this.apeProfesor = apeProfesor;
        this.correoProfesor = correoProfesor;
        this.descProfesor = descProfesor;
    }
}
