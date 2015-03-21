package es.votaciones.persistence.models.daos;

import java.util.List;

import es.votaciones.persistence.models.entities.Voto;

public interface VotoDao extends GenericDao<Voto, Integer>{
      public List<Voto> votosPorNivel();
}
