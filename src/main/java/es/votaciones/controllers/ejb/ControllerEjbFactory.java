package es.votaciones.controllers.ejb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.votaciones.controllers.AgregarTemaController;
import es.votaciones.controllers.ControllerFactory;
import es.votaciones.controllers.EliminarTemaController;
import es.votaciones.controllers.VerVotacionesController;
import es.votaciones.controllers.VotarController;
@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory{
    private VotarEjbController votarEjbController;
    private VerVotacionesEjbController verVotacionesEjbController;
    private AgregarTemaController agregarTemaController;
    private EliminarTemaEjbController eliminarTemaEjbController;
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
		if(this.eliminarTemaEjbController==null)
			this.eliminarTemaEjbController=new EliminarTemaEjbController();
		return  eliminarTemaEjbController;
	}

}
