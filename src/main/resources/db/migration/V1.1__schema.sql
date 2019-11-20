CREATE TABLE user (
  user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(128) NOT NULL UNIQUE,
  password VARCHAR(256) NOT NULL,
  nombre VARCHAR(128) NOT NULL,
  apellido VARCHAR(128) NOT NULL,
  email VARCHAR(128) NOT NULL UNIQUE,
  fecha_registro DATE NOT NULL,
  detalle VARCHAR(1024),
  imgurl VARCHAR(1024) NOT NULL
);

CREATE TABLE auth_user_group (
  auth_user_group_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(128) NOT NULL,
  auth_group VARCHAR(128) NOT NULL,
  CONSTRAINT user_auth_user_group_fk FOREIGN KEY(username) REFERENCES user(username),
  UNIQUE (username, auth_group)
);

CREATE TABLE profesor (
    profesor_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(128) NOT NULL,
    apellido VARCHAR(128) NOT NULL,
    correo VARCHAR(128) NOT NULL,
    descripcion VARCHAR(256) NOT NULL,
    detalle VARCHAR(1024),
    imgurl VARCHAR(1024) NOT NULL
);

CREATE TABLE curso (
  curso_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(128) NOT NULL UNIQUE,
  descripcion VARCHAR(256) NOT NULL,
  detalle VARCHAR(1024) NOT NULL ,
  dificultad VARCHAR(128) NOT NULL,
  profesor_id BIGINT NOT NULL,
  url VARCHAR(1024) NOT NULL ,
  imgurl VARCHAR(1024) NOT NULL ,
  CONSTRAINT curso_fk FOREIGN KEY(profesor_id) REFERENCES profesor(profesor_id)
);

CREATE TABLE matricula (
    matricula_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    fecha DATE NOT NULL,
    CONSTRAINT matricula_user_fk FOREIGN KEY(user_id) REFERENCES user(user_id),
    CONSTRAINT matricula_curso_fk FOREIGN KEY(curso_id) REFERENCES curso(curso_id)
);