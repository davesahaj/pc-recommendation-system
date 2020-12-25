package users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;

import dao.LoginDAO;
import dao.ProductsDAO;
import products.PCBuilder;
import products.Product;
import products.ProductTracker;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		/*
		 * ProductTracker pt = new ProductTracker(); try {
		 * 
		 * pt.PriceUpdater(10000002, "amazon"); } catch (SQLException e1) {
		 * e1.printStackTrace(); }
		 */
		/*
		 * ProductsDAO Productdao = new ProductsDAO(); Product[] products; try {
		 * products = Productdao.fetchProducts();
		 * 
		 * System.out.println(products[0].getProduct_type() + ", " +
		 * products[0].getProduct_brand() + ", " + products[0].getProduct_model());
		 * System.out.println(products[1].getProduct_type() + ", " +
		 * products[1].getProduct_brand() + ", " + products[1].getProduct_model());
		 * System.out.println(products[2].getProduct_type() + ", " +
		 * products[2].getProduct_brand() + ", " + products[2].getProduct_model()); }
		 * catch (SQLException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */

		LoginDAO Logindao = new LoginDAO();

		try {

			User user = Logindao.AuthenticateUser(email, password);
			String destination = "login.jsp";

			if (user != null && user.getStatus().equals("1")) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
								
				destination = "home.jsp";
				
				SessionManager Sessionmanager = SessionManager.SessionManager();
				Sessionmanager.addUser(user);
				

			} else {
				String message = "Invalid email/password";
				request.setAttribute("message", message);

			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
