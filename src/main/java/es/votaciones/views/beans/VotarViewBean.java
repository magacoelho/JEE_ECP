package es.votaciones.views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.votaciones.controllers.ControllerFactory;
import es.votaciones.controllers.VotarController;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;
import es.votaciones.persistence.models.utils.NivelEstudio;
@ManagedBean
public class VotarViewBean extends ViewBean{
	private List<Tema> temas;
    private Tema tema;
    private Voto voto;
    private List<NivelEstudio> nivelesEstudio;
    
	public VotarViewBean() {
		
	}
    public List<NivelEstudio> getNivelesEstudio() {
		return nivelesEstudio;
	}
    public void setNivelesEstudio(List<NivelEstudio> nivelesEstudio) {
		this.nivelesEstudio = nivelesEstudio;
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
	
	@PostConstruct
	public void update() {
        LogManager.getLogger(VotarViewBean.class).debug(
                "Se accede a la capa de negocio para recuperar Temas");
       VotarController votarController =this.getControllerFactory().getVotarController();
       this.temas =votarController.todosTemas();
       this.nivelesEstudio=votarController.todosNivelesEstudio();
       this.voto= new Voto();
       this.tema= new Tema();
      
       
    }
	
	public String  process(){
		
        LogManager.getLogger(VotarViewBean.class).debug(
                "Se accede a la capa de negocio para registrar Voto: " + voto);
        VotarController votarController = this.getControllerFactory().getVotarController();
        votarController.votar(voto);
        // aqui se invocaria a la capa de Negocio...... osea 
        return "home"; // el string q devuelve es la siguiente vista a mostrar
	    		
		
	}
   
}
