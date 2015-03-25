package es.votaciones.views.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

@ManagedBean
public class PreEliminarViewBean extends ViewBean{

	private String mensaje;
	private Integer claveBorrado;
	private boolean conAcceso;
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Integer getClaveBorrado() {
		return claveBorrado;
	}
	public void setClaveBorrado(Integer claveBorrado) {
		this.claveBorrado = claveBorrado;
	}
	public boolean isConAcceso() {
		return conAcceso;
	}
	public void setConAcceso(boolean conAcceso) {
		this.conAcceso = conAcceso;
	}
	@PostConstruct
	public void update(){
		if(this.claveBorrado!=null)
		 this.conAcceso= this.getControllerFactory().getEliminarTemaController().validarClave(this.claveBorrado);
	     if(!this.isConAcceso()) 
	    	 this.mensaje="Error en la clave";
	    
	}
	
	
	public String process(){
		 LogManager.getLogger(EliminarViewBean.class).debug(
                 "Se accede a la capa de negocio para confirmar acceso " + this.claveBorrado);
		if(this.getControllerFactory().getEliminarTemaController().validarClave(this.claveBorrado)){
	          return "eliminar";}
	    else
	    	return "preeliminar";
	}
}
