import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {


		Connection connection = DriverManager
				.getConnection("jdbc:mysql://database-1.cmblgshfej2r.us-east-2.rds.amazonaws.com:3306/loja_virtual", "admin", "H8NJJaUJkKm9Qv3");

		
		
		
		connection.close();
		
		System.out.println("teste");
		
	}

}
