package es.votaciones.persistence.models.daos.jpa;

import java.util.List;

import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	public TemaDaoJpa() {
		super(Tema.class);
	}

}
