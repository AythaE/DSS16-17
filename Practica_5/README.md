# Práctica 5

## Descripción de contenido
- `ESDLA-Quiz/` quinta práctica entregable
- `app-android.pdf` Enunciado de la práctica
- `comentarios.md` Comentarios sobre la práctica realizados en clase

## Enunciado de la práctica 5

#### Desarrollo completo de una aplicación interactiva para dispositivos móviles:

- El juego que se tiene que desarrollar ha de poder ejecutarse en un dispositivo Android (versión >= 4.4) o IOS (elegir sólo uno) y se trata de presentar una serie de preguntas al usuario, que tendrá que responder para alcanzar una puntuación global, así como el número de respuestas acertadas y falladas.

- Se tendrá una primera pantalla de presentación con un botón para iniciar el juego, otro para obtener los resultados y estadísticas obtenidos después de jugar y un tercer botón para enlazar con juegos similares libres que existan en Internet y que se puedan utilizar desde un tipo de aplicación como la que se pretende desarrollar.

- Cada pantalla del juego ha de consistir en 1 pregunta con 4 posibles respuestas alternativas; la pregunta podría ser un texto plano, o una pregunta que contenga imágenes y sonidos.

- Se ha de construir una base de datos de preguntas de texto planas a la que acceda directamente la app, de tal forma que en el futuro se puedan cambiar las preguntas de texto sin tener que modificar el código de la citada aplicación, aunque haya que volver a generar el archivo apk desplegable.

- Al seleccionar una de las respuestas en cada pregunta ha de aparecer un mensaje de felicitación en el pie de la pantalla junto con un sonido de acierto o fallo; después de unos segundos se pasará a la siguiente pantalla con otra pregunta.

- En caso de no acertar, se ha de poder elegir entre volver a la pantalla inicial para comenzar de nuevo el juego y se obtendrá un mensaje con la respuesta correcta o bien continuar el juego (no se obtendría las soluciones hasta el final); en ambos casos, se pueden obtener los resultados acumulados durante el desarrollo de un juego volviendo a la pantalla de inicio y pulsando e el botón "Resultados".

- Tras la última pregunta, el mensaje que se mostrará será de felicitación por haber realizado el juego y mensaje de despedida antes de volver a iniciar el juego.

Para que la aplicación desarrollada sea evaluada favorablemente ha de satisfacer los siguientes requisitos:

##### Funcionales:

1. El juego deberá mostrar una batería de preguntas.

2. El usuario ha de poder responder a las preguntas de una en una

3. Si el usuario falla la pregunta, se le mostrará un mensaje indicándole que ha fallado junto con un sonido

4. Si el usuario acierta,se le muestra un mensaje indicándole que ha acertado.

5. Ha de haber pantallas de pregunta que incluyan 1 imagen

6. Si el usuario falla, entonces deberá aparecer la opción de continuar la partida o de volver a iniciar el juego.

7. si el usuario acierta, continuará con la siguiente pregunta.
8. Cuando el usuario finaliza la partida, se le muestran los resultados que ha obtenido.
9. El menú deberá poder dirigirnos, al inicio de una nueva partida, a una opción que nos permita ver los resultados obtenidos en las partidas realizadas anteriormente, o a otros juegos en la Red mediante un webView.

##### No funcionales:

1. Solamente puede hacerse un único acceso a la base de datos.
2. La aplicación deberá funcionar como mínimo en dispositivos con versiones de sistemas
operativos actuales ( por ejemplo: Android >=4.4)
3. La aplicación debe funcionar tanto en dispositivos móviles (teléfonos) como en tablets.
4. Se debe desarrollar la aplicación pedida aplicando Patrones de Diseño Software (por ejemplo: Singleton, Inmutable, Proxy, Escuchador de Eventos ) y
Patrones Arquitectónicos (por ejemplo: MVC, DataBaseManagement System).


## Descripción del juego
Para esta pŕactica se ha desarrollado la aplicación **ESDLA-Quiz** (El Señor De Los Anillos Quiz) de acuerdo a los requisitos estipulados en el enunciado de la práctica. Esta aplicación consiste en un juego de preguntas con respuesta múltiple (4 opciones por pregunta). En total el juego cuenta con 32 preguntas, aunque sería fácil ampliarlo añadiendo preguntas al fichero desde el que se rellena la base de datos (localizado en `app/src/main/res/raw/database.csv`) sin necesidad de modificar el código. Las preguntas se dividen en tres categorías:
- Preguntas textuales: Cuya pregunta y respuesta es texto plano (20)
- Preguntas de imagen: En las que se hace una pregunta sobre una imagen (7).
- Preguntas de sonido: En las que se hace una pregunta sobre un sonido (5).

El juego además almacena los resultados del usuario para mostrarlos en el apartado de estadísticas de la pantalla principal, pero el almacén de estos resultados se realiza en memoria, no en una base de datos o en almacenamiento, por tanto cuando el usuario cierra la aplicación se pierden.

Por último tambéen tiene la opción de buscar juegos similares mediante un WebView integrado en la aplicación.

## Diagramas clase y arquitectura con patrones usados (MVC y Singleton)

En el siguiente diagrama de arquitectura podemos apreciar como se estructura la aplicación, que sigue el patrón Modelo-Vista-Controlador.

![Diagrama de arquitectura](diagrams/Diagrama de arquitectura.png "Diagrama de arquitectura")

En este otro diagrama de clases se puede observar como se relacionan las clases de la aplicación. Aparecen algunas clases como `BaseAdapter`, `AppCompatActivity` y `SQLiteOpenHelper` que son clases pertenecientes al Framework de Android y son extendidas por algunas de las clases de la aplicación como se puede ver. También cabe destacar como se aprecia en la clase `DBHelper` que posee una instancia de si misma, lo que junto a su constructor privado y su método `getInstance()` indica que esta clase sigue el patrón Singleton. Por último mencionar que las clases se han intentado colocar de arriba a abajo siguiendo el patrón arquitectónico MVC.

![Diagrama de clases](diagrams/DiagramaClases.png "Diagrama de clases")


## Despliegue de la aplicación mediante un APK firmado

Se ha generado un `.apk` firmado para facilitar el despliegue la aplicación siguiendo estas [instrucciones](https://developer.android.com/studio/publish/app-signing.html?hl=es-419#release-mode). Para desplegar la aplicaición en un sistema Android basta con insertar `app-release.apk` en dicho dispositivo y abrirlo desde su explorador de fichero, nos preguntará si queremos instalar la aplicación ESDLA-Quiz, confirmamos y se instalará. Es posible que salte un error diciendo que la instalación se ha bloqueado por seguridad, basta con acceder a Ajustes > Seguridad > Orígenes desconocidos y habilitar esta opción.

## Instrucciones de importación en Android Studio

Para importar el proyecto en Android Studio basta con descomprimir el archivo `EstevezAythami-P5.zip`, lo cual generará una carpeta homónima. Tras esto desde Android Studio selecionar File > Open... > [Ubicación de la carpeta EstevezAythami-P5].

## Pruebas en dispositivos y distintas versiones de Android

La aplicación se ha desarrollado para dispositivos con Android >= 4.4 (API 19) tal y como dicta el enunciado. Ha sido probada usando el emulador Genymotion en una tablet Nexus 10 con Android 4.4.4. (API 19) y en un Nexus 5X con Android 6.0.0 (API 23). Además se ha probado en un dispositivo físico, un Motorola Moto G LTE con Android 5.1 (API 22). En ninguno de estos dispositivos se ha encontrado problema alguno.

## Entorno de trabajo
- Oracle JDK 1.8.0_111
- Android Studio 2.2.3
- Genymotion 2.8.1
- Debian 8.6
