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
			 return voto;
			}
		} catch (SQLException e) {
			log.error("read: " + e.getMessage());
		}
		return null;
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

	 private static final String SQL_SELECT_NIVEL_ESTUDIOS = "SELECT * FROM %s WHERE nivelEstudio=%d";
	@Override
	public List<Voto> votosPorNivel(NivelEstudio nivelEstudio) {
		List<Voto> list = new ArrayList<Voto>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_NIVEL_ESTUDIOS, Voto.TABLE, nivelEstudio.ordinal()));
        Voto voto = this.create(resultSet);
        while (voto != null) {
            list.add(voto);
            voto = this.create(resultSet);
        }
        return list;
	}

	private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s', %s, %s, %s)";
	@Override
	public void create(Voto voto) {
		this.updateSql(String.format(VotoDaoJdbc.SQL_INSERT, Voto.TABLE,  Voto.IP, Voto.NIVEL_ESTUDIO, Voto.VALORACION, Voto.TEMA_ID, voto.getIp(), voto.getNivelEstudio().ordinal(), voto.getValoracion(), voto.getTema().getId()));
		voto.setId(this.autoId());
	}


	@Override
	public Voto read(Integer id) {
		 ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Voto.TABLE, id));
		    return this.create(resultSet);
	}

	private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s=%d,%s=%d, %s=%d  WHERE ID=%d";
	@Override
	public void update(Voto voto) {
		this.updateSql(String.format(SQL_UPDATE, Voto.TABLE, 
				Voto.IP, voto.getIp(),
				Voto.NIVEL_ESTUDIO, voto.getNivelEstudio().ordinal(), 
				Voto.VALORACION, voto.getValoracion(), 
				Voto.TEMA_ID, voto.getTema().getId(), Voto.ID, voto.getId()));
		
	}


	@Override
	public void deleteById(Integer id) {
		this.updateSql(String.format(SQL_DELETE_ID, Voto.TABLE, id));
		
	}
	private static final String SQL_SELECT_ALL_VOTOS_BY_TEMAID = "SELECT * FROM %s WHERE %s=%d";
	@Override
	public List<Voto> findAllVotosbyTemaId(Integer id) {
		List<Voto> list = new ArrayList<Voto>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL_VOTOS_BY_TEMAID, Voto.TABLE, Voto.TEMA_ID, id));
        Voto voto = this.create(resultSet);
        while (voto != null) {
            list.add(voto);
            voto = this.create(resultSet);
        }
        return list;
	}


}
