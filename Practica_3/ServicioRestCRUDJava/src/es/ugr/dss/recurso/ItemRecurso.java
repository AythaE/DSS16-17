package es.ugr.dss.recurso;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import es.ugr.dss.modelo.CatalogoDAO;
import es.ugr.dss.modelo.ItemCatalogo;

public class ItemRecurso {

	private String id;
	private UriInfo uriInfo;
	public ItemRecurso(String id, UriInfo uriInfo) {
		this.id = id;
		this.uriInfo = uriInfo;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getItem(){
		ItemCatalogo item = CatalogoDAO.INSTANCE.getModelo().get(id);
		
		if (item != null) {
			return Response.ok(item).build();
		}
		else{
			
			return Response.status(404).entity("Item con id "+id+" no encontrado").build();
		}
		
	}
	

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response addOrReplaceItem(JAXBElement<ItemCatalogo> itemXML){
		ItemCatalogo item = itemXML.getValue();
		
			CatalogoDAO.INSTANCE.getModelo().put(item.getId(), item);
			return Response.created(uriInfo.getAbsolutePath()).build();
		
	
	}
	
	
	@DELETE
	public Response deleteItem (){
		if (CatalogoDAO.INSTANCE.getModelo().containsKey(id)) {
			CatalogoDAO.INSTANCE.getModelo().remove(id);
			return Response.status(200).entity("Item con id "+id+" borrado correctamente").build();
		}
		else{

			return Response.status(404).entity("Item con id "+id+" no encontrado, creelo antes").build();
		}
	
	}
	

}
