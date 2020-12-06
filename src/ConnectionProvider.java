import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionProvider {

	/*LOCAL CONNECTION
	 * String dburl = "jdbc:postgresql://localhost:5432/recommendationsystem";
	 * String dbuser = "postgres"; String dbpassword = "1234"; String dbdriver =
	 * "org.postgresql.Driver";
	 */

	/*CLOUD CONNECTION*/
	String dburl = "jdbc:postgresql://ec2-52-48-65-240.eu-west-1.compute.amazonaws.com:5432/dflsdgrb1konve?sslmode=require";
	String dbuser = "droujzvutvbxbx";
	String dbpassword = "dc3ed5e6e4cefa35575b10ea1596d11f805bd489594eaefac96975cf121d6c98";
	String dbdriver = "org.postgresql.Driver";
	//exposed at the moment
	public void loadDriver(String dbdriver);

	public Connection getConnection();
}
