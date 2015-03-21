package es.votaciones.persistence.models.utils;

import es.votaciones.persistence.models.entities.Tema;

public class VotosPorTema {
	  private Tema tema;
	  private Integer suma;
	  public VotosPorTema() {
		
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Integer getSuma() {
		return suma;
	}
	public void setSuma(Integer suma) {
		this.suma = suma;
	}
	  
}
