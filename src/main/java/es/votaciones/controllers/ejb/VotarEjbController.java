package es.votaciones.controllers.ejb;

import java.util.ArrayList;
import java.util.List;

import es.votaciones.controllers.VotarController;
import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;
import es.votaciones.persistence.models.utils.NivelEstudio;

public class VotarEjbController implements VotarController {

	@Override
	public void votar(Voto voto) {
		Tema aux = DaoFactory.getFactory().getTemaDao().read(voto.getTema().getId());
		voto.setTema(aux);
		DaoFactory.getFactory().getVotoDao().create(voto);
	}

	@Override
	public List<Tema> todosTemas() {
		
		return DaoFactory.getFactory().getTemaDao().findAll();
	}

	@Override
	public List<NivelEstudio> todosNivelesEstudio() {
		List<NivelEstudio> nivelesEstudio = new ArrayList<NivelEstudio>();
		NivelEstudio[] ne = NivelEstudio.values();
		for (int i = 0; i <ne.length; i++) {
			nivelesEstudio.add(ne[i]);
			
		}
		return nivelesEstudio;
	}

}
