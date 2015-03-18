package es.votaciones.controllers.ejb;

import es.votaciones.controllers.AgregarTemaController;
import es.votaciones.controllers.ControllerFactory;
import es.votaciones.controllers.EliminarTemaController;
import es.votaciones.controllers.VerVotacionesController;
import es.votaciones.controllers.VotarController;

public class ControllerEjbFactory extends ControllerFactory{

	@Override
	public VotarController getVotarController() {
		
		return new VotarEjbController();
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
