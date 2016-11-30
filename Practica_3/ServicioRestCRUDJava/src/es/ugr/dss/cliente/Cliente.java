package es.ugr.dss.cliente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBElement;

import es.ugr.dss.modelo.ItemCatalogo;
import es.ugr.dss.modelo.ItemCatalogo.Color;

public class Cliente {

	public static final String SERVICE_URL = "http://localhost:8080/EstevezAythami-P3/";

	public static void main(String[] args) {
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(SERVICE_URL);

		// crearse un tercer "objeto" item, aparte de los otros 3
		ItemCatalogo item = new ItemCatalogo("4", "Cazadora de cuero", "Cazadora de cuero estilo motero", 75.6, "L",
				Color.Negro);
		Response respuesta = target.path("rest").path("catalogo").path(item.getId()).request(MediaType.APPLICATION_XML)
				.put(Entity.entity(item, MediaType.APPLICATION_XML), Response.class);

		System.out.print("Codigo devuelto: ");
		// El codigo devuelto deberia ser: 201 == created
		System.out.println(respuesta.getStatus()+"\t" + respuesta.readEntity(String.class));
		// Mostrar el contenido del recurso Catalogo como texto XML
		System.out.println("Mostrar como Texto XML Plano");
		System.out.println(target.path("rest").path("catalogo").request(MediaType.TEXT_XML).get(String.class));

		// Crear un cuarto recurso Todo con un formulario Web
		System.out.println("Creacion de 1 formulario");
		Form form = new Form();
		form.param("ID", "5");
		form.param("Nombre", "Chaqueta de pana");
		form.param("Descripcion", "Chaqueta de pana con coderas");
		form.param("Precio", "19.95");
		form.param("Tallas", "S, M, L");
		form.param("Color", "Azul");
		respuesta = target.path("rest").path("catalogo").request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), Response.class);
		System.out.println("Respuesta con el formulario: " + respuesta.readEntity(String.class));
		// Se ha debido crear el elemento con id = 4
	
		System.out.println("Contenidos del recurso, despues de enviar el elemento id=5");
		System.out.println(target.path("rest").path("catalogo").request(MediaType.APPLICATION_XML).get(String.class));

		// Ahora vamos a eliminar el "objeto" con id=1 del recurso
		target.path("rest").path("catalogo/1").request().delete();
		// Mostramos el contenido del recurso Todos, el elemento con id=1
		// deberia haber sido eliminado
		System.out.println("El elemento con id = 1 del recurso se ha eliminado");
		System.out.println(target.path("rest").path("catalogo").request(MediaType.APPLICATION_XML).get(String.class));
	}

}
