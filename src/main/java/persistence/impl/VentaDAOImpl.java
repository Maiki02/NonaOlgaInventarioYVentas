package persistence.impl;

import java.sql.*;
import java.util.*;

import ipersistence.VentaDAO;
import model.*;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;

public class VentaDAOImpl implements VentaDAO {
	private static final String SQL_LISTAR = "SELECT * FROM ventas "
			+ "LEFT JOIN metodos_de_pago ON metodos_de_pago.id_metodo = ventas.id_metodo_de_pago ";
	private static final String SQL_INSERTAR = "INSERT INTO ventas (precio_total, id_metodo_de_pago, costo_venta) VALUES (?,?,?);";
	private static final String SQL_UPDATE = "UPDATE ventas SET precio_total=?, id_metodo_de_pago=? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM ventas WHERE id = ?";

	@Override
	public List<Venta> findAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR);
		ResultSet rs = instruccion.executeQuery();
		List<Venta> ventas = new ArrayList<Venta>();

		while (rs.next()) {
			Venta venta = toVenta(rs);
			ventas.add(venta);
		}

		return ventas;
	}

	private Venta toVenta(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String fecha = rs.getString("fecha");
		Double precioDeVenta = rs.getDouble("precio_total");
		String metodoDePago = rs.getString("metodo_de_pago");
		Double costo= rs.getDouble("costo_venta");
		List<Producto> productosVendidos = obtenerProductosComprados(id);
		Venta venta= new Venta(id, fecha, metodoDePago, productosVendidos, precioDeVenta, costo);
		
		
		return venta;
	}

	@Override
	public List<Venta> findAllFor(String tiempo, String date) throws SQLException {
		String sql=null;
		if(tiempo.equals("dia") || tiempo.equals("mes") || tiempo.equals("anio")) {
			sql="WHERE fecha LIKE ('"+date+"%');";
		} else if(tiempo.equals("semana")) {
			sql="WHERE DATE_ADD(fecha, INTERVAL(-WEEKDAY(fecha)) DAY) LIKE ('"+date+"%');";
		}
		
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR + sql);
		ResultSet rs = instruccion.executeQuery();
		List<Venta> ventas = new ArrayList<Venta>();

		while (rs.next()) {
			Venta venta=toVenta(rs);
			ventas.add(venta);
		}

		return ventas;
	}	
	
	private List<Producto> obtenerProductosComprados(int id) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(
				"SELECT ventas.id, cantidad_de_productos, id_producto FROM productos_de_la_venta "
				+ "JOIN ventas ON ventas.id = productos_de_la_venta.id_venta WHERE ventas.id="+ id);
		ResultSet rs = instruccion.executeQuery();
		// -----------------------------------------
		Producto nuevoProducto;
		List<Producto> productos = new LinkedList<Producto>();
		while (rs.next()) {
			int idProducto = rs.getInt("id_producto");
			int cantidad = rs.getInt("cantidad_de_productos");
			nuevoProducto = DAOFactory.getProductoDAO().findByID(idProducto);
			nuevoProducto.setCantidad(cantidad);
			productos.add(nuevoProducto);
		}
		return productos;
	}

	@Override
	public int countAll() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement("SELECT count(*) FROM ventas");
		ResultSet rs = instruccion.executeQuery();
		return rs.getInt(1);
	}

	@Override
	public int insert(Venta t) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_INSERTAR);
		instruccion.setDouble(1, t.getPrecioDeVenta());
		instruccion.setInt(2, obtenerID(t.getMetodoDePago()));
		instruccion.setDouble(3, t.getCosto());
		return instruccion.executeUpdate();
	}

	@Override
	public int insertarProductoVendido(Venta venta, Producto producto, Integer cantidad) throws SQLException {
		String sql="INSERT INTO productos_de_la_venta (id_venta, id_producto, cantidad_de_productos) VALUES (?,?,?);";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(sql);
		instruccion.setInt(1, venta.getID());
		instruccion.setInt(2, producto.getId());
		instruccion.setInt(3, cantidad);
		
		return instruccion.executeUpdate();
	}

	private int obtenerID(String metodoDePago) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn
				.prepareStatement("SELECT id_metodo FROM metodos_de_pago WHERE metodo_de_pago='" + metodoDePago + "'");
		ResultSet rs = instruccion.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	@Override
	public int update(Venta t) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_UPDATE);
		instruccion.setDouble(1, t.getPrecioDeVenta());
		instruccion.setInt(2, obtenerID(t.getMetodoDePago()));
		instruccion.setInt(3, t.getID());


		return instruccion.executeUpdate();
	}

	@Override
	public int delete(Venta t) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_DELETE);
		instruccion.setInt(1, t.getID());

		return instruccion.executeUpdate();
	}

	
	@Override
	public Integer saberUltimoId() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement("SELECT MAX(id) AS id FROM ventas");
		ResultSet rs = instruccion.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return null;
	}
	
	@Override
	public Venta findByID(int id) throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement instruccion = conn.prepareStatement(SQL_LISTAR + "WHERE id=" + id);
		ResultSet rs = instruccion.executeQuery();
		Venta venta = null;
		while (rs.next()) {
			 venta = toVenta(rs);
		}

		return venta;
	}

}
