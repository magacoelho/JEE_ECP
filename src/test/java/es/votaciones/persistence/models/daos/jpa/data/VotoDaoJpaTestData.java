package es.votaciones.persistence.models.daos.jpa.data;

import java.util.Iterator;

import es.votaciones.persistence.models.entities.Voto;
import es.votaciones.utils.ArrayToListTransformer;

public class VotoDaoJpaTestData {
	public static final String [][] VOTOS ={{"8","NivelEstudio.PRIMARIA", "192.123.4.5" },
											{"5", "NivelEstudio.BACHILLERATO","192.123.4.5"},
											{"1", "NivelEstudio.PRIMARIA", "192.123.4.5"},
											{"10","NivelEstudio.PRIMARIA", "192.123.4.5"},
											{"3", "NivelEstudio.BACHILLERATO", "192.123.4.5"},
											{"6", "NivelEstudio.UNIVERSIDAD", "192.123.4.5" }};
	
	//Voto
	private Iterator<Voto> votosIterator;
	private Voto voto;
	
	int numVotos=0;
	
	public VotoDaoJpaTestData() {
		votosIterator= ArrayToListTransformer.transformVoto(VOTOS);
		this.nextVoto();
	}
	
	public String message(){
		return "Tema --> "+ numVotos+" Voto :" +voto;
	}
	
	public boolean hasNextVoto() {
    	return votosIterator.hasNext();
	}
   
	public void nextVoto(){
	   numVotos++;
	  voto= votosIterator.next();
	   
   }
	
	public Voto getVoto() {
		return voto;
	}

}
