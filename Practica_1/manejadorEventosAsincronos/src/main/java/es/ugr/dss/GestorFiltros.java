package es.ugr.dss;

public class GestorFiltros {

	private CadenaFiltros cadenaFiltros;
	
	//Introducir objetivo
	
	public GestorFiltros(Interfaz objetivo) {
		cadenaFiltros = new CadenaFiltros();
		cadenaFiltros.setObjetivo(objetivo);
	}
	
	public void setFiltro(Filtro filtro){
		cadenaFiltros.addFiltro(filtro);
	}
	
	public void peticionFiltro(Object o){
		cadenaFiltros.ejecutar(o);
	}

}
