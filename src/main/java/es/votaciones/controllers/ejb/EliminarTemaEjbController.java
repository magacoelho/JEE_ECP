package es.votaciones.controllers.ejb;



import es.votaciones.controllers.EliminarTemaController;
import es.votaciones.persistence.models.daos.DaoFactory;

public class EliminarTemaEjbController extends ListarTodosEjbController implements EliminarTemaController {
	@Override
	public void eliminar(Integer idTema) {
		DaoFactory.getFactory().getVotoDao().deleteById(idTema);
	}
}
