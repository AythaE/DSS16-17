/*
 * Archivo: Interfaz.java 
 * Proyecto: manejadorEventosAsincronos
 * 
 * Autor: Aythami Estévez Olivas
 * Email: aythae@correo.ugr.es
 * Fecha: 23-oct-2016
 * Asignatura: Desarrollo de Sistemas Software basados en Componentes y Servicios
 */
package es.ugr.dss;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Clase Interfaz encargada de instanciar la interfaz de usuario de la aplicación
 * al ser invocado su método ejecutar como objetivo de la cadena de filtros
 * @author aythae
 *
 */
public class Interfaz {

	
	/**
	 * Método ejecutar invocado por {@link CadenaFiltros} al ser una instancia
	 * de esta clase su objetivo.
	 * 
	 * <p>
	 * Crea una {@link URI} con la dirección donde se encuentra accesible la 
	 * aplicacion desplegada en un tomcat e intena abrirla en el navegador 
	 * mediante el método {@link Desktop#browse(URI)}, en caso de no poder
	 * crea un hilo que duerme 2 segundos y muestra en el terminal que no se ha
	 * podido abrir el navegador pidiendo al usuario que lo haga él mismo y 
	 * proporcionandole la URL a la que debe acceder
	 *
	 * @param o Parametro de tipo Object para que pueda ser cualquier tipo
	 * 			(No se utiliza)
	 */
	public void ejecutar(Object o) {
		
			String webAppAddr= "http://localhost:8080/manejadorEventosAsincronos/home.jsf";
			URI uri;
			try {
				uri = new URI(webAppAddr);
				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().browse(uri);
				}
				else {
					
						Thread t = new Thread() {
							
							@Override
							public void run() {
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									
									e.printStackTrace();
								}
								System.out.println("\n\nNo se ha podido abrir el navegador por defecto, "+
										"por favor abra su navegador y vaya a la siguiente URL: "+webAppAddr);
								
							}
						};
						
						t.start();
					
					
				}
				

			} catch (URISyntaxException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}	

}
