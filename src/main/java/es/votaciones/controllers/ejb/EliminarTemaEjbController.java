package es.votaciones.controllers.ejb;



import es.votaciones.controllers.EliminarTemaController;
import es.votaciones.persistence.models.daos.DaoFactory;

public class EliminarTemaEjbController extends ListarTodosEjbController implements EliminarTemaController {
	private static final Integer CLAVE_BORRADO=666;
	
	@Override
	public void eliminar(Integer idTema) {
		DaoFactory.getFactory().getTemaDao().deleteById(idTema);
	}

	@Override
	public boolean validarClave(Integer claveBorrado) {
		
		return claveBorrado.equals(CLAVE_BORRADO);
	}
}
