package controller.productos;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.*;

@WebServlet("/datos/create-tipo-producto.do")
public class AddTipoDeProductoServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private TipoProductoService tipoDeProductoService;

	@Override
	public void init() throws ServletException {
		super.init();
		
		this.tipoDeProductoService = new TipoProductoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tipoProducto= req.getParameter("tipo-producto-nuevo").trim();
		
		try {
			tipoDeProductoService.create(tipoProducto);
			resp.sendRedirect("/Nonaolga/datos/index.jsp");
		} catch(Exception e) {
			req.setAttribute("flash", "Ocurrio un error para cargar el tipo de producto");

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/Nonaolga/datos/index.jsp");
			dispatcher.forward(req, resp);
		}
		

	}
	
	

}
