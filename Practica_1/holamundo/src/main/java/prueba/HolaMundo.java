package prueba;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "holaMundo", eager=true)
@RequestScoped
public class HolaMundo {

	@ManagedProperty(value="#{mensaje}")
	private Mensaje mensajeBean;
	
	
	public HolaMundo() {
		System.out.println("HolaMundo creado");
	}
	
	public String getMensaje() {
		String msg = "Mensaje nulo";
		if (mensajeBean != null) {
			msg = mensajeBean.getMensaje();
		}
		return msg;
	}
	public void setMensajeBean(Mensaje mensaje) {
		this.mensajeBean = mensaje;
	}
	
	

}