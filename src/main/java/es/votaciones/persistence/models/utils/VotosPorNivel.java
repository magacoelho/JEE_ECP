package es.votaciones.persistence.models.utils;

public class VotosPorNivel {
     private NivelEstudio nivelEstudio;
     private Double media;
     public VotosPorNivel() {
     }
	public NivelEstudio getNivelEstudio() {
		return nivelEstudio;
	}
	public void setNivelEstudio(NivelEstudio nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}
	public Double getMedia() {
		return media;
	}
	public void setMedia(Double media) {
		this.media = media;
	}
     
}
