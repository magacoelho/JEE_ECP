package es.votaciones.persistence.models.utils;

public class MediaPorNivel {
     private NivelEstudio nivelEstudio;
     private Double media;
     public MediaPorNivel() {
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
