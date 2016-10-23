/*
 * Archivo: CadenaFiltros.java 
 * Proyecto: manejadorEventosAsincronos
 * 
 * Autor: Aythami Estévez Olivas
 * Email: aythae@correo.ugr.es
 * Fecha: 23-oct-2016
 * Asignatura: Desarrollo de Sistemas Software basados en Componentes y Servicios
 */
package es.ugr.dss;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase CadenaFiltros que contiene una lista con todos los filtros creados y 
 * se encarga de ejecutarlos cuando recibe la péticion de {@link GestorFiltros}.
 */
public class CadenaFiltros {
	
	/** Lista genérica de filtros. */
	private List<Filtro> filtros;
	
	/** Atributo de tipo {@link Interfaz} que es el objetivo de la cadena. */
	private Interfaz objetivo;

	
	/**
	 * Constructor que instancia la lista como un {@link ArrayList} y fija el
	 * objetivo a null hasta que este se fije externamente en el método 
	 * {@link CadenaFiltros#setObjetivo(Interfaz)}.
	 */
	public CadenaFiltros() {
		filtros = new ArrayList<Filtro>();
		objetivo=null;
	}
	
	/**
	 * Añade un filtro a la cadena.
	 *
	 * @param filtro the filtro
	 */
	public void addFiltro(Filtro filtro){
		filtros.add(filtro);
	}

	/**
	 * Fija un objetivo de la cadena de filtros.
	 *
	 * @param objetivo the new objetivo
	 */
	public void setObjetivo(Interfaz objetivo) {
		this.objetivo = objetivo;
	}
	
	/**
	 * Ejecuta cada uno de los filtros (en el orden en el que se introdujeron)
	 * acabando con la ejecución del objetivo.
	 *
	 * @param o the o
	 */
	public void ejecutar (Object o){
		
		double velocidad=0;
		
		for (Filtro filtro : filtros) {
			velocidad = filtro.ejecutar(o);
			
		}
		System.out.println("Nueva velocidad (Km/h) "+velocidad);
		
		if (objetivo!= null) {
			objetivo.ejecutar(o);
		}
		
	}

	
}
