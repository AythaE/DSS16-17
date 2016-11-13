package es.dss.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BDUsuario {

	private static final String PERSISTENCE_UNIT_NAME = "usuario";
	private static EntityManagerFactory factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);;

	
	@SuppressWarnings("unchecked")
	public static List<Usuario> listUsuarios(){
		EntityManager em = factoria.createEntityManager();
		
		Query q = em.createQuery("SELECT u FROM Usuario u");
		
	
		List<Usuario> resultList = q.getResultList();
		
		em.close();
		return resultList;
	}

	public static boolean existEmail(String email){
		EntityManager em = factoria.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		q.setParameter("email", email);
		
		return q.getResultList().size() > 0;
	}
	public static void addUsuario(Usuario user) {
		EntityManager em = factoria.createEntityManager();

		em.getTransaction().begin();

		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
	
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
