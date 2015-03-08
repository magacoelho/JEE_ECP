package es.votaciones.persistence.models.daos.jpa.data;

import es.votaciones.persistence.models.entities.Voto;

public class VotoDaoJpaTestData {
	public static final String [][] VOTOS ={{"8","192.123.4.5" , "NivelEstudio.PRIMARIA"},
											{"5","192.123.4.5" , "NivelEstudio.BACHILLERATO"},
											{"1","192.123.4.5" , "NivelEstudio.PRIMARIA"},
											{"10","192.123.4.5" , "NivelEstudio.PRIMARIA"},
											{"3","192.123.4.5" , "NivelEstudio.BACHILLERATO"},
											{"6","192.123.4.5" , "NivelEstudio.UNIVERSIDAD"}};
											
	public boolean hasNextVoto() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Voto getVoto() {
		// TODO Auto-generated method stub
		return null;
	}

}
