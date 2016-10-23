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

/**
 * Clase Main (equivalente a DemoInteceptor en el ejemplo) contiene el método 
 * main que se ejecuta cuando se construye el Managed Bean {@link ControlMB} y
 * de esta manera realizar el despliege de la interfaz y ejecutar la cadena de 
 * filtros a traves de una peticion del cliente	
 */
public class Main  {

	/** Atributo Cliente, estático para que pueda ser usado desde métodos estaticos. */
	private static Cliente cli = null;

	/**
	 * Método main que crea e inicializa el gestor de filtros para posteriormente
	 * crear un cliente, asignarle ese gestor y lanzar una petición
	 * 
	 * @param args No se usa, estan por convenio de los métodos main en java
	 */
	public static void main(String[] args) {
		
		GestorFiltros gestor = new GestorFiltros(new Interfaz());

		gestor.setFiltro(new Calcular());

		cli = new Cliente();

		cli.setGestorFiltros(gestor);
		cli.setPeticion(200.0);
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
			cli.setPeticion(250.0);
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
			cli.setPeticion(-1.0);
			return true;
		}
		
		return false;
	}

}
