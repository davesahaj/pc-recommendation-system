package products;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductsDAO;

/**
 * Servlet implementation class PCBuilder
 */
@WebServlet("/PCBuilder")
public class PCBuilder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PCBuilder() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	Product[] getProducts() throws SQLException {

		ProductsDAO Productdao = new ProductsDAO();
		Product[] products = Productdao.fetchProducts();

		return null;

	}

	String compatibilityChecker()
	{
		return null;
	}
	
	void recommendationSet()
	{
		
	}
	
	boolean saveBuild()
	{
		return false;
	}
}
