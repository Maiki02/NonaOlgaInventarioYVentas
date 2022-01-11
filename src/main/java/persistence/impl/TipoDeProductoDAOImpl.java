package persistence.impl;

import java.sql.*;
import java.util.*;

import ipersistence.iMarcaDAO;
import ipersistence.iTipoDeProductoDAO;
import model.Producto;
import persistence.commons.ConnectionProvider;

public class TipoDeProductoDAOImpl implements iTipoDeProductoDAO {

	private static final String SQL_LISTAR = "SELECT * FROM tipo_producto ORDER BY nombre_tipo_producto ";
	private static final String SQL_INSERTAR = "INSERT INTO tipo_producto (nombre_tipo_producto) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE tipo_producto SET nombre_tipo_producto= ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM tipo_producto WHERE id = ?";

	@Override
	public List<String> findAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR);
		ResultSet rs = instruccion.executeQuery();
		List<String> tipoProductos= new ArrayList<String>();
		
		while (rs.next()) {
			String tipoProducto = rs.getString("nombre_tipo_producto");

			tipoProductos.add(tipoProducto);
		}

		return tipoProductos;
	}
	
	@Override
	public int countAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement("SELECT count(*) FROM tipo_producto");
		ResultSet rs = instruccion.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

	@Override
	public int insert(String tipoProducto) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_INSERTAR);
		instruccion.setString(1, tipoProducto); 

		return instruccion.executeUpdate();
	}

	@Override
	public int update(String tipoProducto, Integer id) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_UPDATE);
		instruccion.setString(1, tipoProducto);
		instruccion.setInt(2, id);

		return instruccion.executeUpdate();
	}
	
	@Override
	public int delete(String id) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_DELETE);
		instruccion.setString(1, id);

		return instruccion.executeUpdate();
	}

	@Override
	public int update(String t) throws SQLException {
		
		return 0;
	}



	

}
