package es.votaciones.persistence.models.daos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

import es.art83.persistence.models.daos.jdbc.DaoJdbcFactory;
import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.daos.VotoDao;

public class DaoJdbcFactory extends DaoFactory{
	 private static final String DRIVER = "com.mysql.jdbc.Driver";

	    private static final String URL = "jdbc:mysql://localhost:3306/jee";

	    private static final String USER = "root";

	    private static final String PASS = "";

	    private static final String DROP_TABLE = "DROP TABLE IF EXISTS %s";

	    private static Connection connection;

	    public static Connection getConnection() {
	        try {
	            if (connection == null || !connection.isValid(0)) {
	                Class.forName(DRIVER);
	                connection = DriverManager.getConnection(URL, USER, PASS);
	            }
	        } catch (ClassNotFoundException e) {
	            LogManager.getLogger(DaoJdbcFactory.class).error(
	                    "Problemas con el driver: " + e.getMessage());
	        } catch (SQLException e) {
	            LogManager.getLogger(DaoJdbcFactory.class).error(
	                    "Problemas con la BD: " + e.getMessage());
	        }
	        return connection;
	    }
	    
	@Override
	public TemaDao getTemaDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VotoDao getVotoDao() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
