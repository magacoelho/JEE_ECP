package es.votaciones.persistence.models.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;





import es.votaciones.persistence.models.utils.NivelEstudio;
@Entity
public class Voto implements Serializable {
	public static final String TABLE = "voto";
    
	public static final String ID = "ID";
	
	@Id
	@GeneratedValue
	private Integer id;
	
	public static final String VALORACION = "valoracion";
	
	
	private Integer valoracion;
	
	public static final String NIVEL_ESTUDIO = "nivelEstudio";
	
	@Enumerated(EnumType.STRING)
	private NivelEstudio nivelEstudio;
	
	public static final String IP = "ip";
	private  String ip;
	
	public static final String TEMA_ID = "tema_id";
	
	@ManyToOne
    @JoinColumn(name="tema_id") 
	private Tema tema;
	
	
	public Voto() {
		
	}
	
   



	public Voto(Integer valoracion, NivelEstudio nivelEstudio, String ip,
			Tema tema) {
		super();
		this.valoracion = valoracion;
		this.nivelEstudio = nivelEstudio;
		this.ip = ip;
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

	
	public String getIp() {
		return ip;
	}
	
	
	
	public void setIp(String ip) {
		this.ip = ip;
	}

	public Tema getTema() {
		return tema;
	}


	public void setTema(Tema tema) {
		this.tema = tema;
	}





	@Override
	public String toString() {
		return "Voto [valoracion=" + valoracion + ", nivelEstudio="
				+ nivelEstudio + ", ip=" + ip + ", tema=" + tema + "]";
	}


	
	
}
