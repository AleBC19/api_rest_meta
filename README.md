# API RESTful de Gestión de Tareas con Spring Boot

Este proyecto consiste en una **API RESTful** desarrollada con **Spring Boot** para la gestión de tareas. Utiliza una base de datos **MySQL** para almacenar la información y cuenta con autenticación mediante **Spring Security**.

## Base de Datos

Se creó una base de datos llamada `task` con dos tablas principales:

### Tabla: `users`

- `iduser`: Identificador único del usuario (PRIMARY KEY).
- `username`: Nombre de usuario.
- `password`: Contraseña del usuario.

### Tabla: `tasks`

- `idtask`: Identificador único de la tarea (PRIMARY KEY).
- `description`: Descripción de la tarea.
- `state`: Estado de la tarea (pendiente, completada, etc.).
- `iduser`: Llave foránea que referencia a la tabla `users`.

## Funcionalidades del CRUD

La API permite realizar operaciones CRUD sobre las tareas:

- **Crear** una nueva tarea.
- **Leer** (listar o consultar) tareas.
- **Actualizar** una tarea existente.
- **Eliminar** una tarea.

Tambien permite realizar operaciones CRUD sobre los usuarios :

- **Crear** un nuevo usuario.
- **Leer** (listar o consultar) usuarios.
- **Actualizar** un usuario existente.
- **Eliminar** un usuario.

Cada operación incluye un manejo adecuado de **excepciones** y mensajes de error para garantizar una correcta comunicación con el cliente.

## Seguridad

Se implementó seguridad con **Spring Security**. El flujo de autenticación funciona así:

1. El usuario debe autenticarse mediante el endpoint: POST /auth/login
enviando su `username` y `password` como body.

2. Si las credenciales son correctas, la API responde con un **token JWT**.

3. Para acceder a los endpoints protegidos, el cliente debe incluir ese token en la cabecera de sus peticiones.

## Control de Versiones

El proyecto está versionado con **Git** y alojado en **GitHub**, permitiendo llevar un control detallado de los cambios realizados durante el desarrollo.

https://github.com/AleBC19/api_rest_meta

---

Este backend está listo para integrarse con cualquier cliente frontend o aplicaciones móviles que consuman los servicios RESTful expuestos.
