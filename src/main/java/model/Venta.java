package model;

import java.util.List;

public class Venta {



	private int id;
	private String fecha;
	private String metodoDePago;
	private List<Producto> productosVendidos;
	private double precioDeVenta;
	private double costo;
	
	public Venta(int id, String fecha, String metodoDePago, List<Producto> productosVendidos, double precioDeVenta, double costo) {
		this.id = id;
		this.fecha = fecha;
		this.metodoDePago= metodoDePago;
		this.productosVendidos = productosVendidos;
		this.precioDeVenta = precioDeVenta;
		this.costo = costo;
	}
	
	public Venta(int id, String fecha, String metodoDePago, List<Producto> productosVendidos, double precioDeVenta) {
		this.id = id;
		this.fecha = fecha;
		this.productosVendidos = productosVendidos;
		this.metodoDePago= metodoDePago;
		this.precioDeVenta = precioDeVenta;
		this.costo= calcularCosto();
	}
	
	public Venta(String metodoDePago, double precioDeVenta, List<Producto> productosVendidos) {
		this.metodoDePago = metodoDePago;
		this.productosVendidos = productosVendidos;
		this.precioDeVenta = precioDeVenta;
		this.costo= calcularCosto();
	}

	public int getID() {
		return id;
	}


	public String getFecha() {
		return fecha;
	}


	public String getMetodoDePago() {
		return metodoDePago;
	}


	public List<Producto> getProductosVendidos() {
		return productosVendidos;
	}


	public double getPrecioDeVenta() {
		return precioDeVenta;
	}


	public double getCosto() {
		return costo;
	}

	private double calcularCosto() {
		double costo = 0;
		for(Producto producto: productosVendidos) {
			costo+=producto.getPrecioCompra() * producto.getCantidadEnStock();
		}
		return costo;
	}
	
	public double getGanancia() {
		return this.precioDeVenta - this.costo;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setProductosVendidos(List<Producto> productosVendidos) {
		this.productosVendidos = productosVendidos;
	}

	public void setPrecioDeVenta(double precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Venta [fecha=" + fecha + ", metodoDePago=" + metodoDePago + ", precioDeVenta=" + precioDeVenta
				+ ", costo=" + costo + "]";
	}
	
	
	
}
