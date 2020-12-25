package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import users.User;

public class ProfileDAO {
	ConnectionImplementer cni = new ConnectionImplementer();

	public User update(User newUser, String userName) throws SQLException{

		cni.loadDriver(ConnectionProvider.dbdriver);
		Connection con = cni.getConnection();

		String sql = "UPDATE users SET email=?, password=?,username=? WHERE username=?";

		try {
			PreparedStatement ss = con.prepareStatement(sql);
			ss.setString(1, newUser.getEmail());
			ss.setString(2, newUser.getUsername());
			ss.setString(3, newUser.getPassword());
			ss.setString(4, userName);

			int result = ss.executeUpdate(sql);
			if (result != 0)
				return newUser;
		}

		catch (SQLException e) {
			return null;
		}

		return null;
	}

}
