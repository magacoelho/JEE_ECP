package es.votaciones.persistence.models.daos.jpa;

import org.junit.Before;

import es.votaciones.persistence.models.daos.VotoDao;
import es.votaciones.persistence.models.daos.jpa.data.VotoDaoJpaTestData;

public class VotoDaoJpaTest {
   private VotoDao dao=DaoJpaFactory.getFactory().getVotoDao();
   private VotoDaoJpaTestData data;
   
   @Before
   public void init(){
	   
	   data = new VotoDaoJpaTestData();
 }
}
