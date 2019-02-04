import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	public static Connection getConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual","SA","");
	}
}
