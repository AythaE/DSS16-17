# Práctica 5
## Descripción de contenido

## Enunciado de la práctica 5

#### Desarrollo completo de una aplicación interactiva para dispositivos móviles:

- El juego que se tiene que desarrollar ha de poder ejecutarse en un dispositivo Android (versión >= 4.4) o IOS (elegir sólo uno) y se trata de presentar una serie de preguntas al usuario, que tendrá que responder para alcanzar una puntuación global, así como el número de respuestas acertadas y falladas.

- Se tendrá una primera pantalla de presentación con un botón para iniciar el juego, otro para obtener los resultados y estadísticas obtenidos después de jugar y un tercer botón para enlazar con juegos similares libres que existan en Internet y que se puedan utilizar desde un tipo de aplicación como la que se pretende desarrollar.

- Cada pantalla del juego ha de consistir en 1 pregunta con 4 posibles respuestas alternativas; la pregunta podría ser un texto plano, o una pregunta que contenga imágenes y sonidos.

-Se ha de construir una base de datos de preguntas de texto planas a la que acceda directamente la app, de tal forma que en el futuro se puedan cambiar las preguntas de texto sin tener que modificar el código de la citada aplicación, aunque haya que volver a generar el archivo apk desplegable.

-Al seleccionar una de las respuestas en cada pregunta ha de aparecer un mensaje de felicitación en el pie de la pantalla junto con un sonido de acierto o fallo; después de unos segundos se pasará a la siguiente pantalla con otra pregunta.

-En caso de no acertar, se ha de poder elegir entre volver a la pantalla inicial para comenzar de nuevo el juego y se obtendrá un mensaje con la respuesta correcta o bien continuar el juego (no se obtendría las soluciones hasta el final); en ambos casos, se pueden obtener los resultados acumulados durante el desarrollo de un juego volviendo a la pantalla de inicio y pulsando e el botón "Resultados".

-Tras la última pregunta, el mensaje que se mostrará será de felicitación por haber realizado el juego y mensaje de despedida antes de volver a iniciar el juego.

Para que la aplicación desarrollada sea evaluada favorablemente ha de satisfacer los siguientes requisitos:

Funcionales:

1) El juego deberá mostrar una batería de preguntas.
2) El usuario ha de poder responder a las preguntas de una en una
3) Si el usuario falla la pregunta, se le mostrará un mensaje indicándole que ha fallado junto con un sonido

4) Si el usuario acierta,se le muestra un mensaje indicándole que ha acertado.

5) Ha de haber pantallas de pregunta que incluyan 1 imagen

6) Si el usuario falla, entonces deberá aparecer la opción de continuar la partida o de volver a iniciar el juego.

7) si el usuario acierta, continuará con la siguiente pregunta.
8) Cuando el usuario finaliza la partida, se le muestran los resultados que ha obtenido.
9) El menú deberá poder dirigirnos, al inicio de una nueva partida, a una opción que nos permita ver los resultados obtenidos en las partidas realizadas anteriormente, o a otros juegos en la Red mediante un webView.

No funcionales:

1) Solamente puede hacerse un único acceso a la base de datos.
2) La aplicación deberá funcionar como mínimo en dispositivos con versiones de sistemas
operativos actuales ( por ejemplo: Android >=4.4)
3) La aplicación debe funcionar tanto en dispositivos móviles (teléfonos) como en tablets.
4) Se debe desarrollar la aplicación pedida aplicando Patrones de Diseño Software (por ejemplo: Singleton, Inmutable, Proxy, Escuchador de Eventos ) y
Patrones Arquitectónicos (por ejemplo: MVC, DataBaseManagement System).

## Entorno de trabajo
- Oracle JDK 1.8.0_111
- Eclipse Java EE IDE for Web Developers. Version: Mars.2 Release (4.5.2)
- Apache Tomcat 8.0.14
- Apache Maven 3.0.5
- Debian 8.6
- Jersey 2.24.1
- JAX-RS 2.0.1
