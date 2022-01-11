package controller.productos;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import services.*;

@WebServlet("/productos/create.do")
public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private ProductoService productoService;
	private MarcaService marcaService;
	private TipoProductoService tipoProductoService;

	@Override
	public void init() throws ServletException {
		super.init();
		
		this.productoService=new ProductoService();
		this.marcaService = new MarcaService();
		this.tipoProductoService= new TipoProductoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> marcas =marcaService.list();
		List<String> tipoProductos= tipoProductoService.list();
		req.setAttribute("marcas", marcas);
		req.setAttribute("tipoProductos", tipoProductos);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productos/create.jsp");
		dispatcher.forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String tipoProducto= req.getParameter("tipo-producto");
		String marca= req.getParameter("marca");
		Double costo= Double.parseDouble(req.getParameter("costo-producto"));
		Double precioVenta= Double.parseDouble(req.getParameter("precio-venta"));
		Integer stock= Integer.parseInt(req.getParameter("stock"));
		
		try {
			Producto producto= productoService.create(nombre, tipoProducto, marca, costo, precioVenta, stock);
			resp.sendRedirect("/Nonaolga/index.jsp");
		} catch(Exception e) {
			req.setAttribute("flash", "Ocurrio un error cargando el producto");

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/producto/create.jsp");
			dispatcher.forward(req, resp);
		}
		

	}
	
	

}
