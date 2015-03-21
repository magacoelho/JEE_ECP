package es.votaciones.views.beans;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.votaciones.controllers.ControllerFactory;
import es.votaciones.persistence.models.utils.MediaPorNivel;
import es.votaciones.persistence.models.utils.VotosPorTema;

public class VerVotacionesViewBean extends ViewBean{
	
	public List<VotosPorTema> votosPorTemas;
	public List<MediaPorNivel> mediasPorNivel;
	
   public VerVotacionesViewBean() {
	// TODO Auto-generated constructor stub
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
	
	public void update(){
		 LogManager.getLogger(EliminarViewBean.class).debug(
                 "Se accede a la capa de negocio para recuperar Sumatorias");
		this.votosPorTemas=ControllerFactory.getControllerFactory().getverVotacionesController().votosPorTema();
		this.mediasPorNivel=ControllerFactory.getControllerFactory().getverVotacionesController().mediaPorNivel();
	}
	
	public String process(){
		return "home";
	}
	}

