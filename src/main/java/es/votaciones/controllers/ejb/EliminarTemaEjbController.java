package es.votaciones.controllers.ejb;



import es.votaciones.controllers.EliminarTemaController;
import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.entities.Tema;


public class EliminarTemaEjbController extends ListarTodosEjbController implements EliminarTemaController {
	@Override
	public void eliminar(Tema tema) {
		DaoFactory.getFactory().getVotoDao().deleteById(tema.getId());
	}
}
