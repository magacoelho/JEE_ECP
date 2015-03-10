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
		List<Voto> votos= findAllVotosbyTemaId(tema.getId());
		for (Voto voto : votos) {
			
		   // borrar los votos uno a uno.	
		}
		
		
	}

	@Override
	public List<Voto> findAllVotosbyTemaId(Integer id) {
		 EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
	        // Se crea un criterio de consulta
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Voto> criteriaQuery = criteriaBuilder.createQuery(Voto.class);

	        // Se establece la clausula FROM
	        Root<Voto> root = criteriaQuery.from(Voto.class);

	        // Se establece la clausula SELECT
	        criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))

           // No existen predicados
	        Predicate predicate = criteriaBuilder.equal(root.get("tema_id").as(Integer.class),id);
            
	        // Se realiza la query
	        criteriaQuery.where(predicate);
	        TypedQuery<Voto> typedQuery = entityManager.createQuery(criteriaQuery);
	        typedQuery.setFirstResult(0); // El primero es 0
	        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
	        List<Voto> result = typedQuery.getResultList();
	        entityManager.close();
	        return result;
	}

}
