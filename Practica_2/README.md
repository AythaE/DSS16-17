#Práctica 2
##Descripción de contenido
- `Tutorial-JPA.pdf` Guía de la practica 2.
- `Programacion OO con persistencia de entidades/` Contiene la segunda prática entregable

##Enunciado de la práctica 2

Utilizando JPA, se pide programar una aplicación para crear Listas de Correo que utilizará un canal (DBUsuario) para escribir los datos de los usuarios de una Lista de Correo en una base de datos. La aplicación ha de utilizar un "connection pool" para permitir conectar rápidamente las hebras de usuarios a la base de datos.

![alt text](https://raw.githubusercontent.com/AythaE/DSS16-17/master/Practica_2/Imagenes/ListaCorreosAplicacion-fig.png "Arquitectura práctica 2")

![alt text](https://raw.githubusercontent.com/AythaE/DSS16-17/master/Practica_2/Imagenes/ListaCorreosServlet-fig.png "Arquitectura servlet")

Ejecutar la aplicación como un proyecto Java en un IDE y utilizarla para añadir usuarios a la lista de correo. Utilizar Workbench o una herramienta similar para ver las tablas de la base de datos, la cual deberá incluir una tabla llamada "usuario"  con columnas que se corresponderán con los campos de la clase Usuario (leer más abajo).

Crear una aplicación de **Administración de Usuarios** que permita visualizar a todos los usuarios, actualizar los usuarios existentes y eliminar los usuarios almacenados en la tabla Usuario de la base de datos.

##Entorno de trabajo
- JDK 1.8.0_111
- Eclipse Java EE IDE for Web Developers. Version: Mars.2 Release (4.5.2)
- Apache Tomcat 8.0.14
- Debian 8.6
- EclipseLink 2.6.4
- Derby 10.13.1.1
- JPA 2.1
