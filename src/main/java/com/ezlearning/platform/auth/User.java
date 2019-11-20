package com.ezlearning.platform.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    private String detalle;
    private String imgurl;
    @Column(name = "fecha_registro")
    private LocalDate fecha;

    public User(String username, String password, String nombre, String apellido, String email, String imgurl, LocalDate fecha) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imgurl = imgurl;
        this.fecha = fecha;
    }

    public User(String detalle) {
        this.detalle = detalle;
    }
}
