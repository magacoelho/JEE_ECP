package es.votaciones.controllers;



public abstract class ControllerFactory {
	public static ControllerFactory controllerFactory=null;
	public static void setControllerFactory(ControllerFactory controllerFactory) {
		ControllerFactory.controllerFactory= controllerFactory;
    }
    public static ControllerFactory getControllerFactory() {
    	   assert controllerFactory != null;
           return controllerFactory;
      }
	
	public abstract VotarController getVotarController();
	public abstract VerVotacionesController getverVotacionesController();
	public abstract AgregarTemaController getAgregarTemaController();
	public abstract EliminarTemaController getEliminarTemaController(); 
	

}
