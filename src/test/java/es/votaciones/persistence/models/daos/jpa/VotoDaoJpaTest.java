package es.votaciones.persistence.models.daos.jpa;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
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
import es.votaciones.persistence.models.utils.NivelEstudio;

public class VotoDaoJpaTest {
   private VotoDao dao=DaoJpaFactory.getFactory().getVotoDao();
   private VotoDaoJpaTestData data;
   
   private TemaDao daoTema= DaoJpaFactory.getFactory().getTemaDao(); 
   private TemaDaoJpaTestData dataTema;
   private List<Tema>  temasData;
   private List<Voto>  votosData;
   private int beforeTestVoto;
  
   @BeforeClass 
   public static void beforeClass(){
	   DaoJpaFactory.dropAndCreateTables();
	   DaoFactory.setFactory(new DaoJpaFactory());
	  }
   
   @Before
   public void init(){
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
		    data = new VotoDaoJpaTestData();
	        votosData= new ArrayList<Voto> ();
	        beforeTestVoto= dao.findAll().size();
			 int i=0;
			 while(data.hasNextVoto()){
				 if(data.getVoto()!=null){
					
					 System.out.println("!!!Voto Id: " + data.getVoto().getId() + ": " + data.getVoto());
					 data.getVoto().setTema(temasData.get(i));
					 dao.create(data.getVoto());
					 votosData.add(data.getVoto());
					 if(i==temasData.size()-1)
							i=0;
						 i++;
				 }
				 data.nextVoto();
			 }
	
 }
   @Test
   public void readTest(){
	   
	   for (Voto voto : votosData) {
		  assertTrue(dao.read(voto.getId()).equals(voto));
	}
	   
   }
   
   
   @Test
   public void createTest(){
	 Voto votoAux = new Voto(8,NivelEstudio.BACHILLERATO,"0.0.0.1", temasData.get(0));
	 dao.create(votoAux);   
	 votosData.add(votoAux);
	 assertTrue(votoAux.equals(dao.read(votoAux.getId())));   
   }
   @Test 
   public void deleteTest(){
   for (Voto voto : votosData) {
		  dao.deleteById(voto.getId());
		  assertNull(dao.read(voto.getId()));
      }
   }
    
   @Test
   public void updateTest(){
	   for (Voto voto : votosData) {
		      voto.setNivelEstudio(NivelEstudio.UNIVERSIDAD);
			  dao.update(voto);
			  assertTrue(dao.read(voto.getId()).equals(voto));
	      } 
	   
   }
   
   @Test 
   public void findAllTest(){
	   List<Voto> votos = dao.findAll();
	   for (Voto voto : votosData) {
		assertTrue(votos.contains(voto));
	}
	   
	   
   }
	   
  
   @After
   public void after(){
	   
	  for (Voto voto : votosData) {
		  dao.deleteById(voto.getId());
      }
	   
	   for (Tema tema : temasData) {
		   daoTema.deleteById(tema.getId());
	}
   }
}
