package ipersistence;

import java.sql.SQLException;

import model.Producto;
import persistence.commons.GenericDAO;

public interface iMarcaDAO extends GenericDAO<String> {

	int update(String marca, Integer id) throws SQLException;

	
}
