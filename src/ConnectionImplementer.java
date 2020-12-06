import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionImplementer implements ConnectionProvider {

	@Override
	public void loadDriver(String dbdriver) {

		try {
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(dburl, dbuser, dbpassword);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cannot connect to the PostgreSQL server.");
		}

		return con;
	}

}