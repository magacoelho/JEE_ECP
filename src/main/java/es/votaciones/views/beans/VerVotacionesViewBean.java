package es.votaciones.views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;




import es.votaciones.persistence.models.utils.MediaPorNivel;
import es.votaciones.persistence.models.utils.VotosPorTema;

@ManagedBean
public class VerVotacionesViewBean extends ViewBean{
	
	private List<VotosPorTema> votosPorTemas;
	private  List<MediaPorNivel> mediasPorNivel;
	
   public VerVotacionesViewBean() {
	   LogManager.getLogger(VerVotacionesViewBean.class).debug(
               "Instanciado el bean");
	}
	
	public List<VotosPorTema> getVotosPorTemas() {
		return votosPorTemas;
	}
	
	public void setVotosPorTemas(List<VotosPorTema> votosPorTemas) {
		this.votosPorTemas = votosPorTemas;
	}
	
	public List<MediaPorNivel> getMediasPorNivel() {
		return mediasPorNivel;
	}
	
	public void setMediasPorNivel(List<MediaPorNivel> mediasPorNivel) {
		this.mediasPorNivel = mediasPorNivel;
	}
	@PostConstruct
	public void update(){
		 LogManager.getLogger(VerVotacionesViewBean.class).debug(
                 "Se accede a la capa de negocio para recuperar Sumatorias");
		this.votosPorTemas=this.getControllerFactory().getverVotacionesController().votosPorTema();
		this.mediasPorNivel=this.getControllerFactory().getverVotacionesController().mediaPorNivel();
	}
	
	public String process(){
		return "home";
	}
	}

