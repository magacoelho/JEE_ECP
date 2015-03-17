package es.votaciones.views.beans;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.votaciones.controllers.AgregarTemaController;
import es.votaciones.controllers.ControllerFactory;
import es.votaciones.controllers.VotarController;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;
import es.votaciones.persistence.models.utils.NivelEstudio;

public class VotarViewBean extends ViewBean{
	private List<Tema> temas;
    private Tema tema;
    private Voto voto;
    private NivelEstudio nivelEstudio;
    
	public VotarViewBean() {
		
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
	public void update() {
        LogManager.getLogger(AgregarViewBean.class).debug(
                "Se accede a la capa de negocio para recuperar Temas");
       VotarController votarController = ControllerFactory.getControllerFactory().getVotarController();
       this.temas =votarController.todosTemas();
    }
	
	public String  process(){
		
        LogManager.getLogger(VotarViewBean.class).debug(
                "Se accede a la capa de negocio para registrar Voto: " + voto);
        VotarController votarController = ControllerFactory.getControllerFactory().getVotarController();
        votarController.votar(voto);
        // aqui se invocaria a la capa de Negocio...... osea 
        return "home"; // el string q devuelve es la siguiente vista a mostrar
	    		
		
	}
   
}
