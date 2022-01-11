package services;

import java.sql.SQLException;
import java.util.List;

import ipersistence.ProductoDAO;
import model.Producto;
import persistence.commons.DAOFactory;

public class ProductoService {
	ProductoDAO productoDAO;

	public ProductoService() {
		this.productoDAO = DAOFactory.getProductoDAO();
	}

	public List<Producto> list() {
		try {
			return productoDAO.findAll();
		} catch (Exception e) {

		}
		return null;
	}
	

	public Producto create(String nombre, String tipoProducto, String marca, Double costo, Double precioVenta, Integer stock) throws SQLException {
		Producto producto= new Producto(nombre, tipoProducto, marca,costo,precioVenta,stock);
		productoDAO.insert(producto);
		return producto;
	}

	public Producto update(Integer id, String nombre, String tipoProducto, String marca, Double costo, Double precioVenta, Integer stock) throws SQLException {
		Producto producto= new Producto(id, nombre, tipoProducto, marca,costo,precioVenta,stock);
		productoDAO.update(producto);
		return producto;
	}
	
	public void registrarMercaderias(String producto, Double costo, Integer cantidad) throws SQLException {
		String[] elementos=producto.split(", ");
		String tipoProducto=elementos[0];
		String marca= elementos[1];
		String nombre= elementos[2];
		

		Producto producto1= productoDAO.find(tipoProducto, marca, nombre);
		
		producto1.setPrecioDeCompra(costo);
		producto1.setCantidad( producto1.getCantidadEnStock() + cantidad);
		productoDAO.update(producto1);
	}

	public void delete(Integer id) {

	}

	public Producto find(Integer id) {
		try {
			return productoDAO.findByID(id);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
		
	}

}
