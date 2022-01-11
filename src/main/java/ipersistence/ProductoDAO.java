package ipersistence;

import java.sql.SQLException;

import model.Producto;
import persistence.commons.GenericDAO;

public interface ProductoDAO extends GenericDAO<Producto> {

	public Producto find(String tipoProducto, String marca, String nombre) throws SQLException;
	public Producto findByID(int ID) throws SQLException;
	int disminuirStock(Producto producto) throws SQLException;
	
}
