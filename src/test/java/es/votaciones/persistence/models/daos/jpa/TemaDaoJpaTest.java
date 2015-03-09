package es.votaciones.persistence.models.daos.jpa;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.daos.jpa.data.TemaDaoJpaTestData;
import es.votaciones.persistence.models.entities.Tema;



public class TemaDaoJpaTest {
	
	private TemaDao dao= DaoJpaFactory.getFactory().getTemaDao(); 
	private TemaDaoJpaTestData data;
	private List<Tema>  temasData;
		
	@BeforeClass
	public static void arranque(){
		
		DaoJpaFactory.dropAndCreateTables();
		DaoFactory.setFactory(new DaoJpaFactory());
		 
   }

	@Before
	public void init(){

		data= new TemaDaoJpaTestData();
		temasData= new ArrayList<Tema> ();
		
		while(data.hasNextTema()){
			if(data.getTema()!=null){
				System.out.println("!!!Tema Id: " + data.getTema().getId() + ": "
						+ data.getTema());
				dao.create(data.getTema());
				temasData.add(data.getTema());
			}
			data.nextTema();
		}
	}
   @Test
   public void testCreate(){
	 
	  List<Tema> temas = dao.findAll();
	  for (Tema tema : temasData) {
		  assertTrue(temas.contains(tema));
	  }
	  assertTrue(temasData.size()==temas.size());
	   }
   
   @Test
   public void testRead(){
   
	   
   }
   
   
  @Test
   public void testUpdate(){
	  
	  
  }
  @Test
   public void testDeleteById(){
	  
	  
	  
  }

   @Test
   public void  findAll(){
	   
   }
   
}