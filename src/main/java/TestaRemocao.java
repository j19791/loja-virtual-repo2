import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		//recuperar a conexao
		Connection connection = new ConnectionFacotry().recuperarConexao();		
		
		Statement stm = connection.createStatement();		
		
		stm.execute("DELETE FROM produto WHERE id > 2 "); //  
		
		
			
		Integer linhasModificadas = stm.getUpdateCount(); //qtas linhas foram modificadas (deletadas)??
		
		System.out.println("Qtd linhas modificadas: " + linhasModificadas);	
		
		connection.close();
		
		
		
	}

}
