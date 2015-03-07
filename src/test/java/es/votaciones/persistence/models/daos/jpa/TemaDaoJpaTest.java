package es.votaciones.persistence.models.daos.jpa;

import org.junit.Before;

import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.daos.jpa.data.TemaDaoJpaTestData;



public class TemaDaoJpaTest {
	
	private TemaDao dao= DaoJpaFactory.getFactory().getTemaDao();
	private TemaDaoJpaTestData data;
	
	@Before
	public void init(){
		data= new TemaDaoJpaTestData();
	  // aqui tendria que meter lo de borrar las tablas...
	
	}
	

}
