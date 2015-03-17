package es.votaciones.controllers.ejb;

import java.util.List;

import es.votaciones.controllers.VotarController;
import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;

public class VotarEjbController implements VotarController {

	@Override
	public void votar(Voto voto) {
		DaoFactory.getFactory().getVotoDao().create(voto);
	}

	@Override
	public List<Tema> todosTemas() {
		
		return DaoFactory.getFactory().getTemaDao().findAll();
	}

}
