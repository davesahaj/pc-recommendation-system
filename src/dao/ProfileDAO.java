package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import users.User;

public class ProfileDAO {
	ConnectionImplementer cni = new ConnectionImplementer();

	public boolean update(User newUser, String userName) throws SQLException {

		cni.loadDriver(ConnectionProvider.dbdriver);
		Connection con = cni.getConnection();

		String sql = "UPDATE users SET email=?, password=?,username=? WHERE username=?";

		try {
			PreparedStatement ss = con.prepareStatement(sql);
			ss.setString(1, newUser.getEmail());
			ss.setString(2, newUser.getPassword());
			ss.setString(3, newUser.getUsername());
			ss.setString(4, userName);

			System.out.println(newUser.getEmail());
			System.out.println(newUser.getUsername());
			System.out.println(newUser.getPassword());
			System.out.println(userName);

			ss.executeUpdate();
			return true;
		}

		catch (SQLException e) {
			return false;
		}
	}

}
