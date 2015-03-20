package es.votaciones.controllers.ejb;

import es.votaciones.controllers.VotarController;
import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;

public class VotarEjbController extends ListarTodosEjbController implements VotarController {

	@Override
	public void votar(Voto voto) {
		Tema aux = DaoFactory.getFactory().getTemaDao().read(voto.getTema().getId());
		voto.setTema(aux);
		DaoFactory.getFactory().getVotoDao().create(voto);
	}

	

}
