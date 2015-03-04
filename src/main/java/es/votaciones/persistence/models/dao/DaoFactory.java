package es.votaciones.persistence.models.dao;


public abstract class DaoFactory {
	public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }
    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }
    
        

}
