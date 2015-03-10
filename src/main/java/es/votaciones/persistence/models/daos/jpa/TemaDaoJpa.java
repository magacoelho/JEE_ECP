package es.votaciones.persistence.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;

import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	public TemaDaoJpa() {
		super(Tema.class);
	}

	@Override
	public void deleteVotosByTema(Tema tema) {
		
		
	}

	@Override
	public List<Voto> findAllVotosbyTemaId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
