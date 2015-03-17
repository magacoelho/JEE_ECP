package es.votaciones.persistence.models.utils;

public enum NivelEstudio {
	PRIMARIA, BACHILLERATO, UNIVERSIDAD;
	 @Override
	  public String toString() {
	    switch(this) {
	      case PRIMARIA: return "PRIMARIA";
	      case BACHILLERATO: return "BACHILLERATO";
	      case UNIVERSIDAD: return "UNIVERSIDAD";
	      default: throw new IllegalArgumentException();
	    }
	  }
}
