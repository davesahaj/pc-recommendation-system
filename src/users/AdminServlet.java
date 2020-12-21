package users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import products.Product;
import dao.ProductsDAO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
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

		// Check if request from Admin,-needs to be added, idont know what logic u have
		// so take care of it.
		// String option = request.getParameter("option");
		// using front -controller bcz add,view ,delete can be handled in this one only.

		String ptype = request.getParameter("productType");
		String brand = request.getParameter("brandType");
		String model = request.getParameter("modeltype");

		// CPU
		String cpuSocket = request.getParameter("cpuSocket");
		int cpuCores = Integer.parseInt(request.getParameter("cpuCores"));
		String cpuSpeed = request.getParameter("cpuSpeed");

		// Mboard
		String mbChipset = request.getParameter("mbChipset");
		int mbSlots = Integer.parseInt(request.getParameter("mbSlots"));
		String mbSocket = request.getParameter("mbSocket");

		// RAM
		String ramSpeed = request.getParameter("ramSpeed");
		int ramSize = Integer.parseInt(request.getParameter("ramSize"));
		String ramType = request.getParameter("ramType");

		// GPU

		String gpuChipset = request.getParameter("gpuChipset");
		String gpuInterface = request.getParameter("gpuInterface");
		String gpuType = request.getParameter("gpuType");
		String gpuSpeed = request.getParameter("gpuSpeed");
		int gpuSize = Integer.parseInt(request.getParameter("gpuSize"));

		// PSU
		int psuWatts = Integer.parseInt(request.getParameter("psuWatts"));
		String psuEfficiency = request.getParameter("psuEfficiency");

		// HDD
		int hddSpeed = Integer.parseInt(request.getParameter("hddSpeed"));
		int hddSize = Integer.parseInt(request.getParameter("hddSize"));
		String hddInterface = request.getParameter("hddInterface");

		// SSD
		String ssdInterface = request.getParameter("ssdInterface");
		int ssdSize = Integer.parseInt(request.getParameter("ssdSize"));

		// build Product

		System.out.println("making product...");

		Product product = makeProduct(ptype, brand, model, cpuSocket, cpuCores, cpuSpeed, mbChipset, mbSlots, mbSocket,
				ramSpeed, ramSize, ramType, gpuChipset, gpuInterface, gpuType, gpuSpeed, gpuSize, psuWatts,
				psuEfficiency, hddSpeed, hddSize, hddInterface, ssdInterface, ssdSize);

		System.out.println("Connecting to DAO...");
		ProductsDAO productsDAO = new ProductsDAO();

		try {

			System.out.println("Adding product to DBMS...");
			int result = productsDAO.addProduct(product);

			String message = "";
			if (result == 1) {
				message = "<div class=\"alert alert-success\" role=\"alert\"><strong>done!</strong> The data has been added.</div>";

			} else {
				message = "<div class=\"alert alert-danger\" role=\"alert\"><strong>done!</strong> The data has been added.</div>";

			}

			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("addproduct.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

	public Product makeProduct(String ptype, String brand, String model, String cpuSocket, int cpuCores,
			String cpuSpeed, String mbChipset, int mbSlots, String mbSocket, String ramSpeed, int ramSize,
			String ramType, String gpuChipset, String gpuInterface, String gpuType, String gpuSpeed, int gpuSize,
			int psuWatts, String psuEfficiency, int hddSpeed, int hddSize, String hddInterface, String ssdInterface,
			int ssdSize) {

		Product product = new Product();

		product.setProduct_type(ptype);
		product.setProduct_brand(brand);
		product.setProduct_model(model);

		switch (ptype) {
		case "mb":
			product.setProduct_mb_gpu_chipset(mbChipset);
			product.setProduct_mb_slot(mbSlots);
			product.setProduct_mb_cpu_socket(mbSocket);
			break;

		case "cpu":
			product.setProduct_cores(cpuCores);
			product.setProduct_speed(cpuSpeed);
			product.setProduct_mb_cpu_socket(cpuSocket);
			break;
		case "cab":
			break;

		case "ram":
			product.setProduct_ram_gpu_storage_size(ramSize);
			product.setProduct_ram_gpu_type(ramType);
			product.setProduct_speed(ramSpeed);
			break;

		case "gpu":
			product.setProduct_speed(gpuSpeed);
			product.setProduct_mb_gpu_chipset(gpuChipset);
			product.setProduct_ram_gpu_type(gpuType);
			product.setProduct_ram_gpu_storage_size(gpuSize);
			product.setProduct_storage_gpu_interface(gpuInterface);
			break;
		case "ssd":
			product.setProduct_storage_gpu_interface(ssdInterface);
			product.setProduct_ram_gpu_storage_size(ssdSize);

			break;
		case "hdd":
			product.setProduct_storage_gpu_interface(hddInterface);
			product.setProduct_ram_gpu_storage_size(hddSize);
			product.setProduct_hdd_rpm(hddSpeed);
			break;
		case "psu":
			product.setProduct_psu_watts(psuWatts);
			product.setProduct_psu_efficiency(psuEfficiency);
			break;

		default:
		}

		return product;

	}

}
