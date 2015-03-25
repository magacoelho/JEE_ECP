package es.votaciones.views.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.votaciones.controllers.ControllerFactory;
import es.votaciones.persistence.models.entities.Tema;

public class EliminarViewBean extends ViewBean {
	 private List<Tema> temas;
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
	
	
	 
	public void update() {
		
		 LogManager.getLogger(EliminarViewBean.class).debug(
                    "Se accede a la capa de negocio para recuperar Temas");
         this.temas = this.getControllerFactory().getEliminarTemaController().todosTemas();
     }

    public String process() {
   
    	  LogManager.getLogger(EliminarViewBean.class).debug(
                 "Se accede a la capa de negocio para eliminar Tema: " + idTema);
          this.getControllerFactory().getEliminarTemaController().eliminar(idTema);
        return "home";
    }
	 
}
