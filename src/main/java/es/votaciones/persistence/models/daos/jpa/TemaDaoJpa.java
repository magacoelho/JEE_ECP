package es.votaciones.persistence.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;

import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	public TemaDaoJpa() {
		super(Tema.class);
	}

	@Override
	public void deleteVotosByTema(Tema tema) {
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
		List<Voto> votos=DaoJpaFactory.getFactory().getVotoDao().findAllVotosbyTemaId(tema.getId());
   		try{
   		   entityManager.getTransaction().begin();
   		for (Voto voto : votos) {
			  voto=entityManager.getReference(Voto.class,voto.getId());
		      entityManager.remove(voto);   
		      
		      LogManager.getLogger(GenericDaoJpa.class).debug("delete: " + voto);
		    //  entityManager.close();
   		   }
   		    entityManager.getTransaction().commit();
			}
			catch(Exception e){
				LogManager.getLogger(GenericDaoJpa.class).error("delete: " + e);
                if (entityManager.getTransaction().isActive())
                    entityManager.getTransaction().rollback();
			}
		 finally {
            entityManager.close();
        }
		}
		


	
   @Override
   public void deleteById(Integer id) {
	   EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
	   deleteVotosByTema(this.read(id));
	   super.deleteById(id);
	 entityManager.close();
}
}
