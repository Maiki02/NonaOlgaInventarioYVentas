package model;

public class Producto {
	
	@Override
	public String toString() {
		return tipoProducto + ", "+ marca + ", "+ nombre;
		
	}

	private int id;
	private String nombre;
	private String tipoProducto;
	private String marca;
	private double precioCompra;
	private double precioVenta;
	private int cantidad;

	public Producto (int id, String nombre, String tipoProducto, String marca, double precioCompra, double precioVenta, int cantidad) {
		this.id=id;
		this.nombre=nombre;
		this.tipoProducto=tipoProducto;
		this.marca=marca;
		this.precioCompra=precioCompra;
		this.precioVenta=precioVenta;
		this.cantidad=cantidad;
	}

	public Producto(String nombre, String tipoProducto, String marca, Double costo, Double precioVenta,
			Integer stock) {
		this.nombre=nombre;
		this.tipoProducto=tipoProducto;
		this.marca=marca;
		this.precioCompra=costo;
		this.precioVenta=precioVenta;
		this.cantidad=stock;
	}

	public int getCantidadEnStock() {
		return cantidad;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public String getMarca() {
		return marca;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setPrecioDeCompra(Double costo) {
		this.precioCompra=costo;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}
}
