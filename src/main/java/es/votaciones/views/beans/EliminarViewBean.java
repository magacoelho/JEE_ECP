package es.votaciones.views.beans;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.votaciones.controllers.ControllerFactory;
import es.votaciones.controllers.EliminarTemaController;
import es.votaciones.persistence.models.entities.Tema;

public class EliminarViewBean extends ViewBean {
	 private List<Tema> temas;
	 private String mensaje;
	 private String claveAcceso;
	 private Integer idTema;
	 
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
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getClaveAcceso() {
		return claveAcceso;
	}
	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}
	 
	public void update() {
        LogManager.getLogger(EliminarViewBean.class).debug(
                "Se accede a la capa de negocio para recuperar Temas");
        this.temas = temas;//roles = new String[] {"uno", "dos", "tres"};
    }

    public String process() {
        LogManager.getLogger(EliminarViewBean.class).debug(
                "Se accede a la capa de negocio para eliminar Tema: " + idTema);
        EliminarTemaController eliminarTemaController = ControllerFactory.getControllerFactory().getEliminarTemaController();
        eliminarTemaController.eliminar(idTema);
       
        return "home";
    }
	 
	 
	 

}
