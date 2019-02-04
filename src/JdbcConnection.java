import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
		
		Statement statementInsert = connection.createStatement();
		//Utilizar um ResultSet para exbir as Keys geradas automaticamente
//		statementInsert.execute("insert into produto (nome, descricao) values ('Notebook','Notebook i7 1TB HD 8GB RAM')", statementInsert.RETURN_GENERATED_KEYS);

		Statement statement = connection.createStatement();
		statement.execute("select * from produto");
		
		ResultSet resultSet = statement.getResultSet();
		
		while(resultSet.next()) {
			System.out.println("Id: "+resultSet.getInt("id"));
			System.out.println("Produto: "+resultSet.getString("nome"));
			System.out.println("Descrição: "+resultSet.getString("descricao")+"\n-----------------------------------------------------------");
		}
		resultSet.close();
		statement.close();
		statementInsert.close();
		connection.close();
	}

}
