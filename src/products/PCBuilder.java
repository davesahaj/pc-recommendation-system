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

		Product[] product = (Product[]) request.getAttribute("product");

		try {
			recommendationSet(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

	Product[] getProducts() throws SQLException {

		ProductsDAO Productdao = new ProductsDAO();
		Product[] products = Productdao.fetchProducts();

		return products;

	}

	String compatibilityChecker(Product[] products) {
		String compatibility = "okay";

		for (Product product : products) {
			if (!product.getProduct_info().equals("priority:high"))
				compatibility = "fail " + product.getProduct_id();
		}
		return compatibility;

	}

	void recommendationSet(Product[] products) throws SQLException {
		Product[] productlist = getProducts();

		for (Product product : products) {
			for (Product dbproduct : productlist) {
				if (product.getProduct_type() == dbproduct.getProduct_type()) {
					compatibilityChecker(products);
				}
			}
		}
	}

	boolean saveBuild(Product[] products) {
		try {
			ProductsDAO Productsdao = new ProductsDAO();
			for (Product product : products)
				Productsdao.addProduct(product);

			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
