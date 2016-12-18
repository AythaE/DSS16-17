# Práctica 4
## Descripción de contenido
- `bpel.pdf` Guía de la practica 4.
- `ServicioRestCRUDJava/` Contiene la tercera prática entregable
- `BPEL-seminar.pdf` Seminario sobre el lenguaje de orquestación BPEL.

## Enunciado de la práctica 4
#### Modelado de procesos de negocio con BPEL 2.0.

##### Practica 4.1
Especificar utilizando BPEL 2.0 y la herramienta BPEL Designer para Eclipse el proceso de negocio (cuyo diagrama de actividad se muestra en la siguiente figura) y que se describe informalmente como sigue: El cliente invoca al proceso de negocio, especificando el nombre del empleado, el destino de su viaje, la fecha de salida, y la fecha de regreso.

El proceso de negocio BPEL comprueba primero la categoría del empleado que va a viajar, que se corresponden con estos tipos de pasaje de avión:
- (a) clase turista
- (b) clase business
- (c) avión privado

Suponemos que disponemos de un SW contra el que se puede hacer la consulta, después de dicha consulta, el proceso BPEL comprobará el precio del billete con 2 líneas aéreas diferentes para encontrar mejor precio; suponemos otra vez que ambas compañías proporcionan un SW que permite realizar todas las gestiones anteriores. Por último, el proceso BPEL seleccionará el precio más bajo y devolverá un plan de viaje al cliente, para su aprobación.

![Orquestación de vuelos](imagenes/Orquestación de vuelos.PNG "Orquestación de vuelos")

##### Practica 4.2

Orquestar, de forma simplificada, el mercadeo entre un comprador y un vendedor de un producto solicitado, de acuerdo con el diagrama de interacción que se muestra en la siguiente figura.

- (a) El comprador comienza pidiendo un precio al vendedor y el vendedor responde con un precio para el producto o una excepción si no conoce el artículo que le demandan o no estuviera disponible en el almacén.
- (b) El comprador continua pidiendo precio al vendedor y entra en un comportamiento repetitivo con actualizaciones (del precio del artículo) hasta que decide comprar el artículo cuando considera que se le ofrece el mejor precio.
- (c) Se pide en este ejercicio desarrollar la descripción completa de la orquestación que se ha descrito anteriormente entre el comprador y el vendedor.

![Orquestación de procesos de compra](imagenes/Orquestación de procesos de compra.PNG "Orquestación de procesos de compra")

## Entorno de trabajo
- Oracle JDK 1.8.0_111
- Eclipse Java EE IDE for Web Developers. Version: Neon.1a Release (4.6.1)
- BPEL Plugin 1.0.5
- Apache Ode 1.3.6
- Apache Tomcat 8.0.14
- Debian 8.6
