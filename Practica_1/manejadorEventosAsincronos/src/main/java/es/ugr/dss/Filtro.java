/*
 * Archivo: Filtro.java 
 * Proyecto: manejadorEventosAsincronos
 * 
 * Autor: Aythami Estévez Olivas
 * Email: aythae@correo.ugr.es
 * Fecha: 23-oct-2016
 * Asignatura: Desarrollo de Sistemas Software basados en Componentes y Servicios
 */
package es.ugr.dss;

/**
 * Interfaz Filtro que han de implementar todos los filtros definidos.
 */
public interface Filtro {

	
	/**
	 * Método ejecutar.
	 *
	 * @param o peticion a ejecutar
	 * @return the double
	 */
	public double ejecutar(Object o);
}
