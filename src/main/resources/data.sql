INSERT INTO USER (USERNAME, PASSWORD) VALUES ('edominguez',
                                              '$2a$11$dp4wMyuqYE3KSwIyQmWZFeUb7jCsHAdk7ZhFc0qGw6i5J124imQBi');
INSERT INTO USER (USERNAME, PASSWORD) VALUES ('demo', '$2a$11$.NNQgUXukpCuvB5nG.5XGO/NFOESgfPSqETlg5Pj2paBYmStZiucO');
INSERT INTO AUTH_USER_GROUP (USERNAME, AUTH_GROUP) VALUES('edominguez', 'USER');
INSERT INTO AUTH_USER_GROUP (USERNAME, AUTH_GROUP) VALUES('edominguez', 'ADMIN');
INSERT INTO AUTH_USER_GROUP (USERNAME, AUTH_GROUP) VALUES('demo', 'USER');
INSERT INTO CURSO (NOMBRE, DESCRIPCION) VALUES ( 'Essential Java', 'Curso de Java para beginners');
INSERT INTO CURSO (NOMBRE, DESCRIPCION) VALUES ( 'UX Principles', 'Curso de Experiencia de usuario');
INSERT INTO CURSO (NOMBRE, DESCRIPCION) VALUES ( 'Advanced Python', 'Curso de Python Avanzado');
INSERT INTO CURSO (NOMBRE, DESCRIPCION) VALUES ( 'Algorithms 101', 'Curso de Algoritmos para beginners');
INSERT INTO PROFESOR (NOMBRE, APELLIDO, CORREO, DESCRIPCION)
    VALUES ( 'Esteban', 'Fernandez', 'efernandez@gmail.com', 'Profesor de Java');
INSERT INTO PROFESOR (NOMBRE, APELLIDO, CORREO, DESCRIPCION)
    VALUES ( 'Juana', 'Magdalena', 'jmagdalena@hotmail.com', 'Profesora de UX');
INSERT INTO PROFESOR (NOMBRE, APELLIDO, CORREO, DESCRIPCION)
    VALUES ( 'Pedro', 'Navaja', 'pnavaja@outlook.com', 'Profesor de Python');
INSERT INTO PROFESOR (NOMBRE, APELLIDO, CORREO, DESCRIPCION)
    VALUES ( 'Maria', 'Mercedes', 'Mmercedes@yahoo.com', 'Profesora de algoritmos');
