package controller.ventas;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import model.Venta;
import services.*;

@WebServlet("/ventas/create.do")
public class AddVentaServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private ProductoService productoService;
	private MetodoDePagoService metodoDePagoService;
	private VentaService ventaService;
	private DeudorService deudorService;

	@Override
	public void init() throws ServletException {
		super.init();
		
		this.ventaService= new VentaService();
		this.productoService=new ProductoService();
		this.metodoDePagoService = new MetodoDePagoService();
		this.deudorService= new DeudorService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> metodosDePago =metodoDePagoService.list();
		List<Producto> productos=productoService.list();
		
		req.setAttribute("metodosDePago", metodosDePago);
		req.setAttribute("productos", productos);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ventas/create.jsp");
		dispatcher.forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Double precioVenta= Double.parseDouble(req.getParameter("precio-venta"));
		String metodoPago= req.getParameter("metodo-pago");
		String[] listaProductos= req.getParameter("productos-vendidos").split(";");
		
		try {
			Venta venta=ventaService.create(precioVenta, metodoPago, listaProductos);
			resp.sendRedirect("/Nonaolga/index.jsp");
			
			if(metodoPago.equals("A PAGAR")) {
				String nombreCliente= req.getParameter("nombre-cliente");
				deudorService.create(nombreCliente, precioVenta, venta);
			}
		} catch(Exception e) {
			req.setAttribute("flash", "Ocurrio un error cargando la venta");
			System.err.println(e.getMessage());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/ventas/create.jsp");
			dispatcher.forward(req, resp);
		}
		
		
	}
	
	

}
