package es.votaciones.controllers;



public abstract class ControllerFactory {
	public abstract VotarController getVotarController();
	public abstract VerVotacionesController getverVotacionesController();
	public abstract AgregarTemaController getAgregarTemaController();
	public abstract EliminarTemaController getEliminarTemaController(); 
	

}
