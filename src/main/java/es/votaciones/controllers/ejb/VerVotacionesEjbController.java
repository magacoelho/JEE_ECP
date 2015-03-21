package es.votaciones.controllers.ejb;

import java.util.ArrayList;
import java.util.List;

import es.votaciones.controllers.VerVotacionesController;
import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;
import es.votaciones.persistence.models.utils.NivelEstudio;
import es.votaciones.persistence.models.utils.VotosPorNivel;
import es.votaciones.persistence.models.utils.VotosPorTema;

public class VerVotacionesEjbController extends ListarTodosEjbController implements VerVotacionesController {


	@Override
	public List<VotosPorTema> votosPorTema() {
		List<VotosPorTema> votosPorTema = new ArrayList<VotosPorTema>();
		List<Tema> temas = super.todosTemas();
		for (Tema tema : temas) {
			VotosPorTema v= new VotosPorTema();
			v.setTema(tema);
			v.setSuma(DaoFactory.getFactory().getTemaDao().findAllVotosbyTemaId(tema.getId()).size());
			votosPorTema .add(v);
		}
		return votosPorTema;
	}

	@Override
	public List<VotosPorNivel> votosPorNivel() {
		// TODO Auto-generated method stub
		return null;
	}

}
