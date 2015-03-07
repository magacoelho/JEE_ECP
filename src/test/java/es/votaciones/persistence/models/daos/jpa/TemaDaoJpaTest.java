package es.votaciones.persistence.models.daos.jpa;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;

import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.daos.jpa.data.TemaDaoJpaTestData;
import es.votaciones.persistence.models.entities.Tema;



public class TemaDaoJpaTest {
	
	private TemaDao dao= null; 
	private TemaDaoJpaTestData data;
	
	@Before
	public void init(){
		dao = DaoJpaFactory.getFactory().getTemaDao();
		data= new TemaDaoJpaTestData();
	  // aqui tendria que meter lo de borrar las tablas...
	
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
