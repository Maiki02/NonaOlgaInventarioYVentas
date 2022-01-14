package controller.proveedores;

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

@WebServlet("/deudores/pago.do")
public class PagoProveedorServlet extends HttpServlet {

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
		Integer id=Integer.parseInt(req.getParameter("id"));
		Double importePagado = Double.parseDouble(req.getParameter("importe-pagado"));
		try {
		Deudor deudor= deudorService.find(id);
		deudorService.acreditarPago(deudor, importePagado);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/deudores/index.do");
		dispatcher.forward(req, resp);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
