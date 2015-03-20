package es.votaciones.views.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.votaciones.controllers.ControllerFactory;
import es.votaciones.persistence.models.entities.Tema;

public class EliminarViewBean extends ViewBean {
	 private List<Tema> temas;
	 private String mensaje;
	 private Integer claveBorrado;
	 private Integer idTema;
	 public EliminarViewBean() {
		 this.temas= new ArrayList<Tema>();
	}
	public Integer getIdTema() {
		return idTema;
	}
	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}
	public List<Tema> getTemas() {
		return temas;
	}
	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	public Integer getClaveBorrado() {
		return claveBorrado;
	}
	public void setClaveBorrado(Integer claveBorrado) {
		this.claveBorrado = claveBorrado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	 
	public void update() {
		
		//if(ControllerFactory.getControllerFactory().getEliminarTemaController().validarClave(this.claveBorrado)){
        LogManager.getLogger(EliminarViewBean.class).debug(
                "Se accede a la capa de negocio para recuperar Temas");
        this.temas = ControllerFactory.getControllerFactory().getEliminarTemaController().todosTemas();
		//}

    }

    public String process() {
        LogManager.getLogger(EliminarViewBean.class).debug(
                "Se accede a la capa de negocio para eliminar Tema: " + idTema);
       ControllerFactory.getControllerFactory().getEliminarTemaController().eliminar(idTema);
        return "home";
    }
	 
}
