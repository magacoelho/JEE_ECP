package es.votaciones.views.beans;

import org.apache.logging.log4j.LogManager;





import es.votaciones.controllers.AgregarTemaController;
import es.votaciones.controllers.ControllerFactory;
import es.votaciones.controllers.ejb.AgregarTemaEjbController;
import es.votaciones.persistence.models.entities.Tema;

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
	
	public void update() {
        LogManager.getLogger(AgregarViewBean.class).debug(
                "Se accede a la capa de negocio para recuperar roles");
        this.tema = tema;//roles = new String[] {"uno", "dos", "tres"};
    }

    public String process() {
        LogManager.getLogger(AgregarViewBean.class).debug(
                "Se accede a la capa de negocio para registrar rol: " + tema);
        AgregarTemaController agregarTemaController = ControllerFactory.getControllerFactory().getAgregarTemaController();
        agregarTemaController.agregar(tema);
         //getControllerFactory().getAgregarTemaController().agregar(getTema());
        return "home";
    }
	
	

}
