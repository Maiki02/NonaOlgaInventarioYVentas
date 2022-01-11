package persistence.impl;

import java.sql.*;
import java.util.*;

import ipersistence.iMarcaDAO;
import model.Producto;
import persistence.commons.ConnectionProvider;

public class MarcaDAOImpl implements iMarcaDAO {

	private static final String SQL_LISTAR = "SELECT * FROM marcas ORDER BY nombre_marca ";
	private static final String SQL_INSERTAR = "INSERT INTO marcas (nombre_marca) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE marcas SET nombre_marca= ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM marcas WHERE id = ?";

	@Override
	public List<String> findAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR);
		ResultSet rs = instruccion.executeQuery();
		List<String> marcas= new ArrayList<String>();
		
		while (rs.next()) {
			String marca = rs.getString("nombre_marca");

			marcas.add(marca);
		}

		return marcas;
	}
	
	@Override
	public int countAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement("SELECT count(*) FROM marcas");
		ResultSet rs = instruccion.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

	@Override
	public int insert(String marca) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_INSERTAR);
		instruccion.setString(1, marca); 

		return instruccion.executeUpdate();
	}

	@Override
	public int update(String marca, Integer id) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_UPDATE);
		instruccion.setString(1, marca);
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
