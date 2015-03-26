package es.votaciones.persistence.models.utils;

import javax.faces.bean.ManagedBean;

import es.votaciones.persistence.models.entities.Tema;
@ManagedBean
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
