package es.ugr.dss;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Interfaz {

	
	public void ejecutar(Object o) {
		
			String webAppAddr= "http://localhost:8080/manejadorEventosAsincronos/home.jsf";
			URI uri;
			try {
				uri = new URI(webAppAddr);
				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().browse(uri);
				}
				else {
					
						Thread t = new Thread() {
							
							@Override
							public void run() {
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("\n\nNo se ha podido abrir el navegador por defecto, "+
										"por favor abra su navegador y vaya a la siguiente URL: "+webAppAddr);
								
							}
						};
						
						t.start();
					
					
				}
				

			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	

}
