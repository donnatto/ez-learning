package com.ezlearning.platform.auth;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;
    @Column(name = "PASSWORD")
    private String password;
}
