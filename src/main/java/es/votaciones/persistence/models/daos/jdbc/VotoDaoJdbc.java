package es.votaciones.persistence.models.daos.jdbc;

import java.util.List;

import es.votaciones.persistence.models.daos.VotoDao;
import es.votaciones.persistence.models.entities.Tema;
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
	 private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s INT, "
	            + "%s VARCHAR(255), %s VARCHAR(255), %s INT, PRIMARY KEY (%s), "
	            + "FOREIGN KEY(%s) REFERENCES %s(ID) )";
	public static String sqlToCreateTable() {
		
		return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.ID, 
				Voto.VALORACION, Voto.NIVEL_ESTUDIO, Voto.IP, Voto.TEMA_ID, Voto.ID,
				Voto.TEMA_ID, Tema.TABLE);
	}

}
