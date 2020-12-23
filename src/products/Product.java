package products;

public class Product {
	private int product_id;
	private String product_type;
	private String product_brand;
	private String product_model;
	private String product_speed;
	private int product_cores;
	private String product_info;
	private String product_mb_gpu_chipset;
	private int product_mb_slot;
	private String product_mb_cpu_socket;
	private int product_ram_gpu_storage_size;
	private String product_ram_gpu_type;
	private int product_hdd_rpm;
	private String product_storage_gpu_interface;
	private int product_psu_watts;
	private String product_psu_efficiency;
	private String product_URL;
	private int product_price;

	// getter-setters

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_URL() {
		return product_URL;
	}

	public void setProduct_URL(String product_URL) {
		this.product_URL = product_URL;
	}

	public String getProduct_mb_cpu_socket() {
		return product_mb_cpu_socket;
	}

	public void setProduct_mb_cpu_socket(String product_mb_socket) {
		this.product_mb_cpu_socket = product_mb_socket;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public String getProduct_model() {
		return product_model;
	}

	public void setProduct_model(String product_model) {
		this.product_model = product_model;
	}

	public String getProduct_speed() {
		return product_speed;
	}

	public void setProduct_speed(String product_speed) {
		this.product_speed = product_speed;
	}

	public int getProduct_cores() {
		return product_cores;
	}

	public void setProduct_cores(int product_cores) {
		this.product_cores = product_cores;
	}

	public String getProduct_info() {
		return product_info;
	}

	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}

	public String getProduct_mb_gpu_chipset() {
		return product_mb_gpu_chipset;
	}

	public void setProduct_mb_gpu_chipset(String product_mb_gpu_chipset) {
		this.product_mb_gpu_chipset = product_mb_gpu_chipset;
	}

	public int getProduct_mb_slot() {
		return product_mb_slot;
	}

	public void setProduct_mb_slot(int product_mb_slot) {
		this.product_mb_slot = product_mb_slot;
	}

	public int getProduct_ram_gpu_storage_size() {
		return product_ram_gpu_storage_size;
	}

	public void setProduct_ram_gpu_storage_size(int product_ram_gpu_storage_size) {
		this.product_ram_gpu_storage_size = product_ram_gpu_storage_size;
	}

	public String getProduct_ram_gpu_type() {
		return product_ram_gpu_type;
	}

	public void setProduct_ram_gpu_type(String product_ram_gpu_type) {
		this.product_ram_gpu_type = product_ram_gpu_type;
	}

	public int getProduct_hdd_rpm() {
		return product_hdd_rpm;
	}

	public void setProduct_hdd_rpm(int product_hdd_rpm) {
		this.product_hdd_rpm = product_hdd_rpm;
	}

	public String getProduct_storage_gpu_interface() {
		return product_storage_gpu_interface;
	}

	public void setProduct_storage_gpu_interface(String product_hdd_gpu_interface) {
		this.product_storage_gpu_interface = product_hdd_gpu_interface;
	}

	public int getProduct_psu_watts() {
		return product_psu_watts;
	}

	public void setProduct_psu_watts(int product_psu_watts) {
		this.product_psu_watts = product_psu_watts;
	}

	public String getProduct_psu_efficiency() {
		return product_psu_efficiency;
	}

	public void setProduct_psu_efficiency(String product_psu_efficiency) {
		this.product_psu_efficiency = product_psu_efficiency;
	}
}
