-- INSERTAR USUARIOS
INSERT INTO user (username, password, nombre, apellido, email) VALUES
('edominguez', '$2a$11$dp4wMyuqYE3KSwIyQmWZFeUb7jCsHAdk7ZhFc0qGw6i5J124imQBi', 'Edwin', 'Dominguez',
 'edwindominguez@hotmail.com'),
('demo', '$2a$11$.NNQgUXukpCuvB5nG.5XGO/NFOESgfPSqETlg5Pj2paBYmStZiucO', 'demo', 'test', 'demo@demo.com');
-- INSERTAR ROLES
INSERT INTO auth_user_group (username, auth_group) VALUES('edominguez', 'USER');
INSERT INTO auth_user_group (username, auth_group) VALUES('edominguez', 'ADMIN');
INSERT INTO auth_user_group (username, auth_group) VALUES('demo', 'USER');
-- INSERTAR PROFESORES
INSERT INTO profesor (nombre, apellido, correo, descripcion)
    VALUES ( 'Esteban', 'Fernandez', 'efernandez@gmail.com', 'Profesor de Java');
INSERT INTO profesor (nombre, apellido, correo, descripcion)
    VALUES ( 'Juana', 'Magdalena', 'jmagdalena@hotmail.com', 'Profesora de UX');
INSERT INTO profesor (nombre, apellido, correo, descripcion)
    VALUES ( 'Pedro', 'Navaja', 'pnavaja@outlook.com', 'Profesor de Python');
INSERT INTO profesor (nombre, apellido, correo, descripcion)
    VALUES ( 'Maria', 'Mercedes', 'Mmercedes@yahoo.com', 'Profesora de algoritmos');
-- INSERTAR CURSOS
INSERT INTO curso (nombre, descripcion, profesor_id) VALUES ( 'Essential Java', 'Curso de Java para beginners', 1);
INSERT INTO curso (nombre, descripcion, profesor_id) VALUES ( 'UX Principles', 'Curso de Experiencia de usuario', 2);
INSERT INTO curso (nombre, descripcion, profesor_id) VALUES ( 'Advanced Python', 'Curso de Python Avanzado', 3);
INSERT INTO curso (nombre, descripcion, profesor_id) VALUES ( 'Algorithms 101', 'Curso de Algoritmos para beginners',4);
-- INSERTAR MATRICULAS
-- INSERT INTO matricula (user_id, curso_id, fecha) VALUES ( 1, 3, '2019-10-10 10:30:00' ),
--                                                         ( 2, 1, '2019-11-01 20:00:00'),
--                                                         ( 2, 4, '2019-11-02 22:00:00' )