package services;

import java.sql.SQLException;
import java.util.*;
import java.time.*;

import ipersistence.*;
import model.*;
import persistence.commons.DAOFactory;

public class VentaService {
	VentaDAO ventaDAO;
	ProductoDAO productoDAO;

	public VentaService() {
		this.ventaDAO = DAOFactory.getVentaDAO();
		this.productoDAO=DAOFactory.getProductoDAO();
	}

	public List<Venta> list() {
		try {
			return ventaDAO.findAll();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public List<Venta> listForDate(String fecha) {
		try {
			return ventaDAO.findAllFor("dia", fecha);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public List<Venta> listForWeek(String fecha) {
		LocalDate fechaSeleccionada= LocalDate.parse(fecha);
		LocalDate fechaInicioSemana= fechaSeleccionada.plusDays(-fechaSeleccionada.getDayOfWeek().getValue() + 1);
		try {
			return ventaDAO.findAllFor("semana",fechaInicioSemana.toString());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public List<Venta> listForMonth(String fecha) {
		String fechaInicioMes= fecha.substring(0, 7);//Tomamos el año y el mes
		try {
			return ventaDAO.findAllFor("mes",fechaInicioMes);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public List<Venta> listForYear(String fecha) {
		String fechaInicioMes= fecha.substring(0, 4);//Tomamos el año
		try {
			return ventaDAO.findAllFor("anio",fechaInicioMes);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}



	public Venta create(Double precioVenta, String metodoPago, String[] listaProductos) throws SQLException {
		List<Producto> productosVendidos= new ArrayList<Producto>();
		
		for(String producto: listaProductos) {
			String[] datos= producto.split(", ");
			Producto productoVendido= productoDAO.find(datos[0], datos[1], datos[2]);
			productoVendido.setCantidad(Integer.parseInt(datos[3]));
			productosVendidos.add(productoVendido);
		}
		
		Venta venta= new Venta(metodoPago, precioVenta, productosVendidos);
		ventaDAO.insert(venta); //Insertamos la venta
		venta.setId(ventaDAO.saberUltimoId()); //Obtenemos su ID
		
		//Agregamos cada producto a la base de datos
		for(Producto producto: venta.getProductosVendidos()) {
			ventaDAO.insertarProductoVendido(venta, producto, producto.getCantidadEnStock());
			productoDAO.disminuirStock(producto);
		}
		
		return venta;
	}

	public Producto update(Integer id, String nombre, String tipoProducto, String marca, Double costo, Double precioVenta, Integer stock) throws SQLException {
		
		return null;
	}


	public void delete(Integer id) {

	}

	public Venta find(Integer id) {
		try {
			return ventaDAO.findByID(id);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
		
	}

}
