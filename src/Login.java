
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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

		////////////////////
		// TEMP CODE FOR WEB SCRAPPER TESTING

		try {
			Document doc = Jsoup.connect("https://www.codetriage.com/?language=Java").get();
			System.out.printf("Title: %s\n", doc.title());
		} catch (IOException e) {
			e.printStackTrace();
		}
		////////////////////

		User user = new User("tempuser", email, password);

		LoginDAO ld = new LoginDAO();
		System.out.println("LoginDAO connected!");
		String userValidate;
		try {
			userValidate = ld.AuthenticateUser(user);

			if (userValidate.equals("SUCCESS")) {
				response.getWriter().print(userValidate);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			} else {
				response.getWriter().print(userValidate);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
