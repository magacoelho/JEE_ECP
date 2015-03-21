package es.votaciones.views.beans;

import org.apache.logging.log4j.LogManager;

import es.votaciones.controllers.ControllerFactory;

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
	
	public void update(){
		if(this.claveBorrado!=null)
		this.conAcceso= ControllerFactory.getControllerFactory().getEliminarTemaController().validarClave(this.claveBorrado);
	}
	
	
	public String process(){
		if(ControllerFactory.getControllerFactory().getEliminarTemaController().validarClave(this.claveBorrado)){
	    	  LogManager.getLogger(EliminarViewBean.class).debug(
	                 "Se accede a la capa de negocio para confirmar acceso " + this.claveBorrado);
	         
	        return "eliminar";}
	    else
			return "preeliminar";
	}
}
