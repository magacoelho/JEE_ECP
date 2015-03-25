package es.votaciones.views.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.votaciones.controllers.AgregarTemaController;
import es.votaciones.persistence.models.entities.Tema;

@ManagedBean
public class AgregarViewBean  extends ViewBean{
	
	private Tema tema;
	
	
	public AgregarViewBean() {
		super();
		
	}
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	@PostConstruct
	public void update() {
        LogManager.getLogger(AgregarViewBean.class).debug(
                "Se accede a la capa de negocio para recuperar Temas");
        this.tema = tema;
    }

    public String process() {
        LogManager.getLogger(AgregarViewBean.class).debug(
                "Se accede a la capa de negocio para registrar Tema: " + tema);
        AgregarTemaController agregarTemaController = this.getControllerFactory().getAgregarTemaController();
        agregarTemaController.agregar(tema);
      
        return "home";
    }
}
