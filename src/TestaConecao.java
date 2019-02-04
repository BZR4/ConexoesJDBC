import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConecao {

	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConexao();
		Statement statement = connection.createStatement();
		statement.execute("select * from produto");
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString("nome"));
			System.out.println(resultSet.getString("descricao")+"\n---------------------------------------");
		}
		statement.close();
		resultSet.close();
		connection.close();
	}

}
