package services;

import java.sql.SQLException;
import java.util.*;
import java.time.*;

import ipersistence.*;
import model.*;
import persistence.commons.DAOFactory;

public class DeudorService {
	VentaDAO ventaDAO;
	ProductoDAO productoDAO;
	iDeudorDAO deudorDAO;

	public DeudorService() {
		this.deudorDAO = DAOFactory.getDeudorDAO();
	}

	public List<Deudor> list() {
		try {
			return deudorDAO.findAll();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public Deudor create(String nombreCliente, Double precioVenta, Venta venta) throws SQLException {
		Deudor deudor= new Deudor(nombreCliente, precioVenta, venta);
		deudorDAO.insert(deudor); //Insertamos el deudor
		
		return deudor; //Lo retornamos
	}

	public Deudor update(Integer id, String nombre, Double totalAPagar, Double totalPagado, Venta ventaAsociada) throws SQLException {
		Deudor deudor= new Deudor(id, nombre, totalAPagar, totalPagado, ventaAsociada);
		deudorDAO.update(deudor);
		return deudor;
	}

	public void delete(Integer id) {

	}

	public Deudor find(Integer id) {
		try {
			return deudorDAO.findById(id);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
		
	}

	public void acreditarPago(Deudor deudor, Double importePagado) throws SQLException {
		deudor.acreditarPago(importePagado);
		deudorDAO.update(deudor);
		
	}

}
