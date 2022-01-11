package model;

import java.sql.SQLException;
import java.util.List;

import ipersistence.ProductoDAO;
import ipersistence.VentaDAO;
import persistence.commons.DAOFactory;

public class Tienda {

	private List<Producto> productos;
	private List<Venta> ventas;
	
	public Tienda() throws SQLException {
		ProductoDAO productoDAO= DAOFactory.getProductoDAO();
		VentaDAO ventaDAO = DAOFactory.getVentaDAO();
		this.productos=productoDAO.findAll();
		this.ventas=ventaDAO.findAll();
	}
	
	public double calcularCostoProductosEnStock() {
		double costoTotal=0;
		for(Producto producto: productos) {
			costoTotal+=producto.getPrecioCompra() * producto.getCantidadEnStock();
		}
		return costoTotal;
	}
	
	public double calcularGananciaObtenidaEnVentas() {
		double gananciaTotal=0;
		for(Venta venta: ventas) {
			gananciaTotal += venta.getGanancia();
		}
		return gananciaTotal;
	}
	
	
}
