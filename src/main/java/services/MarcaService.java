package services;

import java.sql.SQLException;
import java.util.List;

import ipersistence.*;
import model.Producto;
import persistence.commons.DAOFactory;

public class MarcaService {
	iMarcaDAO marcaDAO;

	public MarcaService() {
		this.marcaDAO = DAOFactory.getMarcaDAO();
	}

	public List<String> list() {
		try {
			return marcaDAO.findAll();
		} catch (Exception e) {

		}
		return null;
	}
	
	public void create(String nombre) throws SQLException {
		marcaDAO.insert(nombre);
	}
	
	
}
