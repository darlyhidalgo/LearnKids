# LearnKids

## Descripción
LearnKids es un proyecto de software educativo infantil orientado a la gestión de recursos educativos para niños de 3 a 7 años.

El módulo desarrollado permite registrar, consultar, actualizar y eliminar recursos educativos mediante una conexión entre Java y MySQL.

## Objetivo
Desarrollar un módulo que facilite la administración de recursos educativos, organizando su información en una base de datos.

## Tecnologías utilizadas
- Java.
- MySQL.
- JDBC.
- MySQL Connector/J.
- Git y GitHub.
- Visual Studio Code.
- Laragon.

## Funcionalidades
- Registrar recursos educativos.
- Consultar los recursos registrados.
- Actualizar información de los recursos.
- Eliminar recursos.

## Estructura del proyecto
- src/conexion: conexión con la base de datos.
- src/modelo: modelo de datos de los recursos.
- src/dao: operaciones CRUD.
- src/principal: menú principal y clases de prueba.
- lib: controlador JDBC de MySQL.

## Base de datos
Nombre: learnkids_db

Tabla: recursos_educativos

## Ejecución
1. Iniciar MySQL desde Laragon.
2. Crear la base de datos learnkids_db y la tabla recursos_educativos.
3. Verificar los datos de conexión en ConexionBD.java.
4. Compilar las clases Java.
5. Ejecutar principal.Main.

## Control de versiones
Repositorio GitHub:
https://github.com/darlyhidalgo/LearnKids