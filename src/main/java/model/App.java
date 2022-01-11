package model;

import java.sql.SQLException;
import java.util.List;

import ipersistence.ProductoDAO;
import persistence.commons.DAOFactory;

public class App {

	public static void main(String[] args) throws SQLException {
		ProductoDAO productoDAO = DAOFactory.getProductoDAO();
		List<Producto> productos=productoDAO.findAll();
		
		for(Producto producto: productos) {
			System.out.println(producto);
		}
		
		System.out.println("Cantidad de productos registrados: " + productoDAO.countAll());
		
		Producto nuevoProducto=	new Producto(8, "Detergente 1L", "Limpieza", "Zorro", 50, 85, 9);
		//System.out.println("Se realio el registro: " + productoDAO.insert(nuevoProducto));
		System.out.println(productoDAO.sumarStock(nuevoProducto, -4));
		
		Producto p=new Producto(1, "Leche", "Lacteo", "Milkaut", 80, 110, 19);
		productoDAO.update(p);
		
	}
	

}
