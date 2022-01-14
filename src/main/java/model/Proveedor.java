package model;

import java.util.List;

public class Proveedor {

	private int id;
	private String nombre;
	private Double costo;
	private List<Producto> productosComprados;
	private boolean esVisible;

	public Proveedor(int id, String nombre, Double costo, List<Producto> productosComprados) {
		this.id=id;
		this.nombre=nombre;
		this.costo=costo;
		this.productosComprados=productosComprados;
		this.esVisible=true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public List<Producto> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosComprados(List<Producto> productosComprados) {
		this.productosComprados = productosComprados;
	}

	public boolean esVisible() {
		return esVisible;
	}

	public void setEsVisible(boolean esVisible) {
		this.esVisible = esVisible;
	}
}
