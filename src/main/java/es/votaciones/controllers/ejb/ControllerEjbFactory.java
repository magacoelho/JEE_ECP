package es.votaciones.controllers.ejb;

import es.votaciones.controllers.AgregarTemaController;
import es.votaciones.controllers.ControllerFactory;
import es.votaciones.controllers.EliminarTemaController;
import es.votaciones.controllers.VerVotacionesController;
import es.votaciones.controllers.VotarController;

public class ControllerEjbFactory extends ControllerFactory{
    private VotarEjbController votarEjbController;
    private VerVotacionesEjbController verVotacionesEjbController;
    private AgregarTemaController agregarTemaController;
	@Override
	public VotarController getVotarController() {
		if(this.votarEjbController==null)
			this.votarEjbController =new VotarEjbController();
		return this.votarEjbController;
	}

	@Override
	public VerVotacionesController getverVotacionesController() {
		if(this.verVotacionesEjbController==null)
			  this.verVotacionesEjbController= new VerVotacionesEjbController();
		return verVotacionesEjbController;
	}

	@Override
	public AgregarTemaController getAgregarTemaController() {
		if(this.agregarTemaController==null)
			this.agregarTemaController= new AgregarTemaEjbController();
		return agregarTemaController;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		
		return  new EliminarTemaEjbController();
	}

}
