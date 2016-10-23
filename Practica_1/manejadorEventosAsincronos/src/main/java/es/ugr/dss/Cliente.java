/*
 * Archivo: Cliente.java 
 * Proyecto: manejadorEventosAsincronos
 * 
 * Autor: Aythami Estévez Olivas
 * Email: aythae@correo.ugr.es
 * Fecha: 23-oct-2016
 * Asignatura: Desarrollo de Sistemas Software basados en Componentes y Servicios
 */
package es.ugr.dss;

/**
 * Clase Cliente encargada de lanzar las peticiones al {@link GestorFiltros}
 * que se ejecutan de modo transparente para ella.
 */
public class Cliente {

	/** El gestor filtros. */
	private GestorFiltros gestorFiltros=null;
	

	/**
	 * Fija el gestor filtros.
	 *
	 * @param gestor the new gestor filtros
	 */
	public void setGestorFiltros(GestorFiltros gestor) {
		this.gestorFiltros = gestor;
		
	}

	/**
	 * Lanza una petición al gestor filtros comprobando siempre que no sea nulo.
	 *
	 * @param peticion the new peticion
	 */
	public void setPeticion(Object peticion) {
		
		if (gestorFiltros!=null) {
			gestorFiltros.peticionFiltro(peticion);
		}
		else {
			System.err.println("[ERROR] Se ha intentado enviar una petición desde un cliente sin gestorFiltros");
		}
	}

}
