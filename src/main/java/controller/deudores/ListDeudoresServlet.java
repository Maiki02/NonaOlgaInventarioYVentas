package controller.deudores;

import java.io.IOException;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Deudor;
import model.Producto;
import model.Venta;
import services.*;

@WebServlet("/deudores/index.do")
public class ListDeudoresServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private DeudorService deudorService;
	private VentaService ventaService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.deudorService = new DeudorService();
		this.ventaService= new VentaService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Deudor> deudores = deudorService.list();
		req.setAttribute("deudores", deudores);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/deudores/index.jsp");
		dispatcher.forward(req, resp);
	}

}
