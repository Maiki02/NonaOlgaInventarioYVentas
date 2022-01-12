package controller.ventas;

import java.io.IOException;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import model.Venta;
import services.*;

@WebServlet("/ventas/listDay.do")
public class ListVentaDayServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private VentaService ventaService;
	private ProductoService productoService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.productoService = new ProductoService();
		this.ventaService= new VentaService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fecha=req.getParameter("date");
		List<Venta> ventas = ventaService.listForDate(fecha);
		req.setAttribute("ventas", ventas);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ventas/list.jsp");
		dispatcher.forward(req, resp);
	}

}
