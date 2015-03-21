package es.votaciones.persistence.models.daos.jpa;

import java.util.List;

import es.votaciones.persistence.models.daos.VotoDao;
import es.votaciones.persistence.models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

	public VotoDaoJpa() {
		super(Voto.class);
	}

	@Override
	public List<Voto> votosPorNivel() {
		
		return null;
	}

}
