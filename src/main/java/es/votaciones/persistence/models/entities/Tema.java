package es.votaciones.persistence.models.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Tema {
	public static final String TABLE="tema";
	
	public static final String ID = "ID";
	
	
	@Id
	@GeneratedValue
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
		if (getClass() != obj.getClass())
			return false;
		Tema other = (Tema) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pregunta == null) {
			if (other.pregunta != null)
				return false;
		} else if (!pregunta.equals(other.pregunta))
			return false;
		return true;
	}

	
	
	
	

}
