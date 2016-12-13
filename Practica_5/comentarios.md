# Práctica 5:
## Desarrollo de una aplicación para dispositivos móviles con Android

- Preguntas que sean una imagen, texto con opción multiple y preguntas de canciones (2 botones play/pause).
- Incrustar el navegador para acceder a juegos similares.
- Estadísticas de la última partida.
- Base de datos para las preguntas SQLite

### Clases importantes
#### DBHelper
Especie de DAO que abstraiga el acceso a la base de datos al resto de las clases. `extends SQLiteOpenHelper`

Tiene un atributo SQLiteDatabase

Estructura base de datos: Tabla questions
- 1 columna por respuesta (1 de ellas verdadera)
- Otra columna con la pregunta
- categoría

Métodos para abrir base de daros, actualizar,...

Constructor establece contexto y abre BD.

La base de datos esta guardada en `res/raw` en crudo, dicha base de datos es un create table y una coleccion de inserts.

### Diseñar pantallas
Abrir webView
```
Intent = new Intent(android.context.Intent.ACTION_VIEW);
intent,serData(Uri.parse(direccion));
```

### ¿Qué entregar?
- Proyecto android completo
- Pequeña documentación, como desplegar y usar.
- Si se ha generado APK firmado la direccion desde la que se puede descargar
