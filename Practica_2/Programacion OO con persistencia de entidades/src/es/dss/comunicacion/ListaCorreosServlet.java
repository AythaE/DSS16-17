/*
 * Archivo: ListaCorreosServlet.java 
 * Proyecto: EstevezAythami-P2
 * 
 * Autor: Aythami Estévez Olivas
 * Email: aythae@correo.ugr.es
 * Fecha: 14-nov-2016
 * Asignatura: Desarrollo de Sistemas Software basados en Componentes y Servicios
 */
package es.dss.comunicacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.dss.modelo.BDUsuario;
import es.dss.modelo.Usuario;


/**
 * Clase ListaCorreosServlet que implementa {@link HttpServlet} y recibe todas
 * las peticiones al mismo. Accede a la base de datos mediante {@link BDUsuario}
 * y la modifica en respuesta a las peticiones
 */
public class ListaCorreosServlet extends HttpServlet{

	
	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/**
	 * Método que recibe las peticiones GET del servlet, es un método dummy que
	 * solo redirige las peticiones GET a POST con los mismos parámetros
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		doPost(req, resp);
	}
	
	/**
	 * Método que recibe las peticiones POST al servlet. Comprueba el parametro
	 * action y en función de este realiza diversas acciones:
	 * <ul>
	 * 	<li>
	 * 		action == null: No se ha recibido ningun parametro action por lo
	 * 		que se entiende que no hay parametros y se devuelve el contenido
	 * 		de la base de datos en una tabla en formato HTML 
	 * 	</li>
	 * 	<li>
	 * 		action == "listarusuarios": Se devuelve el contenido de la base de
	 * 		datos como un List<Usuario> mediante un {@link ObjectOutputStream}
	 * 	</li>
	 * 	<li>
	 * 		action == "aniadirUsuario": Se comprueba si el resto de parametros
	 * 		necesarios para crear un usuario estan presentes y son validos, se
	 * 		comprueba tambien si el email ya esta registrado en la base de datos.
	 * 		Si hay algun problema con los parametros o con el email se responde
	 * 		con un mensaje y codigo de error, en caso contrario se añade un 
	 * 		usuario a la base de datos y se responde con un mensaje y codigo de
	 * 		exito, ambos mediante un {@link ObjectOutputStream}
	 * 	</li>
	 * 	<li>
	 * 		action == "actualizarUsuario": Se comprueba si el resto de parametros
	 * 		necesarios para actualizar un usuario estan presentes y son validos, 
	 * 		se comprueba tambien si el email ya esta registrado en la base de datos.
	 * 		Si hay algun problema con los parametros o con el email se responde
	 * 		con un mensaje y codigo de error, en caso contrario se modifica el 
	 * 		usuario de la base de datos y se responde con un mensaje y codigo de
	 * 		exito, ambos mediante un {@link ObjectOutputStream}
	 * 	</li>
	 * 	<li>
	 * 		action == "eliminarUsuario": Se comprueba si el email esta registrado
	 * 		en la base de datos. Si hay algun problema con el email se responde
	 * 		con un mensaje y codigo de error, en caso contrario se borra el 
	 * 		usuario de la base de datos y se responde con un mensaje y codigo de
	 * 		exito, ambos mediante un {@link ObjectOutputStream}
	 * 	</li>
	 * 	<li>
	 * 		action == otraCosa: Se entiende que es una peticion invalida al 
	 * 		servlet y se responde con un mensaje y codigo de error mediante un 
	 * 		{@link ObjectOutputStream}
	 * 	</li>
	 * </ul>
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String action = req.getParameter("action");
		
		//Si no hay accion se devuelve un HTML con el contenido de la base de datos
		if (action==null) {
			resp.setContentType("text/html");
			
			PrintWriter pwr = resp.getWriter();
			
			StringBuilder html = new StringBuilder(
					"<!DOCTYPE html>" + 
						"<html>" + 
							"<head>" + 
								"<meta charset=\"utf-8\">" + 
								"<title>Lista de Usuarios</title>" + 
							"</head>" + 
							"<body>" +
								"<h1>Lista de usuarios</h1>"+
								"<table>"+
									"<thead>"+
										"<tr>"+
											"<th>Nombre</th>"+
											"<th>Apellido</th>"+
											"<th>Email</th>"+
										"</tr>"+
									"</thead>"+
									"<tbody>");
							
			List<Usuario> list = listarUsuarios();
			for (Usuario usuario : list) {
				html.append("<tr>"+
								"<td>"+usuario.getNombre()+"</td>"+
								"<td>"+usuario.getApellido()+"</td>"+
								"<td>"+usuario.getEmail()+"</td>"+
							"</tr>");
			}
			
			html.append("</tbody>"+"</table>"+"</body>"+"</html>");
			pwr.println(html.toString());
			pwr.flush();
			pwr.close();
			return;
			
		} else {
			ObjectOutputStream oos = new ObjectOutputStream(resp.getOutputStream());
			
			Usuario user;
			String email;
			String nombre;
			String apellido;

			switch (action) {
			case "listarUsuarios":
				List<Usuario> lista = listarUsuarios();
				if (lista == null) {
					lista = new ArrayList<Usuario>();
				}

				oos.writeObject(lista);
			
				break;

			case "aniadirUsuario":
				user = new Usuario();
				email = req.getParameter("email");
				nombre = req.getParameter("nombre");
				apellido = req.getParameter("apellido");

				if (email != null && email.compareTo("") != 0) {
					user.setEmail(email);
				} else {
					oos.writeInt(1);
					oos.writeObject("Error con el Email del usuario");
					oos.flush();
					oos.close();
					return;
				}

				if (nombre != null && nombre.compareTo("") != 0) {
					user.setNombre(nombre);
				} else {
					oos.writeInt(1);
					oos.writeObject("Error con el nombre del usuario");
					oos.flush();
					oos.close();
					return;
				}

				if (apellido != null && apellido.compareTo("") != 0) {
					user.setApellido(apellido);
				} else {
					oos.writeInt(1);
					oos.writeObject("Error con el apellido del usuario");
					oos.flush();
					oos.close();
					return;
				}

				if (BDUsuario.existEmail(email)) {
					oos.writeInt(1);
					oos.writeObject("Error creando el usuario, ya existe un usuario con ese email");
					oos.flush();
					oos.close();
					return;
				}
				BDUsuario.addUsuario(user);

				oos.writeInt(0);
				oos.writeObject("Usuario "+email+" creado correctamente");
	

				break;

			case "actualizarUsuario":

				user = new Usuario();
				email = req.getParameter("email");
				nombre = req.getParameter("nombre");
				apellido = req.getParameter("apellido");

				if (email != null && email.compareTo("") != 0) {
					user.setEmail(email);
				} else {
					oos.writeInt(1);
					oos.writeObject("Error con el Email del usuario");
					oos.flush();
					oos.close();
					return;
				}

				if (nombre != null && nombre.compareTo("") != 0) {
					user.setNombre(nombre);
				} else {
					oos.writeInt(1);
					oos.writeObject("Error con el nombre del usuario");
					oos.flush();
					oos.close();
					return;
				}

				if (apellido != null && apellido.compareTo("") != 0) {
					user.setApellido(apellido);
				} else {
					oos.writeInt(1);
					oos.writeObject("Error con el apellido del usuario");
					oos.flush();
					oos.close();
					return;
				}
				
				if (!BDUsuario.existEmail(email)) {
					oos.writeInt(1);
					oos.writeObject("Error actualizando el usuario, no existe un usuario con ese email");
					oos.flush();
					oos.close();
					return;
				}
				BDUsuario.updateUsuario(user);

				oos.writeInt(0);
				oos.writeObject("Usuario "+email+" actualizado correctamente");
		
				
				break;

			case "eliminarUsuario":
				user = new Usuario();
				email = req.getParameter("email");

				if (email != null && email.compareTo("") != 0) {
					user.setEmail(email);
				} else {
					oos.writeInt(1);
					oos.writeObject("Error con el Email del usuario");
					oos.flush();
					oos.close();
					return;
				}

				if (!BDUsuario.existEmail(email)) {
					oos.writeInt(1);
					oos.writeObject("Error borrando el usuario, no existe un usuario con ese email");
					oos.flush();
					oos.close();
					return;
				}
				BDUsuario.deleteUsuario(user);

				oos.writeInt(0);
				oos.writeObject("Usuario "+email+" borrado correctamente");
			
				break;

			default:
				oos.writeInt(1);
				oos.writeObject("Petición desconocida al servidor");
			
				break;
			}
			oos.flush();
			oos.close();
		}
	}

	/**
	 * Listar usuarios que invoca al metodo {@link BDUsuario#listUsuarios()}.
	 * Se emplea para atrapar posibles {@link ClassCastException} lanzadas al
	 * devolver el contenido de la base de datos como List<Usuario>.
	 *
	 * @return the list
	 */
	private List<Usuario> listarUsuarios() {
		List<Usuario> lista = null;
		try {
			lista = BDUsuario.listUsuarios();
		}catch (ClassCastException e){
			e.printStackTrace();
			lista = null;
		}
		return lista;
		
	}
}
