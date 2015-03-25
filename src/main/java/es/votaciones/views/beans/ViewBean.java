package es.votaciones.views.beans;

import javax.faces.bean.ManagedProperty;

import es.votaciones.controllers.ControllerFactory;
import es.votaciones.controllers.ejb.ControllerEjbFactory;



public abstract class ViewBean {

    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;
   
    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

}
