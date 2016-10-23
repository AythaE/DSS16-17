/*
 * Archivo: ControlMB.java 
 * Proyecto: manejadorEventosAsincronos
 * 
 * Autor: Aythami Estévez Olivas
 * Email: aythae@correo.ugr.es
 * Fecha: 23-oct-2016
 * Asignatura: Desarrollo de Sistemas Software basados en Componentes y Servicios
 */
package es.ugr.dss;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name="controlMB", eager=true)
@SessionScoped
/**
 * Clase de tipo ManagedBean encargada de controlar los eventos lanzados desde
 * la vista y variar los elementos de la vista en función de estos.
 * 
 * @author aythae
 */
public class ControlMB {
	
	/** Enumeracion que contiene los posibles valores del estado */
	private enum Estado  {Encendido, Apagado};
	
	/** Atributo que contiene el valor del panel central de la vista */
	private String panel = "Apagado";
	/** 
	 * Atributo de tipo Estado que sirve para almacenar el estado del sistema
	 *  {@link ControlMB#estado}  
	 */
	private Estado estado = Estado.Apagado;
	/** 
	 * Atributo que contene el valor textual del boton de encendido/apagado
	 * y varía con las pulsaciones de este
	 */
	private String txtBoton = "Encender";
	/** 
	 * Atributo que contene el color del boton de encendido/apagado y varía con
	 * las pulsaciones de este
	 */
	private String colorBoton= "green";
	
	

	/**
	 * Constructor para asegurarse que los atributos tienen los valores iniciales
	 * adecuados
	 */
	public ControlMB() {
		panel = "Apagado";
		estado = Estado.Apagado;
		txtBoton = "Encender";
		colorBoton= "green";
	}

	
	/**
	 * ActionListener que controla la pulsación del boton de encendido/apagado.
	 *
	 * @param e ActionEvent 
	 */
	public void onOff(ActionEvent e){
	
		if (estado==Estado.Apagado) {
			estado=Estado.Encendido;
			panel = estado.toString();
			txtBoton= "Apagar";
			colorBoton="red";
			
			Main.arrancar();
		}
		else{
			estado=Estado.Apagado;
			panel = estado.toString();
			txtBoton = "Encender";
			colorBoton= "green";
			
			Main.parar();
		}
	}
	
	public void acelerar(ActionEvent e){
		
		if (estado == Estado.Encendido) {
			panel="Acelerando...";
			
			Main.acelerar();
		}
	}
	
	public void setPanel(String panel) {
		this.panel = panel;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void setTxtBoton(String txtBoton) {
		this.txtBoton = txtBoton;
	}

	public void setColorBoton(String colorBoton) {
		this.colorBoton = colorBoton;
	}

	public Estado getEstado() {
		
		return estado;
	}

	public String getTxtBoton() {
		
		return txtBoton;
	}

	public String getColorBoton() {
	
		return colorBoton;
	}

	public String getPanel() {
		return panel;
	}



}
