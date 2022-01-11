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

@WebServlet("/productos/edit.do")
public class EditProductServlet extends HttpServlet {

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
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		Producto producto = productoService.find(id);
		List<String> marcas =marcaService.list();
		List<String> tipoProductos= tipoProductoService.list();
		
		req.setAttribute("marcas", marcas);
		req.setAttribute("tipoProductos", tipoProductos);
		req.setAttribute("producto", producto);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productos/edit.jsp");
		dispatcher.forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		String tipoProducto= req.getParameter("tipo-producto");
		String marca= req.getParameter("marca");
		Double costo= Double.parseDouble(req.getParameter("costo-producto"));
		Double precioVenta= Double.parseDouble(req.getParameter("precio-venta"));
		Integer stock= Integer.parseInt(req.getParameter("stock"));
		
		try {
			Producto producto= productoService.update(id, nombre, tipoProducto, marca, costo, precioVenta, stock);
			resp.sendRedirect("/Nonaolga/productos/index.do");
		} catch(Exception e) {
			req.setAttribute("flash", "Ocurrio un error editando el producto");

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/producto/edit.jsp");
			dispatcher.forward(req, resp);
		}
		

	}
	
	

}
