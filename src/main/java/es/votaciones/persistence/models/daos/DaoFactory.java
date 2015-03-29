package es.votaciones.persistence.models.daos;
import es.votaciones.persistence.models.daos.jdbc.DaoJdbcFactory;
import es.votaciones.persistence.models.daos.jpa.DaoJpaFactory;



public abstract class DaoFactory {
	public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }
    public static DaoFactory getFactory() {
    	   assert factory != null;
    	   if(factory==null)
    	     {  factory= new DaoJdbcFactory();}
           return factory;
       
    }
    
    public abstract TemaDao getTemaDao();
    
    public abstract VotoDao getVotoDao();

}
