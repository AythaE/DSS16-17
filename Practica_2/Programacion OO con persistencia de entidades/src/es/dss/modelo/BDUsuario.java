/*
 * Archivo: BDUsuario.java 
 * Proyecto: EstevezAythami-P2
 * 
 * Autor: Aythami Estévez Olivas
 * Email: aythae@correo.ugr.es
 * Fecha: 14-nov-2016
 * Asignatura: Desarrollo de Sistemas Software basados en Componentes y Servicios
 */
package es.dss.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Clase BDUsuario encargada de manejar la entidad persistente "usuario".
 * Contiene los métodos estáticos para acceder a la base de datos cubriendo
 * un ciclo CRUD típico.
 * 
 * @author aythae
 *
 */
public class BDUsuario {

	/** Nombre de la unidad de persistencia definida en persistence.xml */
	private static final String PERSISTENCE_UNIT_NAME = "usuario";
	/** 
	 * Factoría de gestores de entidades de esa unidad de 
	 * {@link BDUsuario#PERSISTENCE_UNIT_NAME}
	 */
	private static EntityManagerFactory factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);;

	/**
	 * Método que devuelve el contenido de la base de datos buscando todas las
	 * instancias de usuarios.
	 * 
	 * @return resultList Lista de usuarios
	 */
	@SuppressWarnings("unchecked")
	public static List<Usuario> listUsuarios(){
		EntityManager em = factoria.createEntityManager();
		
		Query q = em.createQuery("SELECT u FROM Usuario u");
		
	
		List<Usuario> resultList = q.getResultList();
		
		em.close();
		return resultList;
	}

	/**
	 * Comprueba si existe un email en la base de datos, ya que este es un campo
	 * único. Si encuentra un usuario con ese email en la base de datos devuelve
	 * true, en caso contrario false
	 *
	 * @param email email a comprobar
	 * @return true, si existe
	 */
	public static boolean existEmail(String email){
		EntityManager em = factoria.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		q.setParameter("email", email);
		
		return q.getResultList().size() > 0;
	}
	/**
	 * Añade un usuario a la base de datos
	 * 
	 * @param user Usuario a añadir
	 */
	public static void addUsuario(Usuario user) {
		EntityManager em = factoria.createEntityManager();

		em.getTransaction().begin();

		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Borra un usuario de la base de datos. Para ello busca un usuario en la 
	 * BD igual al que recibe por parametro y lo borra al extraerlo.
	 * 
	 * @param user a borrar
	 */
	public static void deleteUsuario(Usuario user){
		EntityManager em = factoria.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		q.setParameter("email", user.getEmail());
		Usuario dbUser = (Usuario) q.getSingleResult();

		em.remove(dbUser);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Actualiza los datos de un usuario existente en la base de datos.
	 * 
	 * @param newUser Nuevos datos del usuario (tiene que tener igual email)
	 */
	public static void updateUsuario(Usuario newUser) {
		EntityManager em = factoria.createEntityManager();

		em.getTransaction().begin();
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		q.setParameter("email", newUser.getEmail());

		Usuario oldUser = (Usuario) q.getSingleResult();

		oldUser.setApellido(newUser.getApellido());
		oldUser.setNombre(newUser.getNombre());
		
		em.getTransaction().commit();
		em.close();
	}
}
