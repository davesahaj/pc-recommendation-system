package users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProfileDAO;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
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
		// TODO Auto-generated method stub

		// option for edit details or change password
		String option = request.getParameter("editOption");

		// newinfo is new info taken from form

		// old info is current user info needed for updation query
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");

		SessionManager Sessionmanager = SessionManager.SessionManager();
		User user = Sessionmanager.getUser(userName);
		

		if (option.equalsIgnoreCase("editDetails")) {
			
			String newUserName = request.getParameter("username");
			String newEmail = request.getParameter("email");
			
			user.setUsername(newUserName);
			user.setEmail(newEmail);

		}

		if (option.equalsIgnoreCase("editPassword")) {

			String newPassword = request.getParameter("newpassword");
			user.setPassword(newPassword);
		}

		try {

			ProfileDAO Profiledao = new ProfileDAO();
			
			User result = Profiledao.update(user,userName);

			if (result!=null) {
				Sessionmanager.removeUser(userName);
				Sessionmanager.addUser(result);
				
				session.setAttribute("user", result.getUsername());
			} else {
				System.out.println("user update failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/profile.jsp").forward(request, response);
		doGet(request, response);

		doGet(request, response);
	}

}
