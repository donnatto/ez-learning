package com.ezlearning.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ALUMNO")
public class Alumno{

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String correo;
    @Column
    private String clave;

}
