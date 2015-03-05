package es.votaciones.persistence.models.daos.jpa;

import java.util.List;

import es.votaciones.persistence.models.daos.VotoDao;
import es.votaciones.persistence.models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

	public VotoDaoJpa() {
		super(Voto.class);
	}

	@Override
	public void create(Voto entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Voto read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Voto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
