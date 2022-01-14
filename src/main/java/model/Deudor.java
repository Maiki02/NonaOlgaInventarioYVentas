package model;

public class Deudor {

	private int id;
	private String nombre;
	private double totalAPagar;
	private double totalPagado;
	private Venta ventaAsociada;
	private boolean esVisible;
	
	public Deudor(int id, String nombre, double totalAPagar, double totalPagado, Venta ventaAsociada) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.totalAPagar = totalAPagar;
		this.totalPagado = totalPagado;
		this.ventaAsociada = ventaAsociada;
this.esVisible=true;
	}
	
	public Deudor(String nombre, double totalAPagar, Venta ventaAsociada) {
		super();
		this.nombre = nombre;
		this.totalAPagar = totalAPagar;
		this.totalPagado = 0;
		this.ventaAsociada = ventaAsociada;
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

	public double getTotalAPagar() {
		return totalAPagar;
	}

	public void setTotalAPagar(double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}

	public double getTotalPagado() {
		return totalPagado;
	}

	public void setTotalPagado(double totalPagado) {
		this.totalPagado = totalPagado;
	}

	public Venta getVentaAsociada() {
		return ventaAsociada;
	}

	public void setVentaAsociada(Venta ventaAsociada) {
		this.ventaAsociada = ventaAsociada;
	}

	public boolean esVisible() {
		return esVisible;
	}

	public void setEsVisible(boolean esVisible) {
		this.esVisible = esVisible;
	}

	public void acreditarPago(Double importePagado) {
		this.totalPagado+=importePagado;
		if(esDeudaPagada()) {
			this.esVisible=false;
		}
	}
	
	private boolean esDeudaPagada() {
		return this.getDeudaRestante() <= 0; 
	}
	
	public double getDeudaRestante() {
		return this.totalAPagar- this.totalPagado;
	}

	@Override
	public String toString() {
		return "Deudor [id=" + id + ", nombre=" + nombre + ", totalAPagar=" + totalAPagar + ", totalPagado="
				+ totalPagado + ", ventaAsociada=" + ventaAsociada + "]";
	}
	
	
	
	
	
	
}
