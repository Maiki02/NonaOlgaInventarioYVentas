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

@WebServlet("/productos/entry.do")
public class EntryProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private ProductoService productoService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.productoService = new ProductoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productoString = req.getParameter("producto");
		Double costo = Double.parseDouble(req.getParameter("costo-producto"));
		Integer stock = Integer.parseInt(req.getParameter("cantidad"));

		try {
			productoService.registrarMercaderias(productoString, costo, stock);
			resp.sendRedirect("/Nonaolga/index.do");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			req.setAttribute("flash", "Ocurrio un error cargando el producto");

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.do");
			dispatcher.forward(req, resp);
		}
	}

}
