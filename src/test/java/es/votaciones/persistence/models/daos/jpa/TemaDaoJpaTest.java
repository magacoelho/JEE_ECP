package es.votaciones.persistence.models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.daos.jpa.data.TemaDaoJpaTestData;
import es.votaciones.persistence.models.entities.Tema;



public class TemaDaoJpaTest {
	
	private TemaDao dao= DaoJpaFactory.getFactory().getTemaDao();
	private TemaDaoJpaTestData data;
	
	@Before
	public void init(){
		data= new TemaDaoJpaTestData();
	  // aqui tendria que meter lo de borrar las tablas...
	
	}
	
   @Test
   public void testCreate(){
	 List<Tema>  temasData= new ArrayList<Tema> ();
	 
	 while(data.hasNextTema()){
		 if(data.getTema()!=null){
			 
		 dao.create(data.getTema());
		 temasData.add(data.getTema());
		 }
		 data.nextTema();
		 
	 }
	 
	 
	 
	 
	   
   }
}
