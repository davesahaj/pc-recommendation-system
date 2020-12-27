package products;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductsDAO;
import users.User;

@WebServlet("/PCBuilder")
public class PCBuilder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PCBuilder() {
		super();
	}

	// ArrayList<Product> products = new ArrayList<Product>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String BuilderPageType = request.getParameter("BuilderPageType");
		String message = "Select components for your custom build";

		if (BuilderPageType.equals("categorypage")) {

			int budget = Integer.parseInt(request.getParameter("budget"));
			String category = request.getParameter("category");
			
			if (!category.equals("custom"))
				message = "choose the components you already have, or skip this step";

			request.setAttribute("budget", budget);
			request.setAttribute("category", category);
			request.setAttribute("message", message);
		} else {

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("filter.jsp");
		dispatcher.forward(request, response);

		doGet(request, response);
	}

	Product[] getProducts() throws SQLException {

		ProductsDAO Productdao = new ProductsDAO();
		Product[] products = Productdao.fetchProducts();

		return products;

	}

	String compatibilityChecker() {
		return null;
	}

	void recommendationSet() {

		Product motherboard = new Product();
		motherboard.setProduct_type("mb");
		motherboard.setProduct_price(7500);

		Product ram = new Product();
		ram.setProduct_type("ram");
		ram.setProduct_price(4000);

		Product gpu = new Product();
		gpu.setProduct_type("gpu");
		gpu.setProduct_price(14000);

	}

	boolean saveBuild() {
		return false;
	}
}
