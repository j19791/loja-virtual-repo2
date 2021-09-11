import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {


		Connection connection = new ConnectionFacotry().recuperarConexao();

		
		
		
		connection.close();
		
		System.out.println("teste");
		
	}

}
