package es.votaciones.persistence.models.daos.jdbc;

import java.util.List;

import es.votaciones.persistence.models.daos.VotoDao;
import es.votaciones.persistence.models.entities.Voto;

public class VotoDaoJdbc extends GenericDaoJdbc<Voto, Integer> implements VotoDao{

	@Override
	public void create(Voto voto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Voto read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto voto) {
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

	public static String sqlToCreateTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
