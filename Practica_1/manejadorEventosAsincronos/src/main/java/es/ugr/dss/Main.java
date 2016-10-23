package es.ugr.dss;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Main implements ServletContextListener {

	private static Cliente cli = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		GestorFiltros gestor = new GestorFiltros(new Interfaz());

		gestor.setFiltro(new Calcular());

		cli = new Cliente();

		cli.setGestorFiltros(gestor);
		cli.setPeticion(0);
	}
	
	public static boolean arrancar(){
		return acelerar();
	}
	public static boolean acelerar(){
		if (cli!=null) {
			cli.setPeticion(250);
			return true;
		}
		
		return false;
	}
	
	public static boolean parar(){
		if (cli!=null) {
			cli.setPeticion(-1);
			return true;
		}
		
		return false;
	}

}
