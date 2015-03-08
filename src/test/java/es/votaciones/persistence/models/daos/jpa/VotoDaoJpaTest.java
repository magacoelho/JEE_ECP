package es.votaciones.persistence.models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.daos.VotoDao;
import es.votaciones.persistence.models.daos.jpa.data.TemaDaoJpaTestData;
import es.votaciones.persistence.models.daos.jpa.data.VotoDaoJpaTestData;
import es.votaciones.persistence.models.entities.Tema;

public class VotoDaoJpaTest {
   private VotoDao dao=DaoJpaFactory.getFactory().getVotoDao();
   private VotoDaoJpaTestData data;
   
   private TemaDao daoTema= DaoJpaFactory.getFactory().getTemaDao(); 
   private TemaDaoJpaTestData dataTema;
   @Before
   public void init(){
	   
	   data = new VotoDaoJpaTestData();
	   dataTema= new TemaDaoJpaTestData();
 }
   
   public void createTest(){
	   //crear Temas
	   List<Tema>  temasData= new ArrayList<Tema> ();
		 
		 while(dataTema.hasNextTema()){
			 if(dataTema.getTema()!=null){
				 System.out.println("!!!Tema Id: " + dataTema.getTema().getId() + ": "
	                     + dataTema.getTema());
				 daoTema.create(dataTema.getTema());
				 temasData.add(dataTema.getTema());
			 }
			 dataTema.nextTema();
		 }
	   // crear Voto..
		 
		 
	   //aosciarlos con temas...
	   
	   
   }
}
