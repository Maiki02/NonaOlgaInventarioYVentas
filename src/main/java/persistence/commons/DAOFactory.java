package persistence.commons;

import ipersistence.*;
import persistence.impl.*;

public class DAOFactory {

	public static ProductoDAO getProductoDAO() {
		return new ProductoDAOImpl();
	}
	
	public static iMarcaDAO getMarcaDAO() {
		return new MarcaDAOImpl();
	}
	
	public static iTipoDeProductoDAO getTipoDeProductoDAO() {
		return new TipoDeProductoDAOImpl();
	}
	
	public static iMetodoDePagoDAO getMetodoDePagoDAO() {
		return new MetodoDePagoDAOImpl();
	}
	
	public static VentaDAO getVentaDAO() {
		return new VentaDAOImpl();
	}
}
