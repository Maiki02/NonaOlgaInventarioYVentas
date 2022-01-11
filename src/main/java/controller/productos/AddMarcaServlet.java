package controller.productos;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.*;

@WebServlet("/datos/create-marca.do")
public class AddMarcaServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private MarcaService marcaService;

	@Override
	public void init() throws ServletException {
		super.init();
		
		this.marcaService = new MarcaService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String marca= req.getParameter("marca-nueva").trim();
		
		try {
			marcaService.create(marca);
			resp.sendRedirect("/Nonaolga/datos/index.jsp");
		} catch(Exception e) {
			req.setAttribute("flash", "Ocurrio un error para cargar la marca");

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/Nonaolga/datos/index.jsp");
			dispatcher.forward(req, resp);
		}
		

	}
	
	

}
