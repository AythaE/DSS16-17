/*
 * Archivo: Usuario.java 
 * Proyecto: EstevezAythami-P2
 * 
 * Autor: Aythami Estévez Olivas
 * Email: aythae@correo.ugr.es
 * Fecha: 14-nov-2016
 * Asignatura: Desarrollo de Sistemas Software basados en Componentes y Servicios
 */
package es.dss.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase Usuario que representa la entidad que se almacenará en la base de datos.
 */
@Entity
public class Usuario implements Serializable {
	
	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Id en la base de datos, se genera automáticamente. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	
	/** Nombre del usuario. */
	private String nombre;
	
	/** Apellido del usuario. */
	private String apellido;
	
	/** Email del usuario, es único por usarse como clave primaria. */
	@Column(unique = true)
	private String email;
	
	/**
	 * Crea un nuevo usuario vacío.
	 */
	public Usuario () {}
	
	/**
	 * Crea un usuario a partir de otro.
	 *
	 * @param usuario usuario del que se copiaran los datos
	 */
	public Usuario(Usuario usuario) {
		
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.email = usuario.getEmail();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the apellido.
	 *
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Sets the apellido.
	 *
	 * @param apellido the new apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	

}
