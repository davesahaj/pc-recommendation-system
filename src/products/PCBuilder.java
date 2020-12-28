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

			RequestDispatcher dispatcher = request.getRequestDispatcher("filter.jsp");
			dispatcher.forward(request, response);

		}

		else {
			String category = request.getParameter("category");
			int budget = Integer.parseInt(request.getParameter("budget"));

			ArrayList<String> budgetSet = new ArrayList<String>();

			int cpuPriority = 1;
			int mbPriority = 1;
			int cabPriority = 1;
			int ramPriority = 1;
			int psuPriority = 1;
			int hddPriority = 1;
			int ssdPriority = 0;
			int gpuPriority = 0;

			if (category.equals("casual")) {

				int movieScale = Integer.parseInt(request.getParameter("casualMovieSlider"));
				int officescale = Integer.parseInt(request.getParameter("casualOfficeSlider"));
				int internetScale = Integer.parseInt(request.getParameter("casualInternetSlider"));

				cpuPriority = (int) (cpuPriority * movieScale * 0.5);
				cpuPriority = (int) (cpuPriority * internetScale * 0.3);
				ramPriority = (int) (ramPriority * internetScale * 0.8);

				budgetSet.add("cpu");
				budgetSet.add("ram");
				budgetSet.add("hdd");
				budgetSet.add("mb");
			}

			else if (category.equals("gaming")) {
				String[] games = request.getParameterValues("games");
				// csgo,cyberpunk,gta,creed,farcry,hitman,cuphead,pubg
				int gamingHoursSlider = Integer.parseInt(request.getParameter("gamingHoursSlider"));
				int gamingPQSlider = Integer.parseInt(request.getParameter("gamingPQSlider"));

			}

			else if (category.equals("designing")) {

				String[] designSoftware = request.getParameterValues("designSoftware");
				String[] designWork = request.getParameterValues("designWork");
				int designHoursSlider = Integer.parseInt(request.getParameter("designHoursSlider"));
			}

			else if (category.equals("workstation")) {
				cpuPriority = 10;
				mbPriority = 10;
				cabPriority = 5;
				ramPriority = 10;
				psuPriority = 10;
				hddPriority = 0;
				ssdPriority = 10;
				gpuPriority = 10;
			}

			else if (category.equals("custom")) {

			}

			recommendationSet(
					cpuPriority,
					mbPriority,
					cabPriority,
					ramPriority,
					psuPriority,
					hddPriority,
					ssdPriority,
					gpuPriority,
					budgetSet
					);

		}

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

	void recommendationSet(int cpuPriority, int mbPriority, int cabPriority, int ramPriority, int psuPriority,
			int hddPriority, int ssdPriority, int gpuPriority, ArrayList<String> budgetSet) {
		
		

	}

	boolean saveBuild() {
		return false;
	}
}
