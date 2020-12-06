import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {


	ConnectionImplementer cni = new ConnectionImplementer();

	public String insert(User user) {
		
		cni.loadDriver(ConnectionProvider.dbdriver);
		Connection con = cni.getConnection();
		
		String result = "SUCCESS";
		String sql = "insert into users(email,password,username) values (?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getUsername());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "FAIL";
		}
		return result;
	}

}
