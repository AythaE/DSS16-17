package es.ugr.dss.recurso;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import es.ugr.dss.modelo.CatalogoDAO;
import es.ugr.dss.modelo.ItemCatalogo;
import es.ugr.dss.modelo.ItemCatalogo.Color;

@Path("/catalogo")
public class CatalagoRecurso {
	// Permite insertar objetos contextuales en la clase,
	// por ejemplo, ServletContext, Request, Response, UriInfo
	@Context
	private UriInfo uriInfo;
	@Context
	private Request request;


/*	@GET
	@Produces(MediaType.TEXT_HTML)
	public String helloBrowser() {
		return "Hello browser";
	}*/
	@GET
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_XML})
	public List<ItemCatalogo> getCatalogo() {
		List<ItemCatalogo> catalogo = new ArrayList<>();
		catalogo.addAll(CatalogoDAO.INSTANCE.getModelo().values());
		return catalogo;
	}

	@GET
	@Path("/count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = CatalogoDAO.INSTANCE.getModelo().size();
		return String.valueOf(count);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addItemByForm(@FormParam("ID") String id, @FormParam("Nombre") String nombre,
			@FormParam("Descripción") String descrip, @FormParam("Precio") double precio,
			@FormParam("Tallas") String tallas, @FormParam("Color") String color) {
		Color col = null;
		switch (color) {
		case "Rojo":
			col = Color.Rojo;
			break;
		case "Verde":
			col = Color.Verde;
			break;
		case "Azul":
			col = Color.Azul;
			break;
		case "Blanco":
			col = Color.Blanco;
			break;
		case "Negro":
			col = Color.Negro;
			break;
		}
		
		ItemCatalogo newItem = new ItemCatalogo(id, nombre, descrip, precio, tallas, col);
		
		if (CatalogoDAO.INSTANCE.getModelo().containsKey(id)) {
			return Response.status(400).entity("Ya existe un item con ese ID").build();
		}
		CatalogoDAO.INSTANCE.getModelo().put(id, newItem);
		
		try {
	
			return Response.seeOther(new URI("./catalogo")).build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return Response.status(201).entity("Item creado correctamente").build();
		}
	}

	@Path("{item}")
	public ItemRecurso getTodo(@PathParam("item") String id) {
		return new ItemRecurso(id, uriInfo);
	}
}
