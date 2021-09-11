import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//conexao centralizada num unico lugar
public class ConnectionFacotry {

	public Connection recuperarConexao() throws SQLException {


		return DriverManager
				.getConnection("jdbc:mysql://database-1.cmblgshfej2r.us-east-2.rds.amazonaws.com:3306/loja_virtual", "admin", "H8NJJaUJkKm9Qv3");

		
		
		
		//connection.close();
		
		
		
	}

}
