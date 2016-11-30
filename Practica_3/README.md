 # Práctica 3
## Descripción de contenido
- `P3-present.pdf` Guía de la practica 3.
- `ServicioRestCRUDJava/` Contiene la tercera prática entregable
- `REST.pdf` Apuntes sobre APIs REST en Java de la asignatura Sistemas Distribuidos de 4º del Grado de Ingeniería Informática de la Universidad de Salamanca, por [@rodrigoSantamaria](https://github.com/rodrigoSantamaria)

## Enunciado de la práctica 3

Un  servicio web que llamaremos 'CRUD' (Create, Read, Update, Delete), que ha de ser RESTful y que nos permitirá mantener una lista de objetos de un determinado dominio de libre elección (reseñas bibliográficas, catálogo de coches, etc..), pero que ha de incorporar imágenes y sonidos, en nuestra aplicación Web a través de llamadas HTTP.

- Nos crearemos un modelo de datos y también una clase Singleton (no admite más de 1 instancia) que servirá como el proveedor de datos para el modelo.

- Utilizaremos una clase basada en enumeración para representar un "proveedor de contenidos":

```
...
import java.util.HashMap;

import java.util.Map;

public enum TodoDao {

  instance;

  private Map<String, Todo> contentProvider = new HashMap<String, Todo>();

  private TodoDao() {

    Todo todo = new Todo("1", "Aprender REST");

    todo.setDescripcion("Leer http://...");

    contentProvider.put("1", todo);

    todo = new Todo("2", "Aprender algo sobre DSBCS");

    todo.setDescripcion("Leer todo el material de http://...");

    contentProvider.put("2", todo); 

  }

  public Map<String, Todo> getModel(){

    return contentProvider;

  }

}
```

- Nos crearemos los recursos

- Por último, el servicio REST que hemos programado ha de poder ser utilizado a través de formularios HTML.

El formulario permitirá hacer POST de nuevos datos en el servicio. Para lo cual nos crearemos una página (.html) en la carpeta  "WebContent" del proyecto Eclipse que se entregará.

## Entorno de trabajo
- Oracle JDK 1.8.0_111
- Eclipse Java EE IDE for Web Developers. Version: Mars.2 Release (4.5.2)
- Apache Tomcat 8.0.14
- Apache Maven 3.0.5
- Debian 8.6
- Jersey 2.24.1
- JAX-RS 2.0.1
