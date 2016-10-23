package es.ugr.dss;

public class Cliente {

	private GestorFiltros gestorFiltros=null;
	

	public void setGestorFiltros(GestorFiltros gestor) {
		this.gestorFiltros = gestor;
		
	}

	public void setPeticion(double peticion) {
		
		if (gestorFiltros!=null) {
			gestorFiltros.peticionFiltro(peticion);
		}
		else {
			System.err.println("[ERROR] Se ha intentado enviar una petición desde un cliente sin gestorFiltros");
		}
	}

}
