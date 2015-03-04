package es.votaciones.persistence.models.entities;

import java.io.Serializable;

import es.votaciones.persistence.models.utils.NivelEstudio;

public class Voto implements Serializable {
	public static final String TABLE = "voto";
    
	public static final String ID = "ID";
	private Integer id;
	
	public static final String VALORACION = "valoracion";
	private Integer valoracion;
	
	public static final String NIVEL_ESTUDIO = "nivelEstudio";
	private NivelEstudio nivelEstudio;
	
	public static final String TEMA_ID = "tema_id";
	private Tema tema;
	
	
	public Voto() {
		
	}


	public Voto(Integer valoracion, NivelEstudio nivelEstudio, Tema tema) {
		super();
		this.valoracion = valoracion;
		this.nivelEstudio = nivelEstudio;
		this.tema = tema;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getValoracion() {
		return valoracion;
	}


	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}


	public NivelEstudio getNivelEstudio() {
		return nivelEstudio;
	}


	public void setNivelEstudio(NivelEstudio nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}


	public Tema getTema() {
		return tema;
	}


	public void setTema(Tema tema) {
		this.tema = tema;
	}


	@Override
	public String toString() {
		return "Voto [id=" + id + ", valoracion=" + valoracion
				+ ", nivelEstudio=" + nivelEstudio + ", tema=" + tema + "]";
	}
	
	
}
