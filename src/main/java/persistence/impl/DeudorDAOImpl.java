package persistence.impl;

import java.sql.*;
import java.util.*;

import ipersistence.*;
import model.*;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;

public class DeudorDAOImpl implements iDeudorDAO {
	private static final String SQL_LISTAR="SELECT * FROM deudores ";
	private static final String SQL_VISIBLES= "WHERE es_visible=1 ";
	private static final String SQL_LISTAR_SUMADOS = "SELECT id,nombre_deudor, sum(total_a_pagar) as total_a_pagar, sum(total_pagado) as total_pagado "
			+ "FROM inventario.deudores ";
	private static final String SQL_GROUP_BY="GROUP BY nombre_deudor ";
	private static final String SQL_INSERTAR = "INSERT INTO deudores (nombre_deudor, total_a_pagar, total_pagado, id_venta_asociada) VALUES (?,?,?,?);";
	private static final String SQL_UPDATE = "UPDATE deudores SET nombre_deudor=?, total_a_pagar=?, total_pagado=?, id_venta_asociada=?, es_visible=? WHERE id =?;";
	private static final String SQL_DELETE = "DELETE FROM deudores WHERE id = ?";

	@Override
	public List<Deudor> findAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR + SQL_VISIBLES);
		ResultSet rs = instruccion.executeQuery();
		List<Deudor> deudores = new ArrayList<Deudor>();

		while (rs.next()) {
			Deudor deudor = toDeudor(rs);
			deudores.add(deudor);
		}

		return deudores;
	}

	private Deudor toDeudor(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String nombre = rs.getString("nombre_deudor");
		Double totalAPagar = rs.getDouble("total_a_pagar");
		Double totalPagado = rs.getDouble("total_pagado");
		Venta venta= DAOFactory.getVentaDAO().findByID(rs.getInt("id_venta_asociada"));
		Deudor deudor= new Deudor(id, nombre, totalAPagar, totalPagado, venta);
		
		return deudor;
	}

	@Override
	public int countAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement("SELECT count(*) FROM deudores");
		ResultSet rs = instruccion.executeQuery();
		return rs.getInt(1);
	}

	@Override
	public int insert(Deudor t) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_INSERTAR);
		instruccion.setString(1, t.getNombre());
		instruccion.setDouble(2, t.getTotalAPagar());
		instruccion.setDouble(3, t.getTotalPagado());
		instruccion.setInt(4, t.getVentaAsociada().getID());

		return instruccion.executeUpdate();
	}

	@Override
	public int update(Deudor t) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_UPDATE);
		instruccion.setString(1, t.getNombre());
		instruccion.setDouble(2, t.getTotalAPagar());
		instruccion.setDouble(3, t.getTotalPagado());
		instruccion.setInt(4, t.getVentaAsociada().getID());
		instruccion.setBoolean(5, t.esVisible());
		instruccion.setInt(6, t.getId());

		return instruccion.executeUpdate();
	}

	@Override
	public int delete(Deudor t) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_DELETE);
		instruccion.setInt(1, t.getId());

		return instruccion.executeUpdate();
	}

	@Override
	public Deudor findByName(String name) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR_SUMADOS + "WHERE nombre_deudor='" + name + "' " + SQL_GROUP_BY);
		ResultSet rs = instruccion.executeQuery();
		Deudor deudor=null;

		while (rs.next()) {
			deudor = toDeudor(rs);
		}

		return deudor;
	}

	@Override
	public Deudor findById(Integer id) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR + "WHERE id=" + id);
		ResultSet rs = instruccion.executeQuery();
		Deudor deudor=null;

		while (rs.next()) {
			deudor = toDeudor(rs);
		}

		return deudor;
	}

}
