package es.votaciones.persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.votaciones.persistence.models.daos.TemaDao;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements TemaDao {
	 private Logger log = LogManager.getLogger(TemaDaoJdbc.class);
	 
	
	 private Tema create(ResultSet resultSet) {
		  try {
			if(resultSet!=null&& resultSet.next()){
				Tema tema = new Tema(resultSet.getString(Tema.DESCRIPCION), resultSet.getString(Tema.PREGUNTA));
				tema.setId(resultSet.getInt(Tema.ID));
				return tema;
			  }
		} catch (SQLException e) {
			 log.error("read: " + e.getMessage());
		}
		 return null;
	 }
	 
	private static final String SQL_INSERT = "INSERT INTO %s (%s,%s) VALUES ('%s','%s')";
	@Override
	public void create(Tema tema) {
		  this.updateSql(String.format(SQL_INSERT, Tema.TABLE, Tema.DESCRIPCION, Tema.PREGUNTA));
		  tema.setId(this.autoId());
		}

	@Override
	public Tema read(Integer id) {
		 ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Tema.TABLE, id));
	    return this.create(resultSet);
	}
	
	private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s' WHERE ID=%d";
	@Override
	public void update(Tema tema) {
		this.updateSql(String.format(SQL_UPDATE, Tema.TABLE, Tema.DESCRIPCION, tema.getDescripcion(),
				Tema.PREGUNTA, tema.getPregunta(), Tema.ID, tema.getId()));
	}

	@Override
	public void deleteById(Integer id) {
		this.updateSql(String.format(SQL_DELETE_ID, Tema.TABLE, id));
	}

	@Override
	public List<Tema> findAll() {
		List<Tema> lista = new ArrayList<Tema>();
		ResultSet resultSet=this.query(String.format(SQL_SELECT_ALL, Tema.TABLE));
		Tema tema = this.create(resultSet);
		while(resultSet!=null){
			lista.add(tema);
			tema= this.create(resultSet);
		}
		return lista;
	}
	

	private static final String SQL_CREATE_TABLE ="CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT, %s VARCHAR(255), "
            + "%s VARCHAR(255)";
	
	public static String sqlToCreateTable() {
			return String.format(SQL_CREATE_TABLE, Tema.TABLE, Tema.ID, Tema.DESCRIPCION, Tema.PREGUNTA );
	}

	
	@Override
	public void deleteVotosByTema(Tema tema) {
		// TODO Auto-generated method stub
		
	}
	
}
