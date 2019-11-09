package com.ezlearning.platform.model;

import com.ezlearning.platform.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    @Column(name = "matricula_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_matricula;

    @Column(name = "fecha")
    private LocalDate fecha_matricula;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User usuario;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Matricula(LocalDate fecha_matricula, User usuario, Curso curso) {
        this.fecha_matricula = fecha_matricula;
        this.usuario = usuario;
        this.curso = curso;
    }
}
