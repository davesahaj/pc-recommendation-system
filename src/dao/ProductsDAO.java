package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import products.Product;

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
			

			System.out.println("####################");
			System.out.println(product.getProduct_type());
			System.out.println("####################");

			ps.setString(1, product.getProduct_type());
			ps.setString(2, product.getProduct_brand());
			ps.setString(3, product.getProduct_model());
			ps.setString(4, product.getProduct_speed());
			ps.setInt(5, product.getProduct_cores());
			//ps.setString(6, product.getProduct_info());
			ps.setString(6, product.getProduct_mb_gpu_chipset());
			ps.setInt(7, product.getProduct_mb_slot());
			ps.setString(8, product.getProduct_mb_cpu_socket());
			ps.setInt(9, product.getProduct_ram_gpu_storage_size());
			ps.setString(10, product.getProduct_ram_gpu_type());
			ps.setInt(11, product.getProduct_hdd_rpm());
			ps.setString(12, product.getProduct_storage_gpu_interface());
			ps.setInt(13, product.getProduct_psu_watts());
			ps.setString(14, product.getProduct_psu_efficiency());


			System.out.println("executing statement...");
			ps.executeUpdate();

			System.out.println("Added product...");
			return 1;

		} catch (SQLException e) {
			return 0;
		}
	}

}
