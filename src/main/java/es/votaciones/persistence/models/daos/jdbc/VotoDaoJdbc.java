package es.votaciones.persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.votaciones.persistence.models.daos.DaoFactory;
import es.votaciones.persistence.models.daos.VotoDao;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;
import es.votaciones.persistence.models.utils.NivelEstudio;

public class VotoDaoJdbc extends GenericDaoJdbc<Voto, Integer> implements VotoDao{

	private Logger log = LogManager.getLogger(VotoDaoJdbc.class);
	public Voto create(ResultSet resultSet) {
		Voto voto;
		Tema tema = null; 
		try {
			if(resultSet!=null&&resultSet.next()){
			  Integer temaid= resultSet.getInt(Voto.TEMA_ID);
			  if(temaid>0){
				  tema= DaoFactory.getFactory().getTemaDao().read(temaid);
			  }
			
			  int vv = resultSet.getInt(Voto.NIVEL_ESTUDIO); 
			 NivelEstudio[] ne = NivelEstudio.values();
			 NivelEstudio ne2= ne[vv];
			 voto= new Voto(resultSet.getInt(Voto.VALORACION),  ne2,resultSet.getString(Voto.IP), tema);	
			}
		} catch (SQLException e) {
			log.error("read: " + e.getMessage());
		}
		return null;
	}

	@Override
	public Voto read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto voto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Voto> findAll() {
		List<Voto> list = new ArrayList<Voto>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Voto.TABLE));
        Voto voto = this.create(resultSet);
        while (voto != null) {
            list.add(voto);
            voto = this.create(resultSet);
        }
        return list;
	}
	 private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s INT, "
	            + "%s INT, %s VARCHAR(255), %s INT, PRIMARY KEY (%s), "
	            + "FOREIGN KEY(%s) REFERENCES %s(ID) )";
	
	 public static String sqlToCreateTable() {
		
		return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.ID, 
				Voto.VALORACION, Voto.NIVEL_ESTUDIO, Voto.IP, Voto.TEMA_ID, Voto.ID,
				Voto.TEMA_ID, Tema.TABLE);
	}

	@Override
	public void create(Voto voto) {
		// TODO Auto-generated method stub
		
	}

}
