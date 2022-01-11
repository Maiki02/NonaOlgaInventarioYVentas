package ipersistence;

import java.sql.SQLException;

import persistence.commons.GenericDAO;

public interface iMetodoDePagoDAO extends GenericDAO<String> {

	int update(String metodo, Integer id) throws SQLException;

	
}
