package services;

import java.sql.SQLException;
import java.util.List;

import ipersistence.iTipoDeProductoDAO;
import persistence.commons.DAOFactory;

public class TipoProductoService {
	iTipoDeProductoDAO tipoProductoDAO;

	public TipoProductoService() {
		this.tipoProductoDAO = DAOFactory.getTipoDeProductoDAO();
	}

	public List<String> list() {
		try {
			return tipoProductoDAO.findAll();
		} catch (Exception e) {

		}
		return null;
	}
	
	public void create(String nombre) throws SQLException {
		tipoProductoDAO.insert(nombre);
	}
	
	

}
