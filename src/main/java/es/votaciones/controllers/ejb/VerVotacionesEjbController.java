package es.votaciones.controllers.ejb;

import java.util.ArrayList;
import java.util.List;

import es.votaciones.controllers.VerVotacionesController;
import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.utils.NivelEstudio;
import es.votaciones.persistence.models.utils.MediaPorNivel;
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
	public List<MediaPorNivel> mediaPorNivel() {
		List<MediaPorNivel> mediaPorNivel = new ArrayList<MediaPorNivel>();
	    List<NivelEstudio> niveles = super.todosNivelesEstudio();
	    for (NivelEstudio nivelEstudio : niveles) {
	    	MediaPorNivel mpN= new MediaPorNivel();
	    	mpN.setNivelEstudio(nivelEstudio);
	    	mpN.setMedia(0.0);
	    	mediaPorNivel.add(mpN);
		}
		return mediaPorNivel;
	}

}
