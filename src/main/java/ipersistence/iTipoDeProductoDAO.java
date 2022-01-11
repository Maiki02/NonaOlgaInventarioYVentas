package ipersistence;

import java.sql.SQLException;

import model.Producto;
import persistence.commons.GenericDAO;

public interface iTipoDeProductoDAO extends GenericDAO<String> {

	int update(String tipoProducto, Integer id) throws SQLException;

	
}
