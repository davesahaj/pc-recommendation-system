package dao;
//{"amazon": {"url": "https://www.amazon.in/dp/B0815JJQQ8", "price": ""}, "flipkart": {"url": "www.flipkart.com", "price": "1203"}}
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import products.Product;
import users.User;

public class ProductsDAO {
	ConnectionImplementer cni = new ConnectionImplementer();

	public int addProduct(Product product) {
		cni.loadDriver(ConnectionProvider.dbdriver);
		Connection con = cni.getConnection();

		String sql = "INSERT INTO products" + "(product_type,product_brand,product_model,product_ram_cpu_gpu_speed,"
				+ "product_cpu_cores,product_mb_gpu_chipset,product_mb_slot,product_mb_cpu_socket"
				+ ",product_ram_gpu_storage_size,product_ram_gpu_type,product_hdd_rpm,product_storage_gpu_interface"
				+ ",product_psu_watts,product_psu_efficiency)  " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, product.getProduct_type());
			ps.setString(2, product.getProduct_brand());
			ps.setString(3, product.getProduct_model());
			ps.setString(4, product.getProduct_speed());
			ps.setInt(5, product.getProduct_cores());
			// ps.setString(6, product.getProduct_info());
			ps.setString(6, product.getProduct_mb_gpu_chipset());
			ps.setInt(7, product.getProduct_mb_slot());
			ps.setString(8, product.getProduct_mb_cpu_socket());
			ps.setInt(9, product.getProduct_ram_gpu_storage_size());
			ps.setString(10, product.getProduct_ram_gpu_type());
			ps.setInt(11, product.getProduct_hdd_rpm());
			ps.setString(12, product.getProduct_storage_gpu_interface());
			ps.setInt(13, product.getProduct_psu_watts());
			ps.setString(14, product.getProduct_psu_efficiency());

			ps.executeUpdate();
			
			sql = "INSERT INTO productprice (product_price) values('{\"amazon\":{\"url\":\""+product.getProduct_URL()+"\",\"price\":\"\"},\"flipkart\":{\"url\":\"www.flipkart.com\",\"price\":\"\"}}')";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

			System.out.println("Added product...");
			return 1;

		} catch (SQLException e) {
			return 0;
		}
	}

	public Product[] fetchProducts() throws SQLException {
		String sql = "select * from products";

		cni.loadDriver(ConnectionProvider.dbdriver);
		Connection con = cni.getConnection();

		PreparedStatement query = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet result = query.executeQuery();

		if (result.next()) {

			result.last();
			Product[] products = new Product[result.getRow()-1];
			int index = 0;
			result.first();

			while (result.next()) {
				Product product = new Product();
				// user.setUsername(result.getString("username"));
				product.setProduct_id(result.getInt("product_id"));
				product.setProduct_type(result.getString("product_type"));
				product.setProduct_brand(result.getString("product_brand"));
				product.setProduct_model(result.getString("product_model"));
				product.setProduct_speed(result.getString("product_ram_cpu_gpu_speed"));
				product.setProduct_cores(result.getInt("product_cpu_cores"));
				product.setProduct_info(result.getString("product_info"));
				product.setProduct_mb_gpu_chipset(result.getString("product_mb_gpu_chipset"));
				product.setProduct_mb_slot(result.getInt("product_mb_slot"));
				product.setProduct_mb_cpu_socket(result.getString("product_mb_cpu_socket"));
				product.setProduct_ram_gpu_storage_size(result.getInt("product_ram_gpu_storage_size"));
				product.setProduct_ram_gpu_type(result.getString("product_ram_gpu_type"));
				product.setProduct_hdd_rpm(result.getInt("product_hdd_rpm"));
				product.setProduct_storage_gpu_interface(result.getString("product_storage_gpu_interface"));
				product.setProduct_psu_watts(result.getInt("product_psu_watts"));
				product.setProduct_psu_efficiency(result.getString("product_psu_efficiency"));

				products[index] = product;
				index++;

			}

			return products;

			// user.setUsername(result.getString("username"));

		}

		con.close();

		return null;

	}
}
