INSERT INTO user (username, password) VALUES ('edominguez',
                                              '$2a$11$dp4wMyuqYE3KSwIyQmWZFeUb7jCsHAdk7ZhFc0qGw6i5J124imQBi');
INSERT INTO user (username, password) VALUES ('demo', '$2a$11$.NNQgUXukpCuvB5nG.5XGO/NFOESgfPSqETlg5Pj2paBYmStZiucO');
INSERT INTO auth_user_group (username, auth_group) VALUES('edominguez', 'USER');
INSERT INTO auth_user_group (username, auth_group) VALUES('edominguez', 'ADMIN');
INSERT INTO auth_user_group (username, auth_group) VALUES('demo', 'USER');
INSERT INTO curso (nombre, descripcion) VALUES ( 'Essential Java', 'Curso de Java para beginners');
INSERT INTO curso (nombre, descripcion) VALUES ( 'UX Principles', 'Curso de Experiencia de usuario');
INSERT INTO curso (nombre, descripcion) VALUES ( 'Advanced Python', 'Curso de Python Avanzado');
INSERT INTO curso (nombre, descripcion) VALUES ( 'Algorithms 101', 'Curso de Algoritmos para beginners');
INSERT INTO profesor (nombre, apellido, correo, descripcion)
    VALUES ( 'Esteban', 'Fernandez', 'efernandez@gmail.com', 'Profesor de Java');
INSERT INTO profesor (nombre, apellido, correo, descripcion)
    VALUES ( 'Juana', 'Magdalena', 'jmagdalena@hotmail.com', 'Profesora de UX');
INSERT INTO profesor (nombre, apellido, correo, descripcion)
    VALUES ( 'Pedro', 'Navaja', 'pnavaja@outlook.com', 'Profesor de Python');
INSERT INTO profesor (nombre, apellido, correo, descripcion)
    VALUES ( 'Maria', 'Mercedes', 'Mmercedes@yahoo.com', 'Profesora de algoritmos');
