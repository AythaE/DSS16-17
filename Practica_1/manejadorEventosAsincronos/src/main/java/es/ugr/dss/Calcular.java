/*
 * Archivo: Calcular.java 
 * Proyecto: manejadorEventosAsincronos
 * 
 * Autor: Aythami Estévez Olivas
 * Email: aythae@correo.ugr.es
 * Fecha: 23-oct-2016
 * Asignatura: Desarrollo de Sistemas Software basados en Componentes y Servicios
 */
package es.ugr.dss;

// TODO: Auto-generated Javadoc
/**
 * The Class Calcular.
 */
public class Calcular implements Filtro {

	
	/** 
	 * Constante radio que determina el radio de una rueda en metros sobre la
	 * que se calcula la velocidad.
	 */
 	private final double RADIO = 0.6;
	
	/** Atributo para almacenar las revoluciones anteriores (en rpm). */
	private double revolAnt = 0;
	
	/** Atributo para almacenar el incremento de revoluciones (en rpm). */
	private double incrementoRevoluciones = 0;

	/**
	 * Método que permite calcular la velocidad a partir de la revoluciones de
	 * una rueda de radio {@link Calcular#RADIO} y las revoluciones anteriores
	 * de esta.
	 * 
	 * @return double la velocidad de la rueda en km/h
	 * @see es.ugr.dss.Filtro#ejecutar(java.lang.Object)
	 */
	public double ejecutar(Object o) {

		incrementoRevoluciones = ((Double) o).doubleValue();
		

		// Se envia -1 para indicar parada, por tanto si es < 0 se ha enviado
		// parada
		if (incrementoRevoluciones < 0) {
			revolAnt = 0;
			return 0;
		}
		
		// En m/min
		double distancia = (incrementoRevoluciones + revolAnt) * 2 * RADIO * Math.PI;

		// En Km/h
		double velocidad = distancia * (60.0 / 1000.0);

		
		revolAnt += incrementoRevoluciones;
		return velocidad;
	}

}
