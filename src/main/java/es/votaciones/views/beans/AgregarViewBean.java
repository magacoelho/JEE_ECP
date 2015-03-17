package es.votaciones.views.beans;

import org.apache.logging.log4j.LogManager;


import es.votaciones.persistence.models.entities.Tema;

public class AgregarViewBean {
	
	private Tema tema;
	
	
	public AgregarViewBean() {
		
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
        this.tema = new Tema();//roles = new String[] {"uno", "dos", "tres"};
    }

    public String process() {
        LogManager.getLogger(AgregarViewBean.class).debug(
                "Se accede a la capa de negocio para registrar rol: " + tema);
        return "home";
    }
	
	

}
