
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String searchQuery = "iphone 6s";
		String baseUrl = "https://newyork.craigslist.org/";
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		try {
			String searchUrl = baseUrl + "search/sss?sort=rel&query=" + URLEncoder.encode(searchQuery, "UTF-8");
			HtmlPage page = client.getPage(searchUrl);

			List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//li[@class='result-row']");
			if (items.isEmpty()) {
				System.out.println("No items found !");
			} else {
				for (HtmlElement htmlItem : items) {
					HtmlAnchor itemAnchor = ((HtmlAnchor) htmlItem.getFirstByXPath(".//p[@class='result-info']/a"));
					HtmlElement spanPrice = ((HtmlElement) htmlItem
							.getFirstByXPath(".//a/span[@class='result-price']"));

					// It is possible that an item doesn't have any price, we set the price to 0.0
					// in this case
					String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText();

					Item item = new Item();
					item.setTitle(itemAnchor.asText());
					item.setUrl(baseUrl + itemAnchor.getHrefAttribute());

					item.setPrice(new BigDecimal(itemPrice.replace("$", "")));

					ObjectMapper mapper = new ObjectMapper();
					String jsonString = mapper.writeValueAsString(item);

					System.out.println(jsonString);
					PrintWriter writer = response.getWriter();
					String htmlRespone = "<html>";
					htmlRespone += "The json string is: " + jsonString + "</h2>";
					htmlRespone += "</html>";

					// return response
					writer.println(htmlRespone);
				}
			}
		} catch (Exception e) {
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
