package controller.ventas;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.*;
import services.*;

@WebServlet("/ventas/listDate.do")
public class ListVentaDateServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private VentaService ventaService;
	private ProductoService productoService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.productoService = new ProductoService();
		this.ventaService = new VentaService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fecha = req.getParameter("date");
		Integer tipoBusqueda = Integer.parseInt(req.getParameter("tipo-busqueda"));
		List<Venta> ventas = null;
		switch (tipoBusqueda) {
		case 1:
			ventas = ventaService.listForDate(fecha);
			break;
		case 2:
			ventas = ventaService.listForWeek(fecha);
			break;
		case 3:
			ventas = ventaService.listForMonth(fecha);
			break;
		case 4:
			ventas = ventaService.listForYear(fecha);
			break;
		default:
			break;
		}

		req.setAttribute("ventas", ventas);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ventas/list.jsp");
		dispatcher.forward(req, resp);
	}

}
