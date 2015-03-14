package es.votaciones.persistence.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
   		List<Voto> votos= findAllVotosbyTemaId(tema.getId());
		for (Voto voto : votos) {
			try{
			  entityManager.getTransaction().begin();
			  voto=entityManager.getReference(Voto.class,voto.getId());
		      entityManager.remove(voto);   
		      entityManager.getTransaction().commit();
		      LogManager.getLogger(GenericDaoJpa.class).debug("delete: " + voto);
		      entityManager.close();
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
		
	}

	@Override
	public List<Voto> findAllVotosbyTemaId(Integer id) {
		 EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
	        // Se crea un criterio de consulta
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Voto> criteriaQuery = criteriaBuilder.createQuery(Voto.class);
            Root<Tema> rootTema = criteriaQuery.from(Tema.class);
	        // Se establece la clausula FROM
            
	        Root<Voto> rootVoto = criteriaQuery.from(Voto.class);

	       
	        criteriaQuery.select(rootVoto); // criteriaQuery.multiselect(root.get(atr))
            
	        Predicate predicate = criteriaBuilder.equal(rootTema, rootVoto.get("tema"));
            Predicate predicate2 = criteriaBuilder.equal(rootTema.get("id"), id);
            
               
	        // Se realiza la query
	        criteriaQuery.where(criteriaBuilder.and(predicate,predicate2));
	        
	        TypedQuery<Voto> typedQuery = entityManager.createQuery(criteriaQuery);
	        typedQuery.setFirstResult(0); // El primero es 0
	        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
	        List<Voto> result = typedQuery.getResultList();
	        entityManager.close();
	        return result;
	}
   @Override
   public void deleteById(Integer id) {
	   deleteVotosByTema(this.read(id));
	super.deleteById(id);
}
}
