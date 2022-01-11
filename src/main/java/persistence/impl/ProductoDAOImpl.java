package persistence.impl;

import java.sql.*;
import java.util.*;

import ipersistence.ProductoDAO;
import model.Producto;
import persistence.commons.ConnectionProvider;

public class ProductoDAOImpl implements ProductoDAO {

	private static final String SQL_LISTAR = "SELECT productos.id, nombre, nombre_marca, nombre_tipo_producto, precio_compra, precio_venta, cantidad_en_stock "
			+ "FROM productos " + "LEFT JOIN marcas ON marcas.id=productos.id_marca "
			+ "LEFT JOIN tipo_producto ON tipo_producto.id =productos.id_tipo_producto ";
	private static final String SQL_INSERTAR = "INSERT INTO productos (id,id_tipo_producto,id_marca, nombre, precio_compra, precio_venta, cantidad_en_stock) "
			+ "VALUES (?,?,?,?,?,?,?);";
	private static final String SQL_UPDATE = "UPDATE productos SET id_tipo_producto = ?, id_marca = ?, nombre = ?, precio_compra = ?, precio_venta=?, cantidad_en_stock=? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id = ?";

	public List<Producto> findAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR);
		ResultSet rs = instruccion.executeQuery();
		Producto producto;
		List<Producto> productos = new ArrayList<Producto>();
		while (rs.next()) {

			producto = toProducto(rs);
			productos.add(producto);
		}

		return productos;
	}

	public int countAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement("SELECT count(*) FROM productos");
		ResultSet rs = instruccion.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

	public int insert(Producto t) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_INSERTAR);
		instruccion.setInt(1, t.getId());
		instruccion.setInt(2, obtenerID(t, "tipo_producto"));
		instruccion.setInt(3, obtenerID(t, "marcas"));
		instruccion.setString(4, t.getNombre());
		instruccion.setDouble(5, t.getPrecioCompra());
		instruccion.setDouble(6, t.getPrecioVenta());
		instruccion.setInt(7, t.getCantidadEnStock());

		return instruccion.executeUpdate();
	}

	private int obtenerID(Producto t, String tabla) throws SQLException {
		String sqlComando;
		if (tabla.equals("tipo_producto")) {
			sqlComando = "SELECT * FROM tipo_producto WHERE nombre_tipo_producto='" + t.getTipoProducto() + "'";
		} else if (tabla.equals("marcas")) {
			sqlComando = "SELECT * FROM marcas WHERE nombre_marca='" + t.getMarca() + "'";
		} else {
			return 0;
		}
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(sqlComando);
		ResultSet rs = instruccion.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

	public int update(Producto t) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_UPDATE);
		instruccion.setInt(1, obtenerID(t, "tipo_producto"));
		instruccion.setInt(2, obtenerID(t, "marcas"));
		instruccion.setString(3, t.getNombre());
		instruccion.setDouble(4, t.getPrecioCompra());
		instruccion.setDouble(5, t.getPrecioVenta());
		instruccion.setInt(6, t.getCantidadEnStock());
		instruccion.setInt(7, t.getId());

		return instruccion.executeUpdate();
	}

	public int delete(Producto t) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_DELETE);
		instruccion.setInt(1, t.getId());

		return instruccion.executeUpdate();
	}

	
	@Override
	public Producto findByID(int ID) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR + "WHERE productos.id=" + ID);
		ResultSet rs = instruccion.executeQuery();
		if (rs.next()) {
			return toProducto(rs);
		}
		return null;

	}

	@Override
	public int disminuirStock(Producto producto) throws SQLException {
		String sql="UPDATE productos SET cantidad_en_stock=cantidad_en_stock-? WHERE id = ?;";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(sql);
		instruccion.setInt(1, producto.getCantidadEnStock());
		instruccion.setInt(2, producto.getId());

		return instruccion.executeUpdate();
	}



	@Override
	public Producto find(String tipoProductoABuscar, String marcaABuscar, String nombreABuscar) throws SQLException {
		String sql="WHERE nombre='"+nombreABuscar+"' and nombre_marca='"+ marcaABuscar+"' and nombre_tipo_producto='"+tipoProductoABuscar+"' ;";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR + sql);
		ResultSet rs = instruccion.executeQuery();
		if (rs.next()) {
			return toProducto(rs);
		}
		return null;
	}

	private static Producto toProducto(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String nombre = rs.getString("nombre");
		Double precioCompra = rs.getDouble("precio_compra");
		Double precioVenta = rs.getDouble("precio_venta");
		int cantidadEnStock = rs.getInt("cantidad_en_stock");
		String tipoProducto = rs.getString("nombre_tipo_producto");
		String marca = rs.getString("nombre_marca");
		return new Producto(id, nombre, tipoProducto, marca, precioCompra, precioVenta, cantidadEnStock);
	}

}
