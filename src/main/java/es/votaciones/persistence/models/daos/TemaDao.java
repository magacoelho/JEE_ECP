package es.votaciones.persistence.models.daos;

import es.votaciones.persistence.models.entities.Tema;

public interface TemaDao extends GenericDao<Tema, Integer>{
	public abstract void deleteVotosByTema(Tema tema);
}
