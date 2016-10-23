/*
 * Archivo: GestorFiltros.java 
 * Proyecto: manejadorEventosAsincronos
 * 
 * Autor: Aythami Estévez Olivas
 * Email: aythae@correo.ugr.es
 * Fecha: 23-oct-2016
 * Asignatura: Desarrollo de Sistemas Software basados en Componentes y Servicios
 */
package es.ugr.dss;

/**
 * Clase GestorFiltros encargada de gestionar las peticiones del {@link Cliente}
 * y de la clase {@link CadenaFiltros}; derivando las peticiones del cliente a
 * la cadena.
 */
public class GestorFiltros {

	/** La cadena filtros. */
	private CadenaFiltros cadenaFiltros;
	
	
	/**
	 * Constructor de gestor filtros que crea una instancia de 
	 * {@link CadenaFiltros} y le fija un objetivo.
	 *
	 * @param objetivo el objetivo a fijar en {@link CadenaFiltros}
	 */
	public GestorFiltros(Interfaz objetivo) {
		cadenaFiltros = new CadenaFiltros();
		cadenaFiltros.setObjetivo(objetivo);
	}
	
	/**
	 * Fija un nuevo filtro en la cadena de filtros.
	 *
	 * @param filtro the new filtro
	 */
	public void setFiltro(Filtro filtro){
		cadenaFiltros.addFiltro(filtro);
	}
	
	/**
	 * Da la orden de ejecución a la cadena de filtros cuando este método es
	 * invocado desde una petición del cliente.
	 *
	 * @param o la petición
	 */
	public void peticionFiltro(Object o){
		cadenaFiltros.ejecutar(o);
	}

}
