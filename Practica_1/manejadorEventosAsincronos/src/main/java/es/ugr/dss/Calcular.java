package es.ugr.dss;

public class Calcular implements Filtro {


	/**
	 * RADIO en metros
	 */
	private final double RADIO = 0.6;
	
	// En RPM
	private double revolAnt = 0;
	private double incrementoRevoluciones = 0;

	public double ejecutar(Object o) {

		incrementoRevoluciones = ((Double) o).doubleValue();
		

		// Se envia -1 para indicar parada
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
