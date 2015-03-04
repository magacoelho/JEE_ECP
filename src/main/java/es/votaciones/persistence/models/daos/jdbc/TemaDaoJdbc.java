package es.votaciones.persistence.models.daos.jdbc;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.entities.Tema;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements TemaDao {
	 private Logger log = LogManager.getLogger(TemaDaoJdbc.class);
	@Override
	public void create(Tema entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tema read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tema entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tema> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static final String SQL_CREATE_TABLE ="CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s VARCHAR(255), "
            + "%s VARCHAR(255)";
	
	public static String sqlToCreateTable() {
			return String.format(SQL_CREATE_TABLE, Tema.TABLE, Tema.ID, Tema.DESCRIPCION, Tema.PREGUNTA );
	}

}