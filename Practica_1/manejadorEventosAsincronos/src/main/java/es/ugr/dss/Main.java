/*
 * Archivo: Main.java 
 * Proyecto: manejadorEventosAsincronos
 * 
 * Autor: Aythami Estévez Olivas
 * Email: aythae@correo.ugr.es
 * Fecha: 23-oct-2016
 * Asignatura: Desarrollo de Sistemas Software basados en Componentes y Servicios
 */
package es.ugr.dss;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Clase Main (equivalente a DemoInteceptor en el ejemplo) que implementa 
 * {@link ServletContextListener} para ejecutar el método 
 * {@link ServletContextListener#contextInitialized(ServletContextEvent)} que
 * se ejecuta cuando Tomcat carga el .war y de esta manera realizar el despliege
 * de la interfaz y ejecutar la cadena de filtros a traves de una peticion del
 * cliente	
 */
@WebListener
public class Main implements ServletContextListener {

	/** Atributo Cliente, estático para que pueda ser usado desde métodos estaticos. */
	private static Cliente cli = null;

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		GestorFiltros gestor = new GestorFiltros(new Interfaz());

		gestor.setFiltro(new Calcular());

		cli = new Cliente();

		cli.setGestorFiltros(gestor);
		cli.setPeticion(200);
	}
	
	/**
	 * Método estático que podría ser invocado al pulsar el boton de encendido
	 * y lanzaría una petiicon en el cliente disparando con ello el cálculo de
	 * velocidad y la apertura de una nueva pestaña en el navegador con la 
	 * interfaz gráfica (en la clase {@link Interfaz}).
	 *
	 * @return true, if successful
	 */
	public static boolean arrancar(){
		return acelerar();
	}
	
	/**
	 * Método estático que podría ser invocado al pulsar el boton de acelerar
	 * y lanzaría una petiicon en el cliente disparando con ello el cálculo de
	 * velocidad y la apertura de una nueva pestaña en el navegador con la 
	 * interfaz gráfica (en la clase {@link Interfaz}).
	 *
	 * @return true, if successful
	 */
	public static boolean acelerar(){
		if (cli!=null) {
			cli.setPeticion(250);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Método estático que podría ser invocado al pulsar el boton de parar
	 * y lanzaría una petiicon en el cliente disparando con ello el cálculo de
	 * velocidad y la apertura de una nueva pestaña en el navegador con la 
	 * interfaz gráfica (en la clase {@link Interfaz}).
	 *
	 * @return true, if successful
	 */
	public static boolean parar(){
		if (cli!=null) {
			cli.setPeticion(-1);
			return true;
		}
		
		return false;
	}

}
