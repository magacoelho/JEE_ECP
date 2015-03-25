package es.votaciones.controllers.ejb;

import es.votaciones.controllers.AgregarTemaController;
import es.votaciones.controllers.ControllerFactory;
import es.votaciones.controllers.EliminarTemaController;
import es.votaciones.controllers.VerVotacionesController;
import es.votaciones.controllers.VotarController;

public class ControllerEjbFactory extends ControllerFactory{
    private VotarEjbController votarEjbController;
	@Override
	public VotarController getVotarController() {
		if(this.votarEjbController==null)
			this.votarEjbController =new VotarEjbController();
		return this.votarEjbController;
	}

	@Override
	public VerVotacionesController getverVotacionesController() {
		
		return new VerVotacionesEjbController();
	}

	@Override
	public AgregarTemaController getAgregarTemaController() {
		return new AgregarTemaEjbController();
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		
		return  new EliminarTemaEjbController();
	}

}
