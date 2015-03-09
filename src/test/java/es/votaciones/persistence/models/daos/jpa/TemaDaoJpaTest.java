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
	//"BeforeClass -.--- inyectar el DaoJpaFactory... e invocar a dropandcreatetables-----
	//en AfterClass deberiamos eliminar el 
	
	@BeforeClass
	public static void arranque(){
		
		DaoJpaFactory.dropAndCreateTables();
		DaoJpaFactory.setFactory(new DaoJpaFactory());
   }
	
	
	
	@Before
	public void init(){

		data= new TemaDaoJpaTestData();
	  // aqui tendria que meter lo de borrar las tablas??...
	}
   @Test
   public void testCreate(){
	 List<Tema>  temasData= new ArrayList<Tema> ();
	 
	 while(data.hasNextTema()){
		 if(data.getTema()!=null){
			 System.out.println("!!!Tema Id: " + data.getTema().getId() + ": "
                     + data.getTema());
			 dao.create(data.getTema());
			 temasData.add(data.getTema());
		 }
		 data.nextTema();
	 }
	  List<Tema> temas = dao.findAll();
	  for (Tema tema : temasData) {
		  assertTrue(temas.contains(tema));
		
	  }
	  assertTrue(temasData.size()==temas.size());
	   }
}
