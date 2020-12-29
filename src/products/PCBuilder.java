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
import users.SessionManager;
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
				budgetSet.add("psu");
				budgetSet.add("cab");
				budgetSet.add("ssd");
				budgetSet.add("gpu");
			}

			else if (category.equals("gaming")) {
				String[] games = request.getParameterValues("game");
				// csgo,cyberpunk,gta,creed,farcry,hitman,cuphead,pubg
				int gamingHoursSlider = Integer.parseInt(request.getParameter("gamingHoursSlider"));
				int gamingPQSlider = Integer.parseInt(request.getParameter("gamingPQSlider"));
				
				cpuPriority = (int) (cpuPriority * gamingHoursSlider * 0.8);
				ramPriority = (int) (ramPriority * gamingPQSlider * 0.5);
				gpuPriority = 3;
				cabPriority = 3;
				
				if(games.length > 4 )
				{
					ssdPriority++;
				}
				
				budgetSet.add("cpu");
				budgetSet.add("gpu");
				budgetSet.add("mb");
				budgetSet.add("ram");
				budgetSet.add("ssd");
				budgetSet.add("psu");
				budgetSet.add("cab");
				budgetSet.add("hdd");

			}

			else if (category.equals("designing")) {

				String[] designSoftware = request.getParameterValues("designSoftware");
				String[] designWork = request.getParameterValues("designWork");
				int designHoursSlider = Integer.parseInt(request.getParameter("designHoursSlider"));
				
				cpuPriority = (int) (cpuPriority * designSoftware.length * 0.8);
				ramPriority = (int) (ramPriority * designWork.length * 0.5);
				ssdPriority++;
				
				if(designSoftware.length > 4 )
				{
					hddPriority++;
				}
				
				budgetSet.add("cpu");
				budgetSet.add("ram");
				budgetSet.add("hdd");
				budgetSet.add("mb");
				budgetSet.add("ssd");
				budgetSet.add("psu");
				budgetSet.add("cab");
				budgetSet.add("gpu");
				
				
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

			try {
				ArrayList<Product> finalBuild = recommendationSet(cpuPriority, mbPriority, cabPriority, ramPriority,
						psuPriority, hddPriority, ssdPriority, gpuPriority, budgetSet, budget);

				Product[] arr = new Product[finalBuild.size()];
				int i = 0;
				for(Product x: finalBuild)
				{
					arr[i++] = x;
				}
				
				request.setAttribute("products", arr);
				request.setAttribute("message", "Hello world");

				for (Product p : finalBuild) {
					System.out.println(p.getProduct_model());
				}

				RequestDispatcher dispatcher = request.getRequestDispatcher("build.jsp");
				dispatcher.forward(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}

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

	ArrayList<Product> recommendationSet(int cpuPriority, int mbPriority, int cabPriority, int ramPriority,
			int psuPriority, int hddPriority, int ssdPriority, int gpuPriority, ArrayList<String> budgetSet, int budget)
			throws SQLException {

		ArrayList<Product> cpus = new ArrayList<Product>();
		ArrayList<Product> mbs = new ArrayList<Product>();
		ArrayList<Product> cabs = new ArrayList<Product>();
		ArrayList<Product> rams = new ArrayList<Product>();
		ArrayList<Product> psus = new ArrayList<Product>();
		ArrayList<Product> hdds = new ArrayList<Product>();
		ArrayList<Product> ssds = new ArrayList<Product>();
		ArrayList<Product> gpus = new ArrayList<Product>();

		Product[] products = getProducts();

		for (Product product : products) {
			String ptype = product.getProduct_type();
			if ((ptype).equals("cpu"))
				cpus.add(product);
			else if ((ptype).equals("mb"))
				mbs.add(product);
			else if ((ptype).equals("cab"))
				cabs.add(product);
			else if ((ptype).equals("ram"))
				rams.add(product);
			else if ((ptype).equals("psu"))
				psus.add(product);
			else if ((ptype).equals("hdd"))
				hdds.add(product);
			else if ((ptype).equals("ssd"))
				ssds.add(product);
			else if ((ptype).equals("gpu"))
				gpus.add(product);
		}

		ArrayList<Product> finalBuild = new ArrayList<Product>();

		if (cpuPriority < 1) {
			cpuPriority = 1;
		}
		if (ramPriority < 1) {
			cpuPriority = 1;
		}

		Product finalCPU = findProduct(cpus, cpuPriority);
		Product finalMB = findProduct(mbs, mbPriority);
		Product finalRAM = findProduct(rams, ramPriority);
		Product finalGPU = findProduct(gpus, gpuPriority);
		Product finalSSD = findProduct(ssds, ssdPriority);
		Product finalHDD = findProduct(hdds, hddPriority);
		Product finalPSU = findProduct(psus, psuPriority);
		Product finalCAB = findProduct(cabs, cabPriority);

		finalBuild.add(finalCPU);
		finalBuild.add(finalMB);
		finalBuild.add(finalPSU);
		finalBuild.add(finalRAM);
		finalBuild.add(finalCAB);
		finalBuild.add(finalHDD);

		if (finalSSD != null) {
			finalBuild.add(finalSSD);
		}

		if (finalGPU != null) {
			finalBuild.add(finalGPU);
		}

		boolean flag = true;
		int index = 0;

		while (flag) {

			int finalBudget = calculateBudget(finalBuild);

			/*for (Product p : finalBuild) {
				System.out.print(p.getProduct_brand() + " " + p.getProduct_model() + ", ");
			}*/

			if (finalBudget < budget) {

				String category = budgetSet.get(index++);

				if (category.equals("cpu") && cpus.size() > 1) {

					cpus.remove(finalCPU);
					finalBuild.remove(finalCPU);

					Product tempProduct = findProduct(cpus, cpuPriority);
					finalBuild.add(tempProduct);

					if (calculateBudget(finalBuild) > budget) {
						finalBuild.remove(tempProduct);
						finalBuild.add(finalCPU);
						cpus.add(finalCPU);

						flag = false;
					} else {
						finalCPU = tempProduct;
					}

				} else if (category.equals("ram") && cpus.size() > 1) {
					rams.remove(finalRAM);
					finalBuild.remove(finalRAM);

					Product tempProduct = findProduct(rams, ramPriority);
					finalBuild.add(tempProduct);

					if (calculateBudget(finalBuild) > budget) {
						finalBuild.remove(tempProduct);
						finalBuild.add(finalRAM);
						rams.add(finalRAM);

						flag = false;
					} else {
						finalRAM = tempProduct;
					}

				} else if (category.equals("mb") && cpus.size() > 1) {
					mbs.remove(finalMB);
					finalBuild.remove(finalMB);

					Product tempProduct = findProduct(mbs, mbPriority);
					finalBuild.add(tempProduct);

					if (calculateBudget(finalBuild) > budget) {
						finalBuild.remove(tempProduct);
						finalBuild.add(finalMB);
						mbs.add(finalMB);

						flag = false;
					} else {
						finalMB = tempProduct;
					}

				} else if (category.equals("hdd") && cpus.size() > 1) {
					hdds.remove(finalHDD);
					finalBuild.remove(finalHDD);

					Product tempProduct = findProduct(hdds, hddPriority);
					finalBuild.add(tempProduct);

					if (calculateBudget(finalBuild) > budget) {
						finalBuild.remove(tempProduct);
						finalBuild.add(finalHDD);
						hdds.add(finalHDD);

						flag = false;
					} else {
						finalHDD = tempProduct;
					}

				} else if (category.equals("gpu") && gpus.size() > 1) {
					gpus.remove(finalGPU);
					finalBuild.remove(finalGPU);

					Product tempProduct = findProduct(gpus, gpuPriority);
					finalBuild.add(tempProduct);

					if (calculateBudget(finalBuild) > budget) {
						finalBuild.remove(tempProduct);
						finalBuild.add(finalGPU);
						gpus.add(finalGPU);

						flag = false;
					} else {
						finalGPU = tempProduct;
					}

				} else if (category.equals("psu") && psus.size() > 1) {
					psus.remove(finalPSU);
					finalBuild.remove(finalPSU);

					Product tempProduct = findProduct(psus, psuPriority);
					finalBuild.add(tempProduct);

					if (calculateBudget(finalBuild) > budget) {
						finalBuild.remove(tempProduct);
						finalBuild.add(finalPSU);
						psus.add(finalPSU);

						flag = false;
					} else {
						finalPSU = tempProduct;
					}

				} else if (category.equals("ssd") && ssds.size() > 1) {
					ssds.remove(finalSSD);
					finalBuild.remove(finalSSD);

					Product tempProduct = findProduct(ssds, ssdPriority);
					finalBuild.add(tempProduct);

					if (calculateBudget(finalBuild) > budget) {
						finalBuild.remove(tempProduct);
						finalBuild.add(finalSSD);
						ssds.add(finalSSD);

						flag = false;
					} else {
						finalSSD = tempProduct;
					}

				} else if (category.equals("cab") && cabs.size() > 1) {
					cabs.remove(finalCAB);
					finalBuild.remove(finalCAB);

					Product tempProduct = findProduct(cabs, cabPriority);
					finalBuild.add(tempProduct);

					if (calculateBudget(finalBuild) > budget) {
						finalBuild.remove(tempProduct);
						finalBuild.add(finalCAB);
						cabs.add(finalCAB);

						flag = false;
					} else {
						finalCAB = tempProduct;
					}

				} else {
					flag = false;
				}
			}

			//System.out.println(finalBudget);
		}
		return finalBuild;
	}

	Product findProduct(ArrayList<Product> items, int priority) {
		// return cheapest object
		if (priority == 0)
			return null;

		int i = 0;

		Product minimunItem = items.get(i++);

		while (minimunItem.getProduct_price() < 0) {
			minimunItem = items.get(i);
		}

		for (Product item : items) {

			if (item.getProduct_price() < minimunItem.getProduct_price() && item.getProduct_price() > 0) {

				minimunItem = item;
			}
		}
		return minimunItem;

	}

	int calculateBudget(ArrayList<Product> finalBuild) {
		int budget = 0;
		for (Product p : finalBuild) {
			if (p != null) {
				budget = budget + p.getProduct_price();
			}
		}

		return budget;
	}

	boolean saveBuild() {
		return false;
	}
}
