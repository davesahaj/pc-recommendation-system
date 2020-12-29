package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import products.Product;

public class ProductTrackerDAO {
	ConnectionImplementer cni = new ConnectionImplementer();

	public String getURL(int id, String platform) throws SQLException {

		String sql = "select product_id as pid, product_price->?->>'url' as url from productprice where product_id=?;";
		String url = null;

		cni.loadDriver(ConnectionProvider.dbdriver);
		Connection con = cni.getConnection();

		PreparedStatement query = con.prepareStatement(sql);
		query.setString(1, platform);
		query.setInt(2, id);

		ResultSet result = query.executeQuery();

		if (result.next()) {

			url = result.getString("url");
		}

		con.close();

		return url;
	}

	public void setPrice(int id, float price, String platform) throws SQLException {

		cni.loadDriver(ConnectionProvider.dbdriver);
		Connection con = cni.getConnection();

		String sql = "update productprice set product_price = jsonb_set(product_price::jsonb, '{" + platform
				+ ",price}', jsonb '" + price + "') where product_id=?;";

		PreparedStatement query = con.prepareStatement(sql);

		query.setInt(1, id);
		query.executeUpdate();

		con.close();
	}

	public void getPrice(int id, String platform) throws SQLException {

		cni.loadDriver(ConnectionProvider.dbdriver);
		Connection con = cni.getConnection();

		String sql = "select product_id as pid, product_price->?->>'price' as price from productprice where product_id=?;";

		PreparedStatement query = con.prepareStatement(sql);

		query = con.prepareStatement(sql);
		query.setString(1, platform);
		query.setInt(2, id);

		ResultSet result = query.executeQuery();

		if (result.next()) {

			System.out.println("Updated price is: " + result.getString("price"));
		}

		con.close();
	}

	public int[] getIDs() throws SQLException {
		String sql = "select * from products";

		cni.loadDriver(ConnectionProvider.dbdriver);
		Connection con = cni.getConnection();

		PreparedStatement query = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet result = query.executeQuery();

		if (result.next()) {

			result.last();
			int[] ids = new int[result.getRow()-1];
			int index = 0;
			result.first();

			while (result.next()) {
				int id = result.getInt("product_id");
				
				ids[index] = id;
				index++;

			}
			
			con.close();

			return ids;
			// user.setUsername(result.getString("username"));

		}

		con.close();

		return null;

	}

	
}
