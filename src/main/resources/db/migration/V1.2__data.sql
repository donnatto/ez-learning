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
INSERT INTO profesor (nombre, apellido, correo, descripcion) VALUES
( 'Esteban', 'Fernandez', 'efernandez@gmail.com', 'Profesor de Java'),
( 'Juana', 'Magdalena', 'jmagdalena@hotmail.com', 'Profesora de UX'),
( 'Pedro', 'Navaja', 'pnavaja@outlook.com', 'Profesor de Python'),
( 'Maria', 'Mercedes', 'mmercedes@yahoo.com', 'Profesora de algoritmos'),
('Alberto', 'Ibarra', 'aibarra@hotmail.com', 'Profesor de HTML'),
('Jose', 'Domingo', 'jdomingo@hotmail.com', 'Profesor de Linux'),
('Stefany', 'Carranza', 'scarranza@gmail.com', 'Profesora de Javascript'),
('Ismael', 'Lopez', 'slopez@outlook.com', 'Profesor de Base de Datos');
-- INSERTAR CURSOS
INSERT INTO curso (nombre, descripcion, profesor_id, detalle, dificultad) VALUES
( 'Essential Java', 'Curso de Java para beginners', 1, 'Si lo que buscas es aprender a programar en Java con este ' ||
                                                       'curso obtendrás conocimientos de programación orientada a ' ||
                                                       'objetos a través de uso y manejo del lenguaje. Asimismo, con ' ||
                                                       'el curso de java desarrollarás aplicaciones en consola, ' ||
                                                       'formularios y applets, jsp para internet y muchas cosas más' ||
                                                       '.', 'Facil'),
( 'UX Principles', 'Curso de Experiencia de usuario', 2, 'Sobran muchas razones para explicar por qué debes entrar al' ||
                                                         ' mundo del “User Experience” pero antes de empezar a ' ||
                                                         'enumerarlas, ¿sabes qué es el “UX”. El UX en español es ' ||
                                                         'traducido como la experiencia del usuario. En términos ' ||
                                                         'generales es lo que una persona percibe al interactuar con ' ||
                                                         'una plataforma. Se considera un buen UX cuando el diseño, ' ||
                                                         'acomodo de elementos y usabilidad ayudan a que la ' ||
                                                         'navegación sea amigable y fácil de usar.', 'Facil'),
( 'Advanced Python', 'Curso de Python Avanzado',3, 'El Curso Avanzado de Python es una formación 100 % online ' ||
                                                   'dedicada a abordar las características más novedosas del lenguaje' ||
                                                   '. Con un carácter práctico, permitirá dominar las recientes ' ||
                                                   'mejoras de la tecnología en la realización de todo tipo de ' ||
                                                   'proyectos.', 'Avanzado'),
( 'Algorithms 101', 'Curso de Algoritmos para beginners',4, 'En la base de cada solución en programación, hay un ' ||
                                                            'algoritmo, en este curso vamos a introducirte a la ' ||
                                                            'terminología, las formas y el diseño de algoritmos. Este' ||
                                                            ' curso forma parte de nuestra especialidad de ' ||
                                                            'Introducción a la Programación, y te enseñanza a ' ||
                                                            'solucionar problemas con algoritmos.', 'Facil'),
( 'HTML Basics', 'Curso de HTML para beginners', 5, 'HTML es el lenguaje sobre el que está construida toda la web y ' ||
                                                    'su estándar HTML5 la revolucionó por completo haciendo del ' ||
                                                    'navegador el programa más usado en el mundo. Este curso fue ' ||
                                                    'dictado en la Facultad de Ingeniería de Sistemas de la ' ||
                                                    'Universidad Nacional Mayor de San Marcos en Lima, Perú y es ' ||
                                                    'ofrecido completamente gratis para que comiences tu carrera en ' ||
                                                    'el desarrollo web.', 'Facil'),
( 'Advanced HTML', 'Curso de HTML Avanzado', 5, 'Aprende APIs de HTML5 que te permitirán crear aplicaciones web con ' ||
                                                'capacidades extendidas, acceso al hardware del equipo del usuario, ' ||
                                                'geolocalización, storage en el cliente y mucho más. Aprender las ' ||
                                                'API''s que HTML5 introdujo te ayudará a expandir el entendimiento de' ||
                                                ' lo que las páginas pueden hacer.', 'Intermedio'),
( 'Linux Essentials', 'Curso de Linux básico', 6, 'Linux es el sistema operativo con mayor adopción para la ' ||
                                                  'administración de servidores en Internet. Domina la administración' ||
                                                  ' del sistema operativo, archivos, permisos, usuarios y paquetes. ' ||
                                                  'Utiliza herramientas para monitorear servicios y procesos. ' ||
                                                  'Establece tareas programadas. Configura la seguridad de tu ' ||
                                                  'servidor y red para reducir vulnerabilidades.', 'Facil'),
( 'Bash Shell', 'Curso de terminal de Linux', 6, 'Todos los sistemas operativos se pueden programar y expresar en ' ||
                                                 'comandos. Por ejemplo en Windows es CMD, en Mac y Linux es la ' ||
                                                 'terminal o el “Shell”. El lenguaje es conocido como “Bash”. Con ' ||
                                                 'Bash-Shell puedes: manipular archivos y carpetas, ejecutar ' ||
                                                 'aplicaciones, conectar una Apps, automatizar procesos repetitivos y' ||
                                                 ' preparar desde tu computadora personal hasta una nube de ' ||
                                                 'servidores.', 'Intermedio'),
( 'JavaScript Essential Training', 'Curso de Javascript Básico',7, 'Aprende a fondo JavaScript, el lenguaje de ' ||
                                                                   'programación más usado en el mundo detrás de los ' ||
                                                                   'ancestrales C y Java, es un lenguaje con el que ' ||
                                                                   'puedes programar en el Frontend de una página ' ||
                                                                   'web, como también en el Backend, además también ' ||
                                                                   'puedes generar aplicaciones híbridas para ' ||
                                                                   'teléfonos y mucho más. El curso te enseña desde ' ||
                                                                   'lo básico, hasta EcmaScript 5 y EcmaScript 6, las' ||
                                                                   ' versiones más nuevas de Javascript.', 'Facil'),
( 'Advanced JavaScript', 'Curso de Javascript Avanzado',7, 'Mejora tus habilidades en Javascript. Conoce Typescript y' ||
                                                           ' cómo puedes ocuparlo para mejorar el control de tus ' ||
                                                           'variables. Comprende conceptos avanzados que te permitan ' ||
                                                           'plantear mejores soluciones en tu código. Conoce las APIs' ||
                                                           ' del DOM y descubre cómo puedes organizar mejor tu código' ||
                                                           ' utilizando patrones de diseño.', 'Intermedio'),
( 'NodeJS Essential Training', 'Curso de backend con NodeJS',7, 'Crea aplicaciones backend utilizando Node.js, ' ||
                                                                'Express y Mongo. Entiende cómo funciona Javascript ' ||
                                                                'en un servidor y escribe aplicaciones con Node.js. ' ||
                                                                'Crea una API, manipula errores y valida tus datos ' ||
                                                                'con Express. Elabora pruebas para encontrar errores ' ||
                                                                'en tu código y finalmente pon tu aplicación en ' ||
                                                                'producción en un servicio web.', 'Avanzado'),
( 'SQL Essential Training', 'Curso de SQL Básico',8, 'Conoce el mundo de las bases de datos para entender cómo ' ||
                                                     'trabajan, cómo se instalan, y las diferencias entre las ' ||
                                                     'distintas marcas (SQL Server, MySQL, Oracle, etc.). Aprende lo ' ||
                                                     'fundamental para el manejo y manipulación de datos.', 'Facil'),
( 'Advanced SQL', 'Curso de SQL Avanzado',8, 'En este curso aprenderás las reglas que se deben considerar durante el ' ||
                                             'proceso de elaboración de modelos de base de datos y de diseño de una ' ||
                                             'base datos, así como, el lenguaje necesario para la creación de sus ' ||
                                             'objetos y manipulación de información desde un gestor de base de datos' ||
                                             '.', 'Avanzado'),
( 'MongoDB Essential Training', 'Curso de MongoDB',8, 'Domina las bases de MongoDB, el motor de NoSQL que provee alta' ||
                                                      ' capacidad de almacenamiento. Optimiza tus procesos gracias a ' ||
                                                      'la velocidad de consulta y aprovecha la escalabilidad de este ' ||
                                                      'tipo de bases de datos en tus proyectos.', 'Intermedio');
-- INSERTAR MATRICULAS
-- INSERT INTO matricula (user_id, curso_id, fecha) VALUES ( 1, 3, '2019-10-10 10:30:00' ),
--                                                         ( 2, 1, '2019-11-01 20:00:00'),
--                                                         ( 2, 4, '2019-11-02 22:00:00' )