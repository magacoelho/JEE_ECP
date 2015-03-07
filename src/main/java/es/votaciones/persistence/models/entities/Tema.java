package es.votaciones.persistence.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tema implements Serializable{
	private static final long serialVersionUID = 1L;

	public static final String TABLE="tema";
	
	public static final String ID = "ID";
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	public static final String DESCRIPCION = "descripcion";
	private String  descripcion;
	
	public static final String PREGUNTA = "pregunta";
	private String pregunta;
	
	
	public Tema() {
	
	}

	public Tema(String descripcion, String pregunta) {
		super();
		this.descripcion = descripcion;
		this.pregunta = pregunta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	@Override
	public String toString() {
		return "Tema [id=" + id + ", descripcion=" + descripcion
				+ ", pregunta=" + pregunta + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((pregunta == null) ? 0 : pregunta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Tema other = (Tema) obj;
		return this.getDescripcion().equals(other.getDescripcion())
			&& this.getPregunta().equals(other.getPregunta());
		
	}
}
