package com.ezlearning.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @Column(name = "profesor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profesor;
    @Column(name = "nombre")
    private String nomProfesor;
    @Column(name = "apellido")
    private String apeProfesor;
    @Column(name = "correo")
    private String correoProfesor;
    @Column(name = "descripcion")
    private String descProfesor;
    @Column(name = "detalle")
    private String detalleProfesor;


    public Profesor(String nomProfesor, String apeProfesor, String correoProfesor, String descProfesor) {
        this.nomProfesor = nomProfesor;
        this.apeProfesor = apeProfesor;
        this.correoProfesor = correoProfesor;
        this.descProfesor = descProfesor;
    }
}
