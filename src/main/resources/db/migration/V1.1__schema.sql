CREATE TABLE user (
  user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(128) NOT NULL UNIQUE,
  password VARCHAR(256) NOT NULL
);

CREATE TABLE auth_user_group (
  auth_user_group_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(128) NOT NULL,
  auth_group VARCHAR(128) NOT NULL,
  CONSTRAINT user_auth_user_group_fk FOREIGN KEY(username) REFERENCES user(username),
  UNIQUE (username, auth_group)
);

CREATE TABLE curso (
  curso_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(128) NOT NULL UNIQUE,
  descripcion VARCHAR(256) NOT NULL
);

CREATE TABLE profesor (
    profesor_id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    nombre VARCHAR(128) NOT NULL ,
    apellido VARCHAR(128) NOT NULL ,
    correo VARCHAR(128) NOT NULL ,
    descripcion VARCHAR(256) NOT NULL
)