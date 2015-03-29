package es.votaciones.persistence.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.votaciones.persistence.models.daos.VotoDao;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;
import es.votaciones.persistence.models.utils.NivelEstudio;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

	public VotoDaoJpa() {
		super(Voto.class);
	}

	@Override
	public List<Voto> votosPorNivel(NivelEstudio nivelEstudio) {
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Voto> criteriaQuery = criteriaBuilder.createQuery(Voto.class);
        Root<Voto> rootVoto = criteriaQuery.from(Voto.class);
        criteriaQuery.select(rootVoto); 
        
        Predicate predicate = criteriaBuilder.equal(rootVoto.get("nivelEstudio"),nivelEstudio);
        criteriaQuery.where(predicate);
        
        TypedQuery<Voto> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(0); // El primero es 0
        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
        List<Voto> result = typedQuery.getResultList();
        entityManager.close();
      	return result;
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

}
