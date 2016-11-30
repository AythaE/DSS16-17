package es.ugr.dss.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemCatalogo {

	public enum Color {
		Rojo, Verde, Azul, Negro, Blanco
	}

	private String id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private String tallas;
	private Color color;

	public ItemCatalogo(){ }
	
	public ItemCatalogo(String id, String nombre, String descripcion, Double precio, String tallas, Color color) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tallas = tallas;
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTallas() {
		return tallas;
	}

	public void setTallas(String tallas) {
		this.tallas = tallas;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
