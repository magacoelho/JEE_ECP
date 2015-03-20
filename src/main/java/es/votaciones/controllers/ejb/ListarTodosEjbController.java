package es.votaciones.controllers.ejb;

import java.util.ArrayList;
import java.util.List;

import es.votaciones.controllers.ListarTodosController;
import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.utils.NivelEstudio;

public class ListarTodosEjbController implements ListarTodosController{

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
