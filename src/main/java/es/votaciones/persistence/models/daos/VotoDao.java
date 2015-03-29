package es.votaciones.persistence.models.daos;

import java.util.List;

import es.votaciones.persistence.models.entities.Voto;
import es.votaciones.persistence.models.utils.NivelEstudio;

public interface VotoDao extends GenericDao<Voto, Integer>{
      public List<Voto> votosPorNivel(NivelEstudio nivelEstudio);
      public abstract List<Voto> findAllVotosbyTemaId(Integer id);
}
