package es.votaciones.persistence.models.daos.jpa;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.daos.VotoDao;
import es.votaciones.persistence.models.daos.jpa.data.TemaDaoJpaTestData;
import es.votaciones.persistence.models.daos.jpa.data.VotoDaoJpaTestData;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;

public class VotoDaoJpaTest {
   private VotoDao dao=DaoJpaFactory.getFactory().getVotoDao();
   private VotoDaoJpaTestData data;
   
   private TemaDao daoTema= DaoJpaFactory.getFactory().getTemaDao(); 
   private TemaDaoJpaTestData dataTema;
   private List<Tema>  temasData;
  
   @BeforeClass 
   public static void beforeClass(){
	   DaoJpaFactory.dropAndCreateTables();
	   DaoFactory.setFactory(new DaoJpaFactory());
	  }
   
   @Before
   public void init(){
	   data = new VotoDaoJpaTestData();
	   dataTema= new TemaDaoJpaTestData();
	   //crear Temas
	    temasData= new ArrayList<Tema> ();
		 
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
	        List<Voto>  votos= new ArrayList<Voto> ();
			 int i=0;
			 while(data.hasNextVoto()){
				 if(data.getVoto()!=null){
					
					 System.out.println("!!!Voto Id: " + data.getVoto().getId() + ": " + data.getVoto());
					 data.getVoto().setTema(temasData.get(i));
					 dao.create(data.getVoto());
					 votos.add(data.getVoto());
					 if(i==3)
							i=0;
						 i++;
				 }
				 data.nextVoto();
			 }
	
 }
   @Test
   public void createTest(){
	   
	   
	   
   }
   
   @Before
   public void before(){
	   
	   // borrar todos los creados en BBBDDD
	   
   }
   
   @AfterClass
  public static void afterClass(){
	   DaoJpaFactory.dropAndCreateTables();  
	   
   }
	 
}
