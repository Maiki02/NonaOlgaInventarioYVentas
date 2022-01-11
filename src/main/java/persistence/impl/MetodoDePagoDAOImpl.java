package persistence.impl;

import java.sql.*;
import java.util.*;

import ipersistence.iMetodoDePagoDAO;
import persistence.commons.ConnectionProvider;

public class MetodoDePagoDAOImpl implements iMetodoDePagoDAO {

	private static final String SQL_LISTAR = "SELECT * FROM metodos_de_pago ";
	private static final String SQL_INSERTAR = "INSERT INTO metodos_de_pago (metodo_de_pago) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE metodos_de_pago SET metodo_de_pago= ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM metodos_de_pago WHERE id = ?";

	@Override
	public List<String> findAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR);
		ResultSet rs = instruccion.executeQuery();
		List<String> metodosDePago= new ArrayList<String>();
		
		while (rs.next()) {
			String marca = rs.getString("metodo_de_pago");

			metodosDePago.add(marca);
		}

		return metodosDePago;
	}
	
	@Override
	public int countAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement("SELECT count(*) FROM metodos_de_pago");
		ResultSet rs = instruccion.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

	@Override
	public int insert(String metodoDePago) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_INSERTAR);
		instruccion.setString(1, metodoDePago); 

		return instruccion.executeUpdate();
	}

	@Override
	public int update(String metodoDePago, Integer id) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_UPDATE);
		instruccion.setString(1, metodoDePago);
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
