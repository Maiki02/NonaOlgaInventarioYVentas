package ipersistence;

import java.sql.SQLException;
import java.util.List;

import model.Deudor;
import model.Venta;
import persistence.commons.GenericDAO;

public interface iDeudorDAO extends GenericDAO<Deudor>{

	Deudor findByName(String name) throws SQLException;

	Deudor findById(Integer id) throws SQLException;
	
	
}
