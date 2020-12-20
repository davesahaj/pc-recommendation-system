package dao;

import java.sql.Statement;

import users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	ConnectionImplementer cni = new ConnectionImplementer();

	public User AuthenticateUser(String email, String password) throws SQLException {


		String sql = "select * from users where email=? and password=?";

		cni.loadDriver(ConnectionProvider.dbdriver);
		Connection con = cni.getConnection();

		PreparedStatement query = con.prepareStatement(sql);
		query.setString(1, email);
		query.setString(2, password);

		ResultSet result = query.executeQuery();

		User user = null;

		if (result.next()) {
			user = new User();
			user.setUsername(result.getString("username"));
			user.setEmail(email);
		}

		con.close();
		
		return user;

	}
}
