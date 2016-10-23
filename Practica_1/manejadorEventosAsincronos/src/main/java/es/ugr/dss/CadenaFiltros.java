package es.ugr.dss;

import java.util.ArrayList;
import java.util.List;

public class CadenaFiltros {
	
	private List<Filtro> filtros;
	
	private Interfaz objetivo;

	
	public CadenaFiltros() {
		filtros = new ArrayList<>();
		objetivo=null;
	}
	
	public void addFiltro(Filtro filtro){
		filtros.add(filtro);
	}

	public void setObjetivo(Interfaz objetivo) {
		this.objetivo = objetivo;
	}
	
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
