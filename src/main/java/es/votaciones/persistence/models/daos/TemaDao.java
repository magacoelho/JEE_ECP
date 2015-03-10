package es.votaciones.persistence.models.daos;

import java.util.List;

import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;

public interface TemaDao extends GenericDao<Tema, Integer>{
	public abstract void deleteVotosByTema(Tema tema);
	public abstract List<Voto> findAllVotosbyTemaId(Integer id);
	
}
