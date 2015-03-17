package es.votaciones.controllers.ejb;

import es.votaciones.controllers.AgregarTemaController;
import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.daos.jpa.DaoJpaFactory;
import es.votaciones.persistence.models.entities.Tema;

public class AgregarTemaEjbController  implements AgregarTemaController{
	
    public AgregarTemaEjbController() {
    	DaoFactory.setFactory(new DaoJpaFactory());
	}
	@Override
	public void agregar(Tema tema) {
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		temaDao.create(tema);
		
	}

}
