package ipersistence;

import java.sql.SQLException;

import model.Producto;
import model.Venta;
import persistence.commons.GenericDAO;

public interface VentaDAO extends GenericDAO<Venta>{

	int insertarProductoVendido(Venta venta, Producto producto, Integer cantidad) throws SQLException;

	Integer saberUltimoId() throws SQLException;
	
	
	
}
