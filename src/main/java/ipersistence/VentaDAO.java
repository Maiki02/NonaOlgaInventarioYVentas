package ipersistence;

import java.sql.SQLException;
import java.util.List;

import model.Producto;
import model.Venta;
import persistence.commons.GenericDAO;

public interface VentaDAO extends GenericDAO<Venta>{

	int insertarProductoVendido(Venta venta, Producto producto, Integer cantidad) throws SQLException;
	Integer saberUltimoId() throws SQLException;
	List<Venta> findAllForDate(String fecha) throws SQLException;
	
	
	
}
