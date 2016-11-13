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

public class ListaCorreosServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ListaCorreosServlet() {
		// TODO Auto-generated constructor stub
		//bdUsuario = new BDUsuario();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		doPost(req, resp);
	}
	
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
					oos.writeObject("Error recuperando el Email del usuario");
					oos.flush();
					oos.close();
					return;
				}

				if (nombre != null && nombre.compareTo("") != 0) {
					user.setNombre(nombre);
				} else {
					oos.writeInt(1);
					oos.writeObject("Error recuperando el nombre del usuario");
					oos.flush();
					oos.close();
					return;
				}

				if (apellido != null && apellido.compareTo("") != 0) {
					user.setApellido(apellido);
				} else {
					oos.writeInt(1);
					oos.writeObject("Error recuperando el apellido del usuario");
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
					oos.writeObject("Error recuperando el Email del usuario");
					oos.flush();
					oos.close();
					return;
				}

				if (nombre != null && nombre.compareTo("") != 0) {
					user.setNombre(nombre);
				} else {
					oos.writeInt(1);
					oos.writeObject("Error recuperando el nombre del usuario");
					oos.flush();
					oos.close();
					return;
				}

				if (apellido != null && apellido.compareTo("") != 0) {
					user.setApellido(apellido);
				} else {
					oos.writeInt(1);
					oos.writeObject("Error recuperando el apellido del usuario");
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
					oos.writeObject("Error recuperando el Email del usuario");
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
