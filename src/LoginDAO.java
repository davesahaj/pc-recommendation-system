import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	ConnectionImplementer cni = new ConnectionImplementer();

	public String AuthenticateUser(User user) throws SQLException {

		String email = user.getEmail();
		String password = user.getPassword();
		String emailDB = "";
		String passwordDB = "";
		String result = "Data entered successfully";
		String sql = "select email,password from users";

		cni.loadDriver(ConnectionProvider.dbdriver);
		Connection con = cni.getConnection();

		System.out.println("Authenticating...!");
		Statement statement = con.createStatement();
		ResultSet resultset = statement.executeQuery(sql);

		while (resultset.next()) {
			emailDB = resultset.getString("email"); // fetch the values present in database
			passwordDB = resultset.getString("password");

			System.out.println("checking email: " + email + " with " + emailDB);
			System.out.println("checking password: " + password + " with " + passwordDB);

			if (email.equals(emailDB) && password.equals(passwordDB)) {

				System.out.println("Authentication successful!");
				return "SUCCESS";
			}
		}

		System.out.println("Authentication failed!");
		return "Invalid user credentials";
	}
}
