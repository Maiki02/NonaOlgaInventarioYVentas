package services;

import java.sql.SQLException;
import java.util.List;

import ipersistence.*;
import persistence.commons.DAOFactory;

public class MetodoDePagoService {
	iMetodoDePagoDAO metodoDePagoDAO;

	public MetodoDePagoService() {
		this.metodoDePagoDAO = DAOFactory.getMetodoDePagoDAO();
	}

	public List<String> list() {
		try {
			return metodoDePagoDAO.findAll();
		} catch (Exception e) {

		}
		return null;
	}
	
	public void create(String nombre) throws SQLException {
		metodoDePagoDAO.insert(nombre);
	}
	
	
}
